import java.util.concurrent.ArrayBlockingQueue;

public class Almacen extends Thread{
    int numero;
    public static ArrayBlockingQueue<Integer>lista = new ArrayBlockingQueue<>(5);

    synchronized int get(int tipo) {
        try{
        while(lista.size()==0){
                wait();
        }
        numero=lista.take();
        System.out.println("Consumidor "+tipo+" consume "+numero);
        notify();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return numero;
    }
    synchronized void put(int producido){
        try{
            while(lista.size()==5){
                wait();
            }
            lista.offer(producido);
            System.out.println("Productor Produce "+producido);
            notify();
        }catch(Exception e){

        }
        
    }
}
