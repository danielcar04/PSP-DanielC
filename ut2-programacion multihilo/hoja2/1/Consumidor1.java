//Clase consumidor: recoge número de la cola con método "get"
public class Consumidor1 extends Thread {
    private Cola1 cola1;
    private int n;

    //Constructor recibe la cola y un id para el hilo consumidor
    public Consumidor1(Cola1 c, int n) {
        cola1 = c;
        this.n = n;
    }

    public void run() {
        int valor = 0;
        int llev=0;
        for (int i = 0; i < 10; i++) {
            
            llev=cola1.get();
            valor = valor+llev; //recoge el n�mero
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                
            }  
                      
                              
                               
        }
        System.out.println("El total recogido es "+valor);
    }
}
