public class HandshakeMonitors {
    boolean[] arrived = { false, false };

    public synchronized void handshake(int id) throws InterruptedException {
        arrived[id] = true;
        notify();
        int other = (id+1)%2;

        while (!arrived[other])
            wait();

        arrived[other] = false;
    }

}
