public class main {
    public static void main(String args[]){
        //HandshakeMonitors h = new HandshakeMonitors();
        //HandshakeSemaphores h = new HandshakeSemaphores();
        HandshakeLocks h = new HandshakeLocks();

        Worker w0 = new Worker(0, h);
        Worker w1 = new Worker(1, h);

        w0.start();
        w1.start();
    }


}
