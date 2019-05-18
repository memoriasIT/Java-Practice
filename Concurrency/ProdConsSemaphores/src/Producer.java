import static java.lang.Thread.sleep;

public class Producer {
    private Buffer buffer;
    private int numIter;

    public Producer(Buffer b, int itemsToConsume) {
        buffer = b;
        numIter = itemsToConsume;
    }


    public void run(){
        for(; numIter > 0; numIter--){
            // Generate random data
            int data = Buffer.rnd.nextInt(100);
            System.out.println("Generating "+ data);

            // Put if space available
            buffer.toProduce(data);

            // Wait a bit
            try {
                sleep(Buffer.rnd.nextInt(50));
            } catch (InterruptedException e) { e.printStackTrace(); } }
    }
}
