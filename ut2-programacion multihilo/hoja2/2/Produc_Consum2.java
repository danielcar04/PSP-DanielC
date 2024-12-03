public class Produc_Consum2 {
  public static void main(String[] args) {  
    
    Cola2 cola2 = new Cola2();
	
    Productor2 prod = new Productor2(cola2, 1);	
	  Consumidor2 cons = new Consumidor2(cola2, 1);
    Consumidor2 cons2 = new Consumidor2(cola2, 2);
    prod.start();
	  cons.start();
    cons2.start();
  }
}