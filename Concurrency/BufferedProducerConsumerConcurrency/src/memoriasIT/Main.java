package memoriasIT;

public class Main {

    public static void main(String[] args) {
        // We create a BufferPeterson and specify its size.
        // Then the producer and consumer working with that buffer.
        int size = 5;
        BufferPeterson bp = new BufferPeterson(size);

        // Create Producer and Consumer threads
        int elements = 10;
        Producer p = new Producer(bp,elements);
        Consumer c = new Consumer(bp, elements);

        // Start threads
        p.start();
        c.start();

    }
}
