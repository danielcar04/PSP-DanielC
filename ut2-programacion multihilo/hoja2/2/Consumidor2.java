//Clase consumidor: recoge número de la cola con método "get"
public class Consumidor2 extends Thread {
    private Cola2 cola2;
    private int n;

    //Constructor recibe la cola y un id para el hilo consumidor
    public Consumidor2(Cola2 c, int n) {
        cola2 = c;
        this.n = n;
    }

    public void run() {
        int valor = 0;
        int valor2=1;
        
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                
            }
            if (n==1){
                valor = valor+cola2.get(); 
                System.out.println("El consumidor "+n+" recoge de la lista");
            }else if (n==2) {
                valor2 = valor2*cola2.get(); 
                System.out.println("El consumidor "+n+" recoge de la lista");
            }                    
        }
        if (n==1){
            System.out.println("El total recogido es por el consumidor 1 es "+valor);
        }else if (n==2) {
            System.out.println("El total recogido es por el consumidor 2 es "+valor2);
        } 
        
       
    }
}
