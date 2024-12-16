//Clase consumidor: recoge número de la cola con método "get"
public class Consumidor2 extends Thread {
    private Cola2 cola2;
    private int n;

    // Constructor recibe la cola y un id para el hilo consumidor
    public Consumidor2(Cola2 c, int n) {
        cola2 = c;
        this.n = n;
    }

    public void run() {
        int valor = 0;
        int valor2 = 0;
        int llev = 0;
        for (int i = 0; i < 10; i++) {
            llev = cola2.get(n);
            if (n == 1) {
                valor = valor + llev;   
            } else if (n == 2) {
                valor2 = valor2 + llev;  
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                
            } 
            
        }
        if (n == 1) {
            System.out.println("El total recogido es por el consumidor 1 es " + valor);
        } else if (n == 2) {
            System.out.println("El total recogido es por el consumidor 2 es " + valor2);
        }

    }
}
