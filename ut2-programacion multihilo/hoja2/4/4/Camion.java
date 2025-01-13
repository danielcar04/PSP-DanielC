//Clase consumidor: recoge número de la cola con método "get"
public class Camion extends Thread {
    private Deposito deposito;
    private int n;

    //Constructor recibe la cola y un id para el hilo consumidor
    public Camion(Deposito c, int n) {
        deposito = c;
        this.n = n;
    }

    public void run() {
        double num=0;
            for (int i = 0; i < 5; i++) {
                num= num + deposito.get(n);
                if (i==4){
                    num = Math.round(num*100.0)/100.0;
                    System.out.println("Camion "+n+" se va a su destino con un total de "+num+" litros");  
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    
                }                        
            }
            
        }
}
