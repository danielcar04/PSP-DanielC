public class SumNumHilos extends Thread{

   

    //Variable acumula la suma 
    private static long totalSum = 0;
	private final int start;
    private final int end;
	
	// Constructor de la clase
	SumNumHilos(int start, int end) {
            this.start = start;
            this.end = end;
        } 

		public static synchronized void sumar(int i)//el syncroniced es para que no se pisen los hilos al hacer esto
		{
				totalSum=totalSum+i;
		}
							
	// metodo run -> funcionalidad del hilo
	public void run() {
	
		for (int i = start; i < end; i++)
		{
			sumar(i);
		}
		
		
	}
						


    public static void main(String[] args) {
      		SumNumHilos hilo1=new SumNumHilos(1,10000);
			SumNumHilos hilo2=new SumNumHilos(10001,20000);
			SumNumHilos hilo3=new SumNumHilos(20001,30000);
			
		    
		    hilo1.start();
		    hilo2.start();
			hilo3.start();
		   try {
			hilo1.join();
			hilo2.join();
			hilo3.join();
		   } catch (Exception e) {
			// TODO: handle exception
		   }

        	System.out.println("La suma total es: " + totalSum);
    }
}
