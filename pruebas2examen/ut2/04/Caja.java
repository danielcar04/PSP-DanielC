public class Caja  extends Thread{

    Supermercado supermercado;

    int  cliente = 0;
    int c;


    Caja(Supermercado  supermercado, int c){
        this.supermercado = supermercado;
        this.c = c;
    }

   public void run(){
        while (cliente!=-1) {
            cliente = supermercado.atender(c, cliente);
            if (cliente != -1){
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        }
    }
    
}
