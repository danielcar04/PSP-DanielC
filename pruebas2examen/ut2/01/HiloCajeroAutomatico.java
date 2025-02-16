public class HiloCajeroAutomatico {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(1000);

    

        HiloIngresarDinero h1 = new HiloIngresarDinero(cuenta, "Padre", 200);
        HiloSacarDinero h2 = new HiloSacarDinero(cuenta, "Madre", 800);
        HiloIngresarDinero h3 = new HiloIngresarDinero(cuenta, "Hijo1", 300);
        HiloSacarDinero h4 = new HiloSacarDinero(cuenta, "Hijo2", 800);
        HiloSacarDinero h5 = new HiloSacarDinero(cuenta, "Abuelo", 300);


      
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
    }
}
