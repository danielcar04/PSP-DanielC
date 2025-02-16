public class ParImparEjecutar {

    public static void main(String[] args) {
        HiloParImpar h1 = new HiloParImpar(1);
        HiloParImpar h2 = new HiloParImpar(2);

        Thread hilo1 = new Thread(h1);
        Thread hilo2 = new Thread(h2);

        hilo1.start();
        hilo2.start();
    }
}
