import java.util.concurrent.Semaphore;

public class HandshakeSemaphores {
    Semaphore[] s = {
            new Semaphore(0, true),
            new Semaphore(0, true)

    };

    public void handshake(int id) throws InterruptedException {
        int other = (id+1)%2;
        s[other].release();
        System.out.println("Releasing " + other);
        s[id].acquire();
    }
}
