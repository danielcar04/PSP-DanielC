import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Random;

public class TCPClientSocket2 {
    public static void main(String[] args) throws Exception{
        String servidor = "192.168.114.119";
        int puerto = 6666;
		Random random = new Random();
        int[] numeros = new int [10]; // Array a enviar
		for (int i = 0;i<10;i++){
			numeros[i]= random.nextInt(10);
		}
		ByteBuffer buffer = ByteBuffer.allocate(numeros.length * 4); // Cada entero ocupa 4 bytes
        for (int num : numeros) {
            buffer.putInt(num);
        }
        byte[] array = buffer.array(); // Convertir a bytes

        Socket socket = new Socket(servidor, puerto);
            DataOutputStream flujoSalida = new DataOutputStream(socket.getOutputStream());

            // Enviar la cantidad de bytes primero
            flujoSalida.writeInt(array.length);
            
            // Enviar el array de bytes
            flujoSalida.write(array);

            System.out.println("Array enviado al servidor.");
			DataInputStream flujoEntrada = new  DataInputStream(socket.getInputStream());

	// 
		System.out.println("Recibiendo del SERVIDOR: \n\t" + flujoEntrada.readInt());

		socket.close();
        
    }

   
}

