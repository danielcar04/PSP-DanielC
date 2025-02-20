import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class cliente1 {
       public static void main(String[] args) throws Exception {
        String Host = "192.168.114.104";
        int Puerto = 6666;// puerto remoto

        System.out.println("PROGRAMA CLIENTE INICIADO....");
        Socket Cliente = new Socket(Host, Puerto);
        
        //Hago que el usuario escriba el numero
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe un numero");
        String ip = teclado.next();
        
        //envio el numero al servidor
        DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
        flujoSalida.writeUTF(ip);
        System.out.println("Enviando numero " +ip);




        //recibo el factorial del servidor
        DataInputStream flujoEntrada = new  DataInputStream(Cliente.getInputStream());
        String resultado = flujoEntrada.readUTF();
        if (resultado.equals("No valida")){
            System.out.println("La ip "+ip+" no es valida");
        }else{
            System.out.println("La ip "+ip+" en binario es "+resultado);
        }


    
        
        // CERRAR STREAMS Y SOCKETS	
        flujoSalida.close();
        flujoEntrada.close();		
        Cliente.close();	
    }
}