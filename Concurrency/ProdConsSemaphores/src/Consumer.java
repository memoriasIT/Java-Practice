public class Consumer extends Thread{
    private Buffer buffer;
    private int numIter;

    public Consumer(Buffer b, int itemsToConsume) {
        buffer = b;
        numIter = itemsToConsume;
    }

    public void run(){
        for(; numIter > 0; numIter--){
            // Take if data available
            int data = buffer.toTake();
            // Print data
            System.out.println(data);

            // Wait a bit
            try {
                sleep(Buffer.rnd.nextInt(50));
            } catch (InterruptedException e) { e.printStackTrace(); } }
    }
}
