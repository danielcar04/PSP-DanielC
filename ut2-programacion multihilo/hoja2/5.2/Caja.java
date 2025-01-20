public class Caja extends Thread{
    private Supermercado supermercado;
    private int n;
    private int cliente = 0;
    public Caja(Supermercado c, int n){
        supermercado = c;
        this.n = n;
    }
    public void run(){
        while(cliente != -1){
            cliente =supermercado.atender(n, cliente);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
