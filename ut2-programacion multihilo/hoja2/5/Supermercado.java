

public class Supermercado {
    private boolean caja1 = true;
    private boolean caja2 = true;
    private boolean caja3 = true;
    private int contar = 0;

    public synchronized int atender(int n){
        while (caja1 == false && caja2 == false && caja3 == false) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            } 
        }
        if(caja1 == true){
            caja1 = false;
            try {
                System.out.println("caja 1 atendiendo al cliente "+n);

                return 1;
            } catch (Exception e) {
                // TODO: handle exception
            } 
        }else if(caja2 == true){
            caja2 = false;
            try {
                System.out.println("caja 2 atendiendo al cliente "+n);
                return 2;
            } catch (Exception e) {
                // TODO: handle exception
            } 
        }else if(caja3 == true){
            caja3 = false;
            try {
                System.out.println("caja 3 atendiendo al cliente "+n);
                return 3;
            } catch (Exception e) {
                // TODO: handle exception
            } 
        }
        return 0;
    }
    public synchronized void cobrando(int caja, int n){
        if (caja == 1){
            caja1=true;
            System.out.println("caja 1 termino de atender al cliente "+n);             
            notifyAll();
            contar +=1;
        }else if(caja == 2){
            caja2 = true;
            System.out.println("caja 2 termino de atender al cliente "+n);
            notifyAll();
            contar +=1;
        }else if(caja == 3){
            caja3 = true;
            System.out.println("caja 3 termino de atender al cliente "+n);
            notifyAll();
            contar +=1;
        }
        if (contar == 15){
            System.out.println("Supermercado cerrado");
        }
    }
}
