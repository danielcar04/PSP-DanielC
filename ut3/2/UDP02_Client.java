import java.net.*;
import java.nio.ByteBuffer;
import java.util.Random;

public class UDP02_Client {
    public static void main(String[] args) throws Exception {
        String servidor = "192.168.114.119";
        int puerto = 6666;
        Random random = new Random();
        int[] numeros = new int[10]; // Array a enviar
        
        // Generar 10 números aleatorios
        for (int i = 0; i < 10; i++) {
            numeros[i] = random.nextInt(10);
        }
        
        // Convertir el array de enteros a bytes
        ByteBuffer buffer = ByteBuffer.allocate(numeros.length * 4); // Cada entero ocupa 4 bytes
        for (int num : numeros) {
            buffer.putInt(num);
        }
        byte[] array = buffer.array(); // Convertir a bytes

        // Crear un DatagramSocket para enviar el mensaje
        DatagramSocket socket = new DatagramSocket();

        // Crear un DatagramPacket para enviar los datos
        DatagramPacket paquete = new DatagramPacket(array, array.length, InetAddress.getByName(servidor), puerto);
        
        // Enviar el array de bytes
        socket.send(paquete);
        System.out.println("Array enviado al servidor.");

        // Preparar para recibir respuesta del servidor
		DatagramPacket recibo;
		
		byte[] bufer = new byte[1024]; // para recibir el datagrama
		recibo = new DatagramPacket(bufer, bufer.length);
		socket.receive(recibo); //recibo datagrama	

		byte[] hh2 = recibo.getData();
		int numero2 = hh2[0];

		System.out.println("Servidor Recibe:" + numero2);

        // Cerrar el socket
        socket.close();
    }
}
