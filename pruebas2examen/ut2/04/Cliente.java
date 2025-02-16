public class Cliente extends Thread {
    Supermercado supermercado;

    int c;

    Cliente(Supermercado supermercado, int c ){
        this.supermercado = supermercado;
        this.c = c;
    }

    public void run(){
        supermercado.entrar(c);
    }
}
