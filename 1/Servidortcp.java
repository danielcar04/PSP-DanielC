import java.io.*;
import java.net.*;

public class Servidortcp {
    public static void main(String[] args) throws IOException {
        int pueto = 6666;
        ServerSocket server = new ServerSocket(pueto);
        Socket cliente = null;
        System.out.println("Esperando al cliente.....");
        cliente = server.accept();
        boolean esip=true;
        InputStream entrada = cliente.getInputStream();
        DataInputStream dataentrada = new DataInputStream(entrada);

        String ip = dataentrada.readUTF();
        System.out.println("Recibido "+ip);
        if(ip.length()<8||ip.length()>19){
            esip=false;
        }
        try {
            InetAddress.getByName(ip);
        } catch (Exception e) {
            esip = false;
        }
        if(esip){
             String[] octetos = ip.split("\\.");
        StringBuilder binario = new StringBuilder();

        for (String octeto : octetos) {
            int num = Integer.parseInt(octeto); // Convertir a número
            String bin = String.format("%8s", Integer.toBinaryString(num)).replace(' ', '0'); // Asegurar 8 bits
            binario.append(bin).append(".");
        }

        // Eliminar el último punto
        ip= binario.substring(0, binario.length() - 1);
        System.out.println("IP valida");
        }else{
            ip="No valida";
            System.out.println("Ip no valida");
        }

        OutputStream salida = cliente.getOutputStream();
        DataOutputStream datasalida = new DataOutputStream(salida);
        System.out.println("Enviando "+ip);
        datasalida.writeUTF(ip);

        dataentrada.close();
        datasalida.close();
        server.close();

    }
}
