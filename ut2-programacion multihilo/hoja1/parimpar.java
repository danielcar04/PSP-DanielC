public class parimpar implements Runnable{
    
    
    private  int tipo;
     
     parimpar(int tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public void run() {
        if(tipo == 1){
            for (int i = 1; i < 100; i++){ 
            if (i%2==0){
                System.out.println("par"+i);
            }
        }
        }else if (this.tipo == 2) {
            for (int i = 101; i < 200; i++){ 
                if (i%2!=0){
                    System.out.println("impar"+i);
                }
            }
        }
    }
}
