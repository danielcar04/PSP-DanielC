public class Cliente extends Thread {
    
    Sala sala;
    int cliente;
    Cliente(Sala sala, int c){
        this.sala = sala;
        this.cliente=c;
    }

    public  void run(){
        sala.entrar(cliente);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        sala.salir();
    }


}
