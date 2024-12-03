public class Produc_Consum3 {
  public static void main(String[] args) {  
    
    Cola3 cola3 = new Cola3();
	
    Productor3 prod = new Productor3(cola3, 1);	
	  Consumidor3 cons = new Consumidor3(cola3, 1);
    Consumidor3 cons2 = new Consumidor3(cola3, 2);
    prod.start();
	  cons.start();
    cons2.start();
  }
}