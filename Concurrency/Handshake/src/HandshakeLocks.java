import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HandshakeLocks {
    boolean[] arrived = { false, false };
    Lock l = new ReentrantLock();
    Condition[] c = {
            l.newCondition(),
            l.newCondition()
    };

    public void handshake(int id) throws InterruptedException {
        l.lock();
        try {
            arrived[id] = true;
            int other = (id+1)%2;
            c[other].signal();

            while (!arrived[other])
                c[id].await();

            arrived[other] = false;
        } finally {
            l.unlock();
        }
    }
}
