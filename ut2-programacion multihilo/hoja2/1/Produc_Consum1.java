public class Produc_Consum1 {
  public static void main(String[] args) {  
    
    Cola1 cola1 = new Cola1();
	
    Productor1 prod = new Productor1(cola1, 1);	
	  Consumidor1 cons = new Consumidor1(cola1, 1);
    prod.start();
	  cons.start();
  }
}