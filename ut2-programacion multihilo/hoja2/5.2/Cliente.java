public class Cliente extends Thread{
    private Supermercado supermercado;
    private int n;
    private int caja;

    public Cliente(Supermercado c, int n) {
        supermercado = c;
        this.n = n;
    }

    public void run() {
        supermercado.esperar(n);
    }
}
