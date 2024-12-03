
import java.util.concurrent.ArrayBlockingQueue;

public class Cola3 {
    private int numero;
	public static ArrayBlockingQueue<Integer>lista = new ArrayBlockingQueue<>(5);

    //métodos sincronizados -> productor y consumidor no podrán acceder simultáneamente al objeto Cola COMPARTIDO
    // Mientras el productor esté cambiando valor en la cola el consumidor no puede recogerlo y viceversa
    
    // Necesaria COORDINACIÓN !!! 
    //  * cuando el productor ponga número en la cola -> avisará al consumidor. Prodcutor deberá esperar cola esté vacía para generar nuevo dato
    //  * cuando el consumidor recoga número de cola -> avisará al productor cola está vacía. Consumidor debe esparar a que cola tenga datos
    
    // COORDINACIÓN uso métodos wait(), notify() y notifyAll(). Sólo pueden usarse desde métodos sincronizados o dentro bloque sincronizado
    
    // *wait(): un hilo que llama al método wait() de un objeto queda suspendido hasta que otro hilo llame a notify()-notifyAll() del mismo objeto
    // *notify(): despierta o activa a uno de los hilos que realizó llamada a wait(). Si varios hilos esperan, solo uno de ellos será elegido para continuar (elección aleatoria)
    // *notify(): despierta o activa a todos hilos estén esperando el objeto
   
    
    public synchronized int get() {
       if (lista.peek()==null) {
		try {
			wait(100);
		} catch (Exception e) {
			// TODO: handle exception
		}
	   }  
	   try {    
		numero = lista.take();
		notify();	
  } catch (InterruptedException e) { }
	   return numero;
    	}


    public synchronized void put(int valor) {
    	  if (lista.size()==5) {
			notify();
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		  }
		  lista.offer(valor);
    	}


    
}
