public class Consumidor extends Thread {

    Almacen a;
    int num = 0;
    int tipo;
    Consumidor(Almacen a,int tipo){
        this.a = a;
        this.tipo = tipo;
    }

    public void run(){
        for(int i = 0; i<5;i++){
            num+=a.get(tipo);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(tipo+" "+num);
        }
}
