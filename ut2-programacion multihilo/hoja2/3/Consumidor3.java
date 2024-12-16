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
        
        for (int i = 0; i < 10; i++) {
            comp = cola3.get(n);
            if (n==1){
                
                if (comp%2==0){
                    if(valor!=-1){
                    valor = valor+comp; 
                    }
                }
                
            }else if (n==2) {
               
                if (comp%2!=0 || comp==1){
                    if(valor!=-1){
                    valor2 = valor2+comp; 
                    }
                }
            } 
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                
            }                   
        }
        if (n==1){
            System.out.println("El total recogido es por el consumidor 1 es "+valor);
        }else if (n==2) {
            System.out.println("El total recogido es por el consumidor 2 es "+valor2);
        } 
        
       
    }
}
