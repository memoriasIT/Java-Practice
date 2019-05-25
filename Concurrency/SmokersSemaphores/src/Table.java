import java.util.Random;
import java.util.concurrent.Semaphore;

public class Table {
    private final int NUMSMOKERS = 3;
    public static Random rnd = new Random();

    // For managing when ingredient can be put/taken
    private Semaphore AgentCanPut = new Semaphore(1, true);
    private Semaphore SmokerCanTake[];

    // Ingredient found in table
    private int ingredient;
    private Semaphore mutex = new Semaphore (1, true);


    // Constructor
    public Table(){
        // Start all semaphores to 0
        SmokerCanTake = new Semaphore[NUMSMOKERS];
        for (int i = 0; i < NUMSMOKERS; i++){
            System.out.println(i);
            SmokerCanTake[i] = new Semaphore(0, true);
        }
    }

    public void AgentPut(int ingredient) throws InterruptedException {
        // wait until agent can put
        AgentCanPut.acquire();

        // Change ingredient in mutex
        mutex.acquire();
        this.ingredient = ingredient;
        System.out.printf("Agent puts ingredient %d\n", ingredient);
        mutex.release();

        // Notify smoker
        SmokerCanTake[ingredient].release();

    }

    public void SmokerTake(int ingredient) throws InterruptedException {
        // Smoker with that ingredient takes it
        SmokerCanTake[ingredient].acquire();

        // Get ingredient in mutex
        mutex.acquire();
        System.out.printf("\tSmoker %d takes ingredient.\n", ingredient);
        mutex.release();

        // Notify agent
        AgentCanPut.release();

    }



}


