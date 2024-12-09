
import java.util.concurrent.ArrayBlockingQueue;

public class Cola2 {
	private int numero;
	public static ArrayBlockingQueue<Integer> lista = new ArrayBlockingQueue<>(5);
	private int veces = 0;

	public synchronized int get(int n) {
		if (veces == 2) {
			veces = 0;
			try {
				lista.take();
			} catch (InterruptedException e) {}
		}
		if (lista.size() == 0) {
			try {
				wait();
			} catch (Exception e) {}
		}
		
			numero = lista.peek();	
			veces = veces +1;
			
			System.out.println("El consumidor " + n + " recoge de la lista " + numero);		
			notify();
		return numero;
	}

	public synchronized void put(int valor) {
		if (lista.size() == 5) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		lista.offer(valor);
		System.out.println("el productor produce " + valor);
		notify();
	}

}
