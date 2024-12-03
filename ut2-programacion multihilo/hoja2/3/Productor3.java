//Clase Productor: produce números y los pone en la cola usando método "put"
public class Productor3 extends Thread {
    private Cola3 cola3;
    private int n;
    private int numero;
    //Constructor recibe la cola y un id para el hilo prodcutor
    public Productor3(Cola3 c, int n) {
        cola3 = c;
        this.n = n;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            numero = (int) (Math.random() * 10) + 1;
            cola3.put(numero); //escribe el número en la coala
            System.out.println("el productor "+n+" produce "+numero);
                               try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                
                            }
        }
    }
}


