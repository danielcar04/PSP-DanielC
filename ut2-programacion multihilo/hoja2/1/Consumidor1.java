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
        
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                
            }
            valor = valor+cola1.get(); //recoge el n�mero
            System.out.println("El consumidor "+n+" recoge de la lista");
                               
                              
                               
        }
        System.out.println("El total recogido es "+valor);
    }
}
