public class parimparejecutar {
    public static void main(String[] args) {
        //Creación objetos clase
        parimpar a1 = new parimpar(1);
        parimpar a2 = new parimpar(2);
        
        //Creación hilos
        Thread hilo1 = new Thread(a1);
        Thread hilo2 = new Thread(a2);
        
        try {
            hilo2.start();
            hilo2.join();
            hilo1.start();
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        
        }
}
