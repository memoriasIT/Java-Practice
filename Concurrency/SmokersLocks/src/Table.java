import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class Table {

    protected Random rnd = new Random();
    private final int NUMINGREDIENTS = 3;

    // Conditions
    private Condition[] ingredientLack;
    private Condition AgentPut;
    private Lock l = new ReentrantLock();

    // Missing ingredient to smoke
    private int ingredientMissing;


    public Table(){
        // Conditions for the smokers
        ingredientLack = new Condition[NUMINGREDIENTS];
        for (int i = 0; i < NUMINGREDIENTS; i++){
            ingredientLack[i] = l.newCondition();
        }

        // Condition for the Agent to put
        AgentPut = l.newCondition();

        // Set ingredient to -1 so it doesn't match to any smoker at first
        ingredientMissing = -1;
    }

    public void putTable(int ingredient) throws InterruptedException {
        l.lock();
        try {
            while(ingredientMissing != -1){
                AgentPut.await();
            }

            this.ingredientMissing = ingredient;
            System.out.printf("Agent lacks ingredient %d\n", ingredient);

            ingredientLack[ingredientMissing].signal();
        } finally {
            l.unlock();
        }
    }

    public void checkTable(int ingredient) throws InterruptedException {
        l.lock();
        try{
            while(ingredient != ingredientMissing){
                ingredientLack[ingredient].await();
            }

            System.out.printf("\tSmoker %d is smoking.\n", ingredient);

        } finally {
            l.unlock();
        }
    }

    public void smoke() throws InterruptedException {
        l.lock();
        try {
            sleep(rnd.nextInt(1000));
            System.out.println("\tSmoker finished.\n");

            ingredientMissing = -1;
            AgentPut.signal();
        } finally {
            l.unlock();
        }
    }
}
