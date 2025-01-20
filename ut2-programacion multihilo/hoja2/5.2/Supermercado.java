import java.util.concurrent.ArrayBlockingQueue;

public class Supermercado {
    private int numero;
    private int contador = 0;
    public static ArrayBlockingQueue<Integer>cola = new ArrayBlockingQueue<>(3);
    public synchronized void esperar(int n){
        while(cola.size() == 3){
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        cola.offer(n);
        notifyAll();
    }
    public synchronized int atender(int n,int cliente){
        
        if (cliente != 0){
            System.out.println("caja "+n+" termino de atender al cliente "+cliente );
        }
        if(contador >= 15){
            return -1;
        }else{
        while (cola.size() == 0) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        try {
            numero = cola.take();
            contador +=1;
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("caja "+n+" atendiendo al cliente "+numero);
        notifyAll();
        return numero;
    }
    }
}
