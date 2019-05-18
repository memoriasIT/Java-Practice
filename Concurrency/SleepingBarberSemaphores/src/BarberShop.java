import java.util.Random;
import java.util.concurrent.Semaphore;

public class BarberShop {
    private static int n = 0;
    private static Semaphore wait = new Semaphore(0, true);
    private static Semaphore mutex = new Semaphore(1, true);

    // Utility variable
    public static Random rnd = new Random();


    public void arriveNewCustomer() {
        try {
            mutex.acquire();
            n++;
            System.out.println("New Customer: "+n);
            if (n == 0) {
                wait.release();
                System.out.println("Awaking the barber");
            }
            mutex.release();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public void attendingNextCustomer() {
        try {
            mutex.acquire();
            n--;
            System.out.println("Attending customer " +n);
            if (n == -1) {
                System.out.println("I'm going to sleep");
                mutex.release();
                wait.acquire();
                mutex.acquire();
            }
            mutex.release();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
