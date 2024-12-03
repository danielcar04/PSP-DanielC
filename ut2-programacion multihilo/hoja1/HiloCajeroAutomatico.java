public class HiloCajeroAutomatico {
    public static void main(String[] fer) {
		Cuenta2 c = new Cuenta2(1000);
		IngresarDineroCajero2 h1 = new IngresarDineroCajero2("Padre", c,200);
		SacarDineroCajero2 h2 = new SacarDineroCajero2("Madre", c,800);
		IngresarDineroCajero2 h3 = new IngresarDineroCajero2("Hijo1", c,300);
		SacarDineroCajero2 h4 = new SacarDineroCajero2("Hijo2", c,800);
		SacarDineroCajero2 h5 = new SacarDineroCajero2("Abuelo", c,600);
	
		
		h1.start();
		
		h2.start();
		
		h3.start();
		
		h4.start();
		
		h5.start();
        
        
    }
}
