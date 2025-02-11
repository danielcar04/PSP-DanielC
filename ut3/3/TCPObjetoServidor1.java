import java.io.*;
import java.net.*;

public class TCPObjetoServidor1 {
  public static void main(String[] arg) throws IOException,
						ClassNotFoundException {
   int numeroPuerto = 6000;// Puerto
   ServerSocket servidor =  new ServerSocket(numeroPuerto);
   System.out.println("Esperando al cliente.....");   
   Socket cliente = servidor.accept();

   String tipo;
   double iva = 0;
   double importeTotal;

   ObjectInputStream inObjeto = new ObjectInputStream(
   cliente.getInputStream());

   Factura factura = (Factura) inObjeto.readObject();

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

   ObjectOutputStream outObjeto = new ObjectOutputStream(
				cliente.getOutputStream()); 	

   outObjeto.writeObject(factura); 
   System.out.println("Envio: " + factura.getNumerofactura()+" iva "+factura.getIva()+ " total "+factura.getImportetotal());  
		
   // CERRAR STREAMS Y SOCKETS
   outObjeto.close();
   inObjeto.close();
   cliente.close();
   servidor.close();
  }
}//..
