//Clase Productor: produce números y los pone en la cola usando método "put"
public class Productor1 extends Thread {
    private Cola1 cola1;
    private int n;
    private int numero;
    //Constructor recibe la cola y un id para el hilo prodcutor
    public Productor1(Cola1 c, int n) {
        cola1 = c;
        this.n = n;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            
            numero = (int) (Math.random() * 10) + 1;
            cola1.put(numero); //escribe el número en la coala
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                
            }                 
            
        }
    }
}


