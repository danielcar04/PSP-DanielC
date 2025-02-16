package t1;
import java.io.*;
import java.net.*;
public class Servidor {
    public static void main(String[] args) throws IOException {
        int puerto = 6666;
        ServerSocket socket = new ServerSocket(puerto);
        Socket cliente1 = null;
        Socket cliente2 = null;
        System.out.println("Esperando al cliente.....");
        cliente1 = socket.accept();
        cliente2 = socket.accept();
        InputStream entrada = null;
        entrada = cliente1.getInputStream();
        DataInputStream dataentrada = new DataInputStream(entrada);

        int num = dataentrada.readInt();
        System.out.println("Recibido "+num);
        OutputStream salida = null;
        salida = cliente2.getOutputStream();
        DataOutputStream datasalida = new DataOutputStream(salida);

        datasalida.writeInt(num);
        System.out.println("enviado "+num);
        InputStream entrada2 = null;
        entrada2 = cliente2.getInputStream();
        DataInputStream dataentrada2 = new DataInputStream(entrada2);

         num = dataentrada2.readInt();
         System.out.println("Recibido "+num);
         OutputStream salida2 = null;
        salida2 = cliente1.getOutputStream();
        DataOutputStream datasalida2 = new DataOutputStream(salida2);

        datasalida2.writeInt(num);
        System.out.println("enviado "+num);
        dataentrada.close();
        dataentrada2.close();
        datasalida.close();
        datasalida2.close();
        socket.close();
    }
}
