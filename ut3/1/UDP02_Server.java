import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP02_Server {

	public static void main(String[] args) throws IOException {

		// Asocio el socket al puerto 12345
		DatagramSocket socket = new DatagramSocket(12345);

		System.out.println("Servidor Esperando Datagrama .......... ");
		DatagramPacket recibo;
		
		byte[] bufer = new byte[1024]; // para recibir el datagrama
		recibo = new DatagramPacket(bufer, bufer.length);
		socket.receive(recibo); //recibo datagrama	

	    String mensaje = new String(recibo.getData()).trim();// obtengo String

		System.out.println("Servidor Recibe:" + mensaje);
		
		// DIRECCION ORIGEN DEL MENSAJE
		InetAddress IPOrigen = recibo.getAddress();
		int puerto = recibo.getPort();

		// ENVIANDO DATAGRAMA AL CLIENTE
		System.out.println("Enviando numero "+mensaje);
		byte b = (byte) mensaje.length(); // paso entero a byte
		byte[] enviados = new byte[2];
		enviados[0] = b;
		
		DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
		socket.send(envio);
		
		System.out.println("Servidor Esperando Datagrama .......... ");
		DatagramPacket recibo2;
		
		byte[] bufer2 = new byte[1024]; // para recibir el datagrama
		recibo2 = new DatagramPacket(bufer2, bufer2.length);
		socket.receive(recibo2); //recibo datagrama	

	    String mensaje2 = new String(recibo2.getData()).trim();// obtengo String

		System.out.println("Servidor Recibe:" + mensaje2);
		
		// DIRECCION ORIGEN DEL MENSAJE
		InetAddress IPOrigen2 = recibo2.getAddress();
		int puerto2 = recibo2.getPort();

		// ENVIANDO DATAGRAMA AL CLIENTE
		System.out.println("Enviando numero "+mensaje2);
		byte b2 = (byte) mensaje2.length(); // paso entero a byte
		byte[] enviados2 = new byte[2];
		enviados2[0] = b2;
		
		DatagramPacket envio2 = new DatagramPacket(enviados2, enviados2.length, IPOrigen2, puerto2);
		socket.send(envio2);
	

		
		// CERRAR STREAMS Y SOCKETS
		System.out.println("Cerrando conexion...");
		socket.close();

	}

}
