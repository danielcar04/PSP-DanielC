public class HiloParImpar implements Runnable {

    private int tipo;

    HiloParImpar(int tipo){
        this.tipo = tipo;
    }

    @Override
    public void run() {
        if (tipo == 1){
            for(int i = 0; i<=100;i++){
                if (i % 2== 0){
                    System.out.println("hilo "+tipo+" Imprime "+i);
                }
            }
        }else if (tipo == 2) {
            for(int i = 101; i<=200;i++){
                if (i % 2!= 0){
                    System.out.println("hilo "+tipo+" Imprime "+i);
                }
            }
        }
    }
}