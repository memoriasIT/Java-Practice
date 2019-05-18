import java.util.Random;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Bridge {
    private static Random rnd = new Random();

    // Cars waiting
    private int LeftWaiting = 0;
    private int RightWaiting = 0;

    // Count cars crossed
    private int CarsCrossed = 0;

    private Semaphore mutex = new Semaphore(1, true);

    // Semaphores for left
    private Semaphore LeftCanCross = new Semaphore(1, true);

    // Semaphores for right
    private Semaphore RightCanCross = new Semaphore(0, true);

    public void leftToRight() throws InterruptedException {
        // Temporal value for mutex
        int temp;
        int temp2;


        // Can left cross?
        LeftCanCross.acquire();

        // Mutex to have car crossed count right
        mutex.acquire();
        LeftWaiting--;
        temp = LeftWaiting;
        CarsCrossed++;
        temp2 = CarsCrossed;
        mutex.release();

        System.out.println("Left is crossing, " + temp + " cars are waiting.");

        // If cars are waiting or more than 5 cars crossed already
        if (temp == 0 || temp2 > 5){
            // Set cars crossed to 0 and let right cross
            mutex.acquire();
            CarsCrossed = 0;
            mutex.release();

            RightCanCross.release();
        } else {
            // Left can continue crossing
            LeftCanCross.release();
        }

    }
    public void rightToLeft() throws InterruptedException {
        // Temporal value for mutex
        int temp;
        int temp2;

        // Can left cross?
        RightCanCross.acquire();

        // Mutex to have car crossed count right
        mutex.acquire();
        RightWaiting--;
        temp = RightWaiting;

        CarsCrossed++;
        temp2 = CarsCrossed;
        mutex.release();

        System.out.println("Right is crossing, " + temp + " cars are waiting.");

        // If cars are waiting or more than 5 cars crossed already
        if (temp == 0 || temp2 > 5){
            // Set cars crossed to 0 and let right cross
            mutex.acquire();
            CarsCrossed = 0;
            mutex.release();

            LeftCanCross.release();
        } else {
            RightCanCross.release();
        }

    }

    public void cross(int direction) throws InterruptedException {
        if (direction == 1) {
            mutex.acquire();
            LeftWaiting++;
            mutex.release();
            sleep(rnd.nextInt(1000));
            leftToRight();
        } else {
            mutex.acquire();
            RightWaiting++;
            mutex.release();
            sleep(rnd.nextInt(1000));
            rightToLeft();
        }
    }
}
