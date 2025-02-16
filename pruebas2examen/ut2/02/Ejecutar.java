public class Ejecutar {
    public static void main(String[] args) {
        Almacen a = new Almacen();

        Productor p = new Productor(a);
        Consumidor c1 = new Consumidor(a,1);
        Consumidor c2 = new Consumidor(a,2);
        p.start();
        c1.start();
        c2.start();
    }
}
