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
        int valor = 0;
        int valor2=1;
        int comp;
        
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                
            }
            if (n==1){
                comp = cola3.get();
                if (comp%2==0){
                    valor = valor+comp; 
                    System.out.println("El consumidor "+n+" recoge de la lista");
                }
                
            }else if (n==2) {
                comp = cola3.get();
                if (comp%2!=0){
                    valor2 = valor2*comp; 
                    System.out.println("El consumidor "+n+" recoge de la lista");
                }
            }                    
        }
        if (n==1){
            System.out.println("El total recogido es por el consumidor 1 es "+valor);
        }else if (n==2) {
            System.out.println("El total recogido es por el consumidor 2 es "+valor2);
        } 
        
       
    }
}
