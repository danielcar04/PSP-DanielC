public class Productor extends Thread {
    Almacen a;

    Productor(Almacen a){
        this.a = a;
    }

    public void run(){
            for(int i = 0; i<10;i++){
                a.put(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
           
        }
}
