public class Supermercado {
    private boolean caja1 = true;
    private boolean caja2 = true;
    private boolean caja3 = true;
    private int contar = 0;

    public synchronized void atender(int n){
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
                try {
                    wait(5000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                caja1 = true;
                notifyAll();
                contar +=1;
                
            } catch (Exception e) {
                // TODO: handle exception
            } 
        }else if(caja2 == true){
            caja2 = false;
            try {
                System.out.println("caja 2 atendiendo al cliente "+n);
                try {
                    wait(5000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                caja2 = true;
                notifyAll();
                contar +=1;
                
            } catch (Exception e) {
                // TODO: handle exception
            } 
        }else if(caja3 == true){
            caja3 = false;
            try {
                System.out.println("caja 3 atendiendo al cliente "+n);
                try {
                    wait(5000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                caja3 = true;
                notifyAll();
                contar +=1;
                
            } catch (Exception e) {
                // TODO: handle exception
            } 
        }
        if (contar == 15){
            System.out.println("Supermercado cerrado");
        }
        
    }
}
