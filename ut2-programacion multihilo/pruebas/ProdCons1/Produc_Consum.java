public class Produc_Consum {
  public static void main(String[] args) {  
    /*Recurso compartido */
    Cola cola = new Cola();
	/*Los hilos */
    Productor prod = new Productor(cola, 1);	
	  Consumidor cons = new Consumidor(cola, 1);
	/*ejecuto */
    prod.start();
	  cons.start();

  }
}