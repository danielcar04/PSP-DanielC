public class Deposito extends Thread {
    static int litros = 0;
    static boolean repostando=false;

    public synchronized int get(int n){
        while (litros == 0 ) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        repostando = true;
        int num = litros;
        System.out.println("Camión "+n+" rellena "+num+" Litros");
        litros = 0;
        repostando = false;
        notify();
        return num;
    }

    public synchronized void set(int cantidad){
        while(litros != 0 ){
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        litros = cantidad;
        System.out.println("Productor Introduce "+cantidad);
        notifyAll();
    }
}
