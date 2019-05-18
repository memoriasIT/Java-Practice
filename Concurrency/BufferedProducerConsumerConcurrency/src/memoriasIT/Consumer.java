package memoriasIT;

import java.util.Random;

public class Consumer extends Thread {
    private BufferPeterson bp;
    private int numIter;

    public Consumer(BufferPeterson bp, int elements) {
        this.bp = bp;
        this.numIter = elements;
    }

    // Create a num of elements to work with BufferPeterson
    public void run(){
        // If we get data = NULL
        Integer data;
        Random rnd = new Random();

        while (numIter > 0){
            // We try consume (we can if buffer not empty)
            // Critical Section (Must be in mutual exclusion)
            data = bp.extracts();

            // End of Critical Section

            if (data != null){
                // Insertion was successfull
                System.out.println("[C+]" + data + " - Was consumed Correctly");
                numIter--;

            } else {
                // Insertion failed
                System.out.println("[C-] Data was not consumed; Buffer empty.");
            }

            try {
                sleep(rnd.nextInt(100));
            } catch (InterruptedException e) { e.printStackTrace(); }
            
        }
    }

}
