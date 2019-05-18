package memoriasIT;

import java.util.Random;

public class Producer extends Thread{
    private BufferPeterson bp;
    private int numIter;


    public Producer(BufferPeterson bp, int elements) {
        this.bp = bp;
        this.numIter = elements;
    }

    // Create a num of elements to work with BufferPeterson
    public void run(){
        Random rnd = new Random();

        while (numIter > 0){
            // We try produce (we can if buffer not full)
            // Ensure mutual exclusion

            int data = rnd.nextInt(100);

            // Critical Section (Must be in mutual exclusion)
            boolean ok = bp.inserts(data);
            // End of Critical Section

            // We could not insert
            while (!ok){
                System.out.println("[P-] Data was not inserted; Buffer full. Retry:" + data);

                try {
                    sleep(rnd.nextInt(10));
                } catch (InterruptedException e) { e.printStackTrace(); }

                ok = bp.inserts(data);

            }

            // Insertion was successfull
            System.out.println("[P+]" + data + " - Was stored Correctly");
            numIter--;

        }
    }
}
