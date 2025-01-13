//Clase consumidor: recoge número de la cola con método "get"
public class Consumidor3 extends Thread {
    private Cola3 cola3;
    private int n;

    //Constructor recibe la cola y un id para el hilo consumidor
    public Consumidor3(Cola3 c, int n) {
        cola3 = c;
        this.n = n;
    }

    public void run() {
        int num=0;
            for (int i = 0; i < 5; i++) {
                num= num + cola3.get(n);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    
                }                        
            }
            System.out.println("Camion "+n+" se va a su destino con un total de "+num+" litros");  
        }
}
