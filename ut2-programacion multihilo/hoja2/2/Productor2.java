//Clase Productor: produce números y los pone en la cola usando método "put"
public class Productor2 extends Thread {
    private Cola2 cola2;
    private int n;
    private int numero;
    //Constructor recibe la cola y un id para el hilo prodcutor
    public Productor2(Cola2 c, int n) {
        cola2 = c;
        this.n = n;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            numero = (int) (Math.random() * 10) + 1;
            cola2.put(numero); //escribe el número en la coala
            System.out.println("el productor "+n+" produce "+numero);
                               try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                
                            }
        }
    }
}


