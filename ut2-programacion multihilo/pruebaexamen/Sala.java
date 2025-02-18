import java.util.concurrent.ArrayBlockingQueue;

public class Sala {
    public static ArrayBlockingQueue<Integer> lista = new ArrayBlockingQueue<>(5);

    public synchronized void entrar(int cliente){
        while (lista.size()==5) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        lista.offer(cliente);
        System.out.println("entra a la sala el cliente -------->"+cliente);
    }

    public synchronized void salir(){
       try {
        System.out.println("sale de la sala el cliente <--------"+lista.take());
        notify();
       } catch (Exception e) {
        // TODO: handle exception
       }
        
    }


}
