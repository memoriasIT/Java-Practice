public class ProducerConsumer{
    public static void main(String[] args) {
        Variable<Integer> v = new Variable<Integer>();
        Producer p = new Producer (10,v);
        Consumer c = new Consumer (10,v);
    p.start(); c.start();
}
}
