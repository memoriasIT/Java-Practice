import java.util.Random;

public class Table {
    public static Random rnd = new Random();
    private int ingredientMissingOnTable = -1;
    private boolean finishedSmoker;

    // Called by the agent
    public synchronized void putAllIngredientsBut(int missingIngredient) {
        System.out.println("Put " + missingIngredient + " on table.");
        ingredientMissingOnTable = missingIngredient;
        notifyAll();
        finishedSmoker = false;
    }

    // Called by the agent
    public synchronized void waitForSmoker() throws InterruptedException {
        System.out.println("Agent waiting");
        while (!finishedSmoker){
            wait();
        }
    }

    // Called by any smoker
    public synchronized void checkAndWaitForMyIngredient(int myIngredient) throws InterruptedException {
        System.out.println("Smoker "+myIngredient+ " waiting.");
        while(ingredientMissingOnTable != myIngredient){
            wait();
        }
        // Take the ingredient
        ingredientMissingOnTable = -1;
        System.out.println("Smoker " + myIngredient + " starts smoking.");
    }

    // Called by any smoker
    public synchronized void notifySmokingFinished() {
        System.out.println("Smoking finished");
        finishedSmoker = true;
        notifyAll();
    }
}
