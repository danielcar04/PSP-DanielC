public class Ejecutar {
    public static void main(String[] args) {
        Deposito deposito = new Deposito();

        Productor p = new Productor(deposito);

        Consumidor c1 = new Consumidor(deposito, 1);
        Consumidor c2 = new Consumidor(deposito, 2);
        Consumidor c3 = new Consumidor(deposito, 3);

        p.start();
        c1.start();
        c2.start();
        c3.start();
    }
}
