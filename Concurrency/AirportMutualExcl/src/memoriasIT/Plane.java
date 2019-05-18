package memoriasIT;

import java.util.Random;

public class Plane extends Thread {
    private int id;
    private Random rnd = new Random();
    private Runway r;

    public Plane(int i, Runway r) {
        this.id = i;
        this.r = r;
    }

    public void run(){
        while(true) try {
            sleep(rnd.nextInt(5000));
            r.requestForLand();
            // Landing
            sleep(rnd.nextInt(500));
            r.finishLanding();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
