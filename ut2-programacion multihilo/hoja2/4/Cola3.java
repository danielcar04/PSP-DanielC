
import java.util.concurrent.ArrayBlockingQueue;

public class Cola3 {
	private int numero;
	public static ArrayBlockingQueue<Integer> lista = new ArrayBlockingQueue<>(5);
	public synchronized int get(int n) {
		
		while(lista.size() == 0) {
			notifyAll();
			try {
				wait();
			} catch (Exception e) {}
		}	
		try {    
			numero = lista.take();
			System.out.println("Camion "+n+" Carga: "+numero+" Litros");   
			notifyAll();	
	  } catch (InterruptedException e) { }
		   return numero;
	}

	public synchronized void put(int valor) {
		if (lista.size() == 1) {
			notifyAll();
			try {
				wait();
			} catch (Exception e) {
			}
		}
		lista.offer(valor);
		System.out.println("el productor llena el deposito con: " + valor+" litros");
		notifyAll();
	}

    
}
