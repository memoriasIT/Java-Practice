public class Gate extends Thread {
    private Counter visitors;
    private int iter;
    static volatile int turn = 0;
    static volatile boolean[] f = {false, false};
    int myId, other;

    public Gate(int id, Counter c, int iter) {
        myId = id;
        other = (id + 1) % 2;

        visitors = c;
        this.iter = iter;
    }

    public void run() {


        // Critical section
        for (int i = 0; i < iter; i++) {
            // Start of control system Petterson
            f[myId] = true;
            turn = other;
            while (f[other] && turn == other) Thread.yield();

            // Critical section
            visitors.inc();

            // End of control system
            f[myId] = false;
        }

    }
}
