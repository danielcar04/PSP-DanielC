public class Cliente extends Thread {
    private Supermercado supermercado;
    private int n;
    private int caja;

    public Cliente(Supermercado c, int n) {
        supermercado = c;
        this.n = n;
    }

    public void run() {
       caja = supermercado.atender(n);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        supermercado.cobrando(caja,n);
    }
    
}
