import java.io.*;
import java.net.*;
import java.util.Scanner;

public class cliente2 {
    public static void main(String[] args) throws IOException {
        DatagramSocket clientSocket = new DatagramSocket();
        String destino = "192.168.114.104";
        InetAddress IPServidor = InetAddress.getByName(destino);
        int port = 12345;

        // Pedimos un String al usuario
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe un mensaje:");
        String mensaje = teclado.next(); // Leemos el mensaje completo

        // Convertimos el String a bytes
        byte[] datosEnvio = mensaje.getBytes();

        // Enviamos el mensaje al servidor
        DatagramPacket envio = new DatagramPacket(datosEnvio, datosEnvio.length, IPServidor, port);
        clientSocket.send(envio);
        System.out.println("Mensaje enviado: " + mensaje);

        // Recibimos la respuesta del servidor
        System.out.println("esperando");
        byte[] bufferRecibido = new byte[1024]; // Buffer suficientemente grande para recibir datos
        DatagramPacket recibo = new DatagramPacket(bufferRecibido, bufferRecibido.length);
        clientSocket.receive(recibo);

        // Convertimos los bytes recibidos a un String
        String mensajeRecibido = new String(recibo.getData(), 0, recibo.getLength());
        System.out.println("Respuesta del servidor: " + mensajeRecibido);

        // Cerramos el socket
        clientSocket.close();
    }
}
