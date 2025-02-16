public class HiloSumasRestas implements Runnable {

    private static int numero = 1000;
    private int numveces;
    private String operación;

    public HiloSumasRestas(int numveces,String operación){
        this.numveces = numveces;
        this.operación = operación;
    }
    public int incrementar (int numveces){
            numero += numveces;
            return numero;
    }

 public int decrementar (int numveces){
    numero -= numveces;
    return numero;
    
}

    @Override
    public void run() {
       if (operación.equals("+")){
        System.out.println(incrementar(numveces)); 
       }else if(operación.equals("-")){
        System.out.println(decrementar(numveces)); 
       }
    }
    
}
