import java.io.*;
import java.net.*;

public class UDPObjetoServidor1 {
  public static void main(String[] arg) throws IOException,
						ClassNotFoundException {
   int numeroPuerto = 6000;// Puerto
   DatagramSocket socket = new DatagramSocket(numeroPuerto);
   byte[] receiveData = new byte[1024];
 
   System.out.println("Esperando al cliente.....");   
 

   String tipo;
   double iva = 0;
   double importeTotal;

   DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
   socket.receive(receivePacket);
   
   ByteArrayInputStream byteStream = new ByteArrayInputStream(receivePacket.getData());
   ObjectInputStream objectStream = new ObjectInputStream(byteStream);
   Object receivedObject = objectStream.readObject();

   Factura factura = (Factura) receivedObject;

   System.out.println("Recibo: "+factura.getNumerofactura()+"*"+factura.getImporte());

   tipo = factura.getTipo();
   if (tipo.equals("IGC")){
    iva = factura.getImporte() * 0.7;
   }else if (tipo.equals("ESP")){
    iva = factura.getImporte() * 0.21;
   }else if (tipo.equals("EUR")){
    iva = factura.getImporte() * 0.15;
   }

   importeTotal = factura.getImporte() + iva;

	factura.setIva(iva);
    factura.setImportetotal(importeTotal);

    InetAddress IPAddress = receivePacket.getAddress();
    int port = receivePacket.getPort();

    ByteArrayOutputStream byteStream2 = new ByteArrayOutputStream();
    ObjectOutputStream objectStream2 = new ObjectOutputStream(byteStream2);

    objectStream2.writeObject(factura);

    byte[] sendData = byteStream2.toByteArray();
            
    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
    socket.send(sendPacket);

  System.out.println("enviado");
  }
}