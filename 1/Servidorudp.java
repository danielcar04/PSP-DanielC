import java.io.*;
import java.net.*;
public class Servidorudp {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(12345);
        System.out.println("Servidor esperando datagrama...");
        DatagramPacket recibo=null;
        byte[] bufer = new byte[1024]; // Buffer para recibir el datagrama
        System.out.println("esperando");
         recibo= new DatagramPacket(bufer, bufer.length);
        System.out.println("esperando");
        socket.receive(recibo); // Recibir datagrama	
        System.out.println("esperando");

	    
        // Obtener el mensaje correctamente sin caracteres basura
        String ip = new String(recibo.getData(), 0, recibo.getLength()).trim();
        System.out.println("esperando");
        System.out.println("Servidor recibe: " + ip);

        // Validar si es una IP
        boolean esIp = true;
        if (ip.length() < 8 || ip.length() > 19) {
            esIp = false;
        }
        try {
            InetAddress.getByName(ip);
        } catch (Exception e) {
            esIp = false;
        }

        // Si es una IP válida, convertirla a binario
        if (esIp) {
            String[] octetos = ip.split("\\.");
            StringBuilder binario = new StringBuilder();

            for (String octeto : octetos) {
                int num = Integer.parseInt(octeto); // Convertir a número
                String bin = String.format("%8s", Integer.toBinaryString(num)).replace(' ', '0'); // Asegurar 8 bits
                binario.append(bin).append(".");
            }
            ip = binario.substring(0, binario.length() - 1); // Eliminar el último punto
            System.out.println("IP válida.");
        } else {
            ip = "No válida";
            System.out.println("IP no válida.");
        }

        // Enviar la respuesta al cliente
        byte[] enviados = ip.getBytes(); // Convertir String a bytes
        InetAddress IPOrigen = recibo.getAddress();
        int puerto = recibo.getPort();
        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
        socket.send(envio);
        System.out.println("Respuesta enviada: " + ip);

        socket.close();
    }
}
