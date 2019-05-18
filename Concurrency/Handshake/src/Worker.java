public class Worker extends Thread{
    private HandshakeLocks h;
    private int id;

    public Worker(int i, HandshakeLocks h) {
        this.id = i;
        this.h = h;
    }

    @Override
    public void run(){
        try {
            sleep(3000+id*2000);
            h.handshake(id);
            System.out.println("Starting the race!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
