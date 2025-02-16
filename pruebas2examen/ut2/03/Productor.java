public class Productor extends Thread {

    Deposito deposito;

    Productor(Deposito deposito){
        this.deposito = deposito;
    }
    public void run(){
        for(int i = 1;i<=15;i++){
            deposito.set(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
    
}
