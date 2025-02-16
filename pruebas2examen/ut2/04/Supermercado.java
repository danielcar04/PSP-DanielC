import java.util.concurrent.ArrayBlockingQueue;

public class Supermercado extends Thread{
    public static ArrayBlockingQueue<Integer>lista = new ArrayBlockingQueue<>(3);

    public static int contador = 0;

    public synchronized void entrar(int num){
        while (lista.size()==3) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        lista.offer(num);
        notifyAll();
    }
    public synchronized int atender(int caja, int cliente){
        if (cliente != 0){
            System.out.println("Caja "+caja+" Terminó de atender al cliente "+cliente);
        }
        if(contador>=15){
            return -1;
        }
        while (lista.size()==0) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        contador +=1;
        try {
            cliente = lista.take();
            notifyAll();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Caja "+caja+" empieza a atender al cliente "+cliente);
        return cliente;
    }
    
}
