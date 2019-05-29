public class Door extends Thread {

    private Counter count;
    private int id;

    public Door(Counter count, int i) {
        this.count = count;
        this.id = i;
    }

    @Override
    public void run(){
        while (true) try {
            count.incrementCounter(id);

            //Sleep for random interval mod 1 sec
            sleep(count.rnd.nextInt(1000));

        } catch (Exception e) { e.printStackTrace(); }
    }
}
