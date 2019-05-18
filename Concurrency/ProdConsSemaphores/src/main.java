public class main {
    public static void main(String[] args){
        int numElements = 5;
        Buffer b = new Buffer(numElements);

        int itemsToConsume = 20;
        Producer p = new Producer(b, itemsToConsume);

        Consumer c = new Consumer(b, itemsToConsume);

        p.run();
        c.run();
    }

}


