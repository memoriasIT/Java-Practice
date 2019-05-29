public class Driver {
    public static void main (String[] args){
        Counter count = new Counter();

        Door d1 = new Door(count, 0);
        Door d2 = new Door(count, 1);
        Door d3 = new Door(count, 2);

        d1.start();
        d2.start();
        d3.start();
    }

}
