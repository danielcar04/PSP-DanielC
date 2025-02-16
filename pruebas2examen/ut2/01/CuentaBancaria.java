class CuentaBancaria {
    private int saldo;
    CuentaBancaria(int s){saldo = s;}
    int getSaldo() { return saldo; }
	void restar(int cantidad) { saldo=saldo-cantidad; }
	void sumar(int cantidad){saldo = saldo + cantidad;}
    synchronized void sacarDinero(String nombre, int importe){
        if (getSaldo() >= importe){
            
            System.out.println(nombre+" Retira de la cuenta "+importe);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                
            }
            restar(importe);
            System.out.println("Quedan "+getSaldo()+" euros");
        }else{
            System.out.println("Saldo insuficiente para "+nombre);
        }
        if (getSaldo() < 0) {
			System.out.println("SALDO NEGATIVO -> "+getSaldo());
		}
        
    }

    synchronized void ingresarDinero(String nombre, int importe){
        
        System.out.println(nombre+" ingresa de la cuenta "+importe);
        try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {	}
        sumar(importe);
        System.out.println("Quedan "+getSaldo()+" euros");
        
    }
}
class HiloIngresarDinero extends Thread{
    private CuentaBancaria cuenta;
     String nombre;
     int cantidad;
   public HiloIngresarDinero(CuentaBancaria cuenta,String nombre,int cantidad){
    super(nombre);
    this.cuenta = cuenta;
        this.cantidad = cantidad;
        
        
    }

    public void run(){
        System.out.println(cuenta.getSaldo());
        cuenta.ingresarDinero(getName(), cantidad);
    }
}
class HiloSacarDinero extends Thread{
    private CuentaBancaria cuenta;
     String nombre;
     int cantidad;
   public HiloSacarDinero(CuentaBancaria cuenta,String nombre,int cantidad){
    super(nombre);
    this.cuenta = cuenta;
        this.cantidad = cantidad;
        
        
    }

    public void run(){
        cuenta.sacarDinero(getName(), cantidad);
    }
}
