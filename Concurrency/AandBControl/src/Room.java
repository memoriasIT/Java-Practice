import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Room {
    // For constructing the number of elements in total
    public final int NUMPA = 9;
    public final int NUMPB = 5;

    // Current number of elements waiting
    private static int numA;
    private static int numB;

    // Random object for generating random waiting time
    public static Random rnd = new Random();

    Lock l = new ReentrantLock(true);
    Condition AwaitsB = l.newCondition();
    Condition BwaitsA = l.newCondition();

    // Constructor
    public Room() {
        numA = 0;
        numB = 0;
    }

    // a B enters the room
    public void enterB(int id) throws InterruptedException {
        try {
            l.lock();

            numB++;
            System.out.println("\t B enters.");
            System.out.printf("NumB: %d - NumA: %d\n", numB, numA);

            if (numB >= 2) {
                // All A signaled
                System.out.println("\tAll A signaled.");
                AwaitsB.signalAll();
            }

            while(numA < 1){
                System.out.printf("\t B %d waiting - numA: %d\n", id, numA);
                BwaitsA.await();
            }

            // Simulate that all go away
            System.out.println("\t All A taken by a B");
            numB = 0;
            numA = 0;


        } finally {
            l.unlock();
        }
    }

    // an A enters the room
    public void enterA(int id) throws InterruptedException {
        try {
            l.lock();

            numA++;
            System.out.println("\t A enters.");

            System.out.println("\tAll B signaled");
            BwaitsA.signalAll();

            System.out.printf("NumB: %d - NumA: %d\n", numB, numA);
            while(numB < 2){
                System.out.printf("\t A %d waiting - numB: %d\n", id, numB);
                AwaitsB.await();
            }

            // Simulate all A go away
            //System.out.printf("\tCondition Fulfilled. NumB: %d\n", numB);



        } finally {
            l.unlock();
        }
    }


}
