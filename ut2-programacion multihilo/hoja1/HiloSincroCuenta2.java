class Cuenta2 {
	private int saldo ;
	Cuenta2 (int s) { saldo = s; }
	
	int getSaldo() { return saldo; }
	void restar(int cantidad) { saldo=saldo-cantidad; }
	void sumar(int cantidad){saldo = saldo + cantidad;}
	
    // El método "RetirarDinero" debe ser atómico -> región crítica: si una persona está sacando dinero, 
    //la otra no debería poder sacarlo hasta que la primera haya finalizado la operación.

    // Solución: declarar el método "RetirarDinero" como "synchronized"
    // Cuando hilo invoca método "RetirarDinero":
    //      -> si está libre => lo toma (bloquea) y lo ejecuta
    //      -> si no está libre => se suspende hasta que el hilo lo tiene bloqueado finalice y lo libere
	synchronized void RetirarDinero(int cant, String nom) {
		if (getSaldo() >= cant) {
			System.out.println(nom+" va a retirar "+cant+"€" );
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {	}
			
			restar(cant);		
			
			System.out.println("\t"+ nom+ " retira ->" +cant + "-> Saldo Actual cuenta = ("+getSaldo()+")" );	
		} else {
			System.out.println(nom+ " No puede retirar dinero, NO HAY SALDO("+getSaldo()+")" );
		}
		if (getSaldo() < 0) {
			System.out.println("SALDO NEGATIVO -> "+getSaldo());
		}
		
	}//retirar
	synchronized void IngresarDinero(int cant,String nom){
		System.out.println(nom+" va a ingresar "+cant+"€ ");
		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {	}
		
		sumar(cant);		
		
		System.out.println("\t"+ nom+ " ingresa -> "+cant + " -> Saldo Actual cuenta = ("+getSaldo()+")" );
	}
}

class SacarDineroCajero2 extends Thread {
	private Cuenta2 c;
	String nom;
	int cant;
	public SacarDineroCajero2 (String n, Cuenta2 c,int cant) {		
		super(n);
		this.c = c;
		this.cant = cant;
	}
	public void run() {		
			c.RetirarDinero(cant, getName());			
		}	
	}// run
	

class IngresarDineroCajero2 extends Thread {
	private Cuenta2 c;
	String nom;
	int cant;
	public IngresarDineroCajero2 (String n, Cuenta2 c,int cant) {		
		super(n);
		this.c = c;
		this.cant = cant;
	}
	public void run() {		
		
			c.IngresarDinero(cant, getName());			
				
	}
}
