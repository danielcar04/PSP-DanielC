public class Apertura {
 public static void main(String[] args) {
    Supermercado supermercado = new Supermercado();
    Caja caja1 = new Caja(supermercado, 1);
    Caja caja2 = new Caja(supermercado, 2);
    Caja caja3 = new Caja(supermercado, 3);
    Cliente cliente1 = new Cliente(supermercado, 1);
    Cliente cliente2 = new Cliente(supermercado, 2);
    Cliente cliente3 = new Cliente(supermercado, 3);
    Cliente cliente4 = new Cliente(supermercado, 4);
    Cliente cliente5 = new Cliente(supermercado, 5);
    Cliente cliente6 = new Cliente(supermercado, 6);
    Cliente cliente7 = new Cliente(supermercado, 7);
    Cliente cliente8 = new Cliente(supermercado, 8);
    Cliente cliente9 = new Cliente(supermercado, 9);
    Cliente cliente10 = new Cliente(supermercado, 10);
    Cliente cliente11 = new Cliente(supermercado, 11);
    Cliente cliente12 = new Cliente(supermercado, 12);
    Cliente cliente13 = new Cliente(supermercado, 13);
    Cliente cliente14 = new Cliente(supermercado, 14);
    Cliente cliente15 = new Cliente(supermercado, 15);

    caja1.start();
    caja2.start();
    caja3.start();
    cliente1.start();
    cliente2.start();
    cliente3.start();
    cliente4.start();
    cliente5.start();
    cliente6.start();
    cliente7.start();
    cliente8.start();
    cliente9.start();
    cliente10.start();
    cliente11.start();
    cliente12.start();
    cliente13.start();
    cliente14.start();
    cliente15.start();
    try {
      caja1.join();
    caja2.join();
    caja3.join();
    cliente1.join();
    cliente2.join();
    cliente3.join();
    cliente4.join();
    cliente5.join();
    cliente6.join();
    cliente7.join();
    cliente8.join();
    cliente9.join();
    cliente10.join();
    cliente11.join();
    cliente12.join();
    cliente13.join();
    cliente14.join();
    cliente15.join();
    } catch (Exception e) {
      // TODO: handle exception
    }
    System.out.println("Supermercado cerrado");  
 }
}