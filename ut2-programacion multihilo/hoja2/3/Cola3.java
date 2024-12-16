
import java.util.concurrent.ArrayBlockingQueue;

public class Cola3 {
	private int numero;
	public static ArrayBlockingQueue<Integer> lista = new ArrayBlockingQueue<>(5);
	private boolean c1 = false;
	private boolean c2 = false;

	public synchronized int get(int n) {
		boolean modif = false;
		if (c1 == true && c2==true){
			System.out.println("el coonsumidor " +n+" elimina -------->"+lista.peek());
			lista.remove();
			c1=false;
			c2=false;
		}
		if (lista.size() == 0) {
			try {
				System.out.println("El consumidor " + n + " espera ");	
				wait();
			} catch (Exception e) {}
		}	
		numero = lista.peek();	
		if(n==1){
			c1=true;
			if(numero%2==0){
				System.out.println("El consumidor " + n + " recoge de la lista " + numero);	
				modif = true;
			}
		}
		if(n==2){
			c2=true;
			if(numero%2!=0){
				System.out.println("El consumidor " + n + " recoge de la lista " + numero);	
				modif = true;
			}
		}
		if (modif == false){
			numero=-1;
		}
		
		notifyAll();
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
		notifyAll();
	}

    
}
