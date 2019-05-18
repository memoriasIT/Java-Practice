public class Gardens {
    public static void main(String[] args) {
        Counter c = new Counter();
        Gate p1 = new Gate(0, c, 10000);
        Gate p2 = new Gate(1, c, 10000);
        p1.start();
        p2.start();
        try {
            p1.join();
            p2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        System.out.println(c.value());

    }
}
