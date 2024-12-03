public class HiloSumasRestas implements Runnable{
  private static int numero =1000;
    private int numveces;
    private String operacion;
 //Constructor de la clase
 public HiloSumasRestas (int numveces, String operacion)
 {
    this.numveces=numveces;
    this.operacion=operacion;
   
 }
 //Incrementará numero el numvece indicado
 public synchronized int incrementar (int numveces)
 {

  numero= numero + numveces;
    System.out.println("\t el numero incrementado es "+numero );
   return numero;
 }
 //Decrementará numero el numvece indicado
 public synchronized int decrementar (int numveces)
 {
    
   
      numero= numero - numveces;
   
    System.out.println("\t el numero decrementado es "+numero );
   return numero;
 }
 public void run() {
  if (operacion =="+"){
    numero = incrementar(numveces);
  }else if(operacion=="-"){
    numero = decrementar(numveces);
  }
}
public static void main(String[] args) {
  HiloSumasRestas e1 = new HiloSumasRestas(200, "-");
HiloSumasRestas e2 = new HiloSumasRestas(100, "+");
HiloSumasRestas e3 = new HiloSumasRestas(1, "-");
HiloSumasRestas e4 = new HiloSumasRestas(1, "+");
e1.run();
e2.run();
e3.run();
e4.run();
}
}
