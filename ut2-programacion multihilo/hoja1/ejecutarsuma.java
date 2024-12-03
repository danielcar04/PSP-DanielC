public class ejecutarsuma {
    public static void main(String[] args) {
        HiloSumasRestas e1 = new HiloSumasRestas(200, "-");
    HiloSumasRestas e2 = new HiloSumasRestas(100, "+");
    HiloSumasRestas e3 = new HiloSumasRestas(1, "-");
    HiloSumasRestas e4 = new HiloSumasRestas(1, "+");
    e1.run();
    e2.run();
    e3.run();
    e4.run();
    }
}
