public class Produc_Consum3 {
  public static void main(String[] args) {  
    
    Deposito deposito = new Deposito();
	
    Productor prod = new Productor(deposito);	
	  Camion cons = new Camion(deposito, 1);
    Camion cons2 = new Camion(deposito, 2);
    Camion cons3 = new Camion(deposito, 3);
    prod.start();
	  cons.start();
    cons2.start();
    cons3.start();
  }
}