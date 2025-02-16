public class Consumidor extends Thread{
    Deposito deposito;
    int c;

    Consumidor(Deposito deposito,int c){
        this.deposito = deposito;
        this.c = c;
    }
    public void run(){
        for(int i = 0;i<5;i++){
            deposito.get(c);
            try {
                //Thread.sleep(i*100);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("Camión "+c+" Saliendo");
    }
}
