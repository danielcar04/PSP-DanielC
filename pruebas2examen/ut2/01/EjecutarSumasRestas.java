public class EjecutarSumasRestas {
    public static void main(String[] args) {
        HiloSumasRestas s1 = new HiloSumasRestas(100, "+");
        HiloSumasRestas s2 = new HiloSumasRestas(100, "-");
        HiloSumasRestas s3 = new HiloSumasRestas(1, "+");
        HiloSumasRestas s4 = new HiloSumasRestas(1, "-");


        Thread h1 = new Thread(s1);
        Thread h2 = new Thread(s2);
        Thread h3 = new Thread(s3);
        Thread h4 = new Thread(s4);

        h1.start();
        h2.start();
        h3.start();
        h4.start();
    }
}
