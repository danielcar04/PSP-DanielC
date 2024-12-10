//Clase Productor: produce números y los pone en la cola usando método "put"
public class Productor2 extends Thread {
    private Cola2 cola2;
   
    private int numero;

    // Constructor recibe la cola y un id para el hilo prodcutor
    public Productor2(Cola2 c, int n) {
        cola2 = c;
       
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            numero = (int) (Math.random() * 10) + 1;
            cola2.put(numero); // escribe el número en la coala
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                
            } 
        }
    }
}
