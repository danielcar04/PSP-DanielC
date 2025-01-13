
public class Productor extends Thread {
    private Deposito deposito;

    private double numero;

    public Productor(Deposito c) {
        deposito = c;
       
    }

    public void run() {
        for (int i = 0; i < 15; i++) {
            numero = (double) (Math.random() * 1000) + 1;
            numero = Math.round(numero*100.0)/100.0;
            deposito.put(numero); 
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {}
                            
        }
        
    }
}


