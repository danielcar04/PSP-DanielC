


public class Deposito {
	private double numero;
	private double litrosdeposito=0;
	public synchronized double get(int n) {
		while(litrosdeposito == 0) {
			try {
				wait();
			} catch (Exception e) {}
		}	
			numero = litrosdeposito;
			litrosdeposito = 0;
			System.out.println("Camion "+n+" Carga: "+numero+" Litros");   
			notifyAll();	
		   return numero;
	}

	public synchronized void put(double valor) {
		if (litrosdeposito != 0) {
			notifyAll();
			try {
				wait();
			} catch (Exception e) {
			}
		}
		litrosdeposito = valor;
		System.out.println("el productor llena el deposito con: " + valor+" litros");
		notifyAll();
	}

    
}
