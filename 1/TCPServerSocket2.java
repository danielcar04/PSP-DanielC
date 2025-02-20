import java.io.*;
import java.net.*;

public class TCPServerSocket2 {
  public static void main(String[] arg) throws IOException {
	int numeroPuerto = 6666;// Puerto
	ServerSocket servidor = new ServerSocket(numeroPuerto);
	Socket clienteConectado = null;
	Socket clienteConectado2 = null;
	System.out.println("Esperando al cliente.....");
	clienteConectado = servidor.accept();
	clienteConectado2 = servidor.accept();
	// Creación flujo de entrada del cliente
	System.out.println("Clientes encontrados");
	InputStream entrada = null;
	entrada = clienteConectado.getInputStream();
	DataInputStream flujoEntrada = new DataInputStream(entrada);

	//Recibiendo datos del cliente ...
	 int a =flujoEntrada.readInt();
	 System.out.println("Recibido "+a);
	// Creación flujo de entrada del cliente
	OutputStream salida = null;
	salida = clienteConectado2.getOutputStream();
	DataOutputStream flujoSalida = new DataOutputStream(salida);

	//Enviando datos al cliente
	flujoSalida.writeInt(a);
	System.out.println("Enviando "+a);
	// Cierre streams y sockets
	

	InputStream entrada2 = null;
	entrada2 = clienteConectado2.getInputStream();
	DataInputStream flujoEntrada2 = new DataInputStream(entrada2);
	System.out.println("Esperando ");
	//Recibiendo datos del cliente ...
	 int a2 =flujoEntrada2.readInt();
	 System.out.println("recibido "+a2);
	// Creación flujo de entrada del cliente
	OutputStream salida2 = null;
	salida2 = clienteConectado.getOutputStream();
	DataOutputStream flujoSalida2 = new DataOutputStream(salida2);
	flujoSalida2.writeInt(a2);
	System.out.println("Enviado " +a2);
	entrada.close();
	flujoEntrada.close();

	salida.close();
	flujoSalida.close();
	entrada2.close();
	flujoEntrada2.close();

	salida2.close();
	flujoSalida2.close();

	clienteConectado.close();
	clienteConectado2.close();
	servidor.close();
  }// main
}// fin
