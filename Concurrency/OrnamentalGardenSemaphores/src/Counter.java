import java.util.Random;
import java.util.concurrent.Semaphore;

public class Counter {
    protected static Random rnd = new Random();
    private int counter = 0;
    private Semaphore mutex = new Semaphore(1, true);

    public void incrementCounter(int id) throws InterruptedException {
        mutex.acquire();

        counter++;
        System.out.printf("ID: %d - Counter: %d\n", id, counter);

        mutex.release();

    }
}
