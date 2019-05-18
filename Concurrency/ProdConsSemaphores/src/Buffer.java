import java.util.Random;
import java.util.concurrent.Semaphore;

public class Buffer {
    // Buffer
    private int[] buffer;
    // Position to produce
    private int p = 0;
    // Position to take
    private int c = 0;
    // Num of elements in buffer
    private int size = 0;
    // Constant N
    private final int N;
    // Random number
    public static Random rnd = new Random();


    private Semaphore thereIsSpace;
    private Semaphore thereAreData;
    private Semaphore mutex;


    // Constructor
    public Buffer(int numElements) {
        N = numElements;
        buffer = new int[N];
        thereIsSpace = new Semaphore(N);
        thereAreData = new Semaphore(0);
        mutex = new Semaphore(1);
    }


    public void toProduce(int data) {
        try {
            thereIsSpace.acquire();
            mutex.acquire();
            buffer[p] = data;
            p = (p + 1) % N;
            mutex.release();
            thereAreData.release();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public int toTake() {
        int data = 0;
        try {
            thereAreData.acquire();
            mutex.acquire();
            data = buffer[c];
            c = (c + 1) % N;
            mutex.release();
            thereIsSpace.release();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        return data;
    }
}
