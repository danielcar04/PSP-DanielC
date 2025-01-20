public class Caja extends Thread{
    private Supermercado supermercado;
    private int n;
    private int cliente = 0;
    public Caja(Supermercado c, int n){
        supermercado = c;
        this.n = n;
    }
    public void run(){
        for (int i = 0; i <= 5; i++) {
            cliente =supermercado.atender(n, cliente);
            try {
                Thread.sleep(cliente*100);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
