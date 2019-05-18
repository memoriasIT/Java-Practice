import java.util.concurrent.Semaphore;

public class ConveyorBelt {
    // Total generated items in the conveyor belt
    int TotalObjects;
    Semaphore mutex = new Semaphore(1, true);

    // 1 = there is an item
    // 0 = there is not an item
    private short CONVEYORLENGTH = 3;
    private Boolean[] ConveyorItems;


    private Semaphore[] canPutItem;
    private Semaphore[] canTakeItem;


    public ConveyorBelt() {
        // Start with 0 generated items
        TotalObjects = 0;

        // Generate empty conveyor belt
        ConveyorItems = new Boolean[CONVEYORLENGTH];
        for (int i = 0; i < CONVEYORLENGTH; i++){
            ConveyorItems[i] = false;
        }

        // Set can put items to true as conveyor belt is empty
        canPutItem = new Semaphore[CONVEYORLENGTH];
        for (int i = 0; i < CONVEYORLENGTH; i++){
            canPutItem[i] = new Semaphore(1, true);
        }

        // We can't take items as conveyor belt is empty
        canTakeItem = new Semaphore[CONVEYORLENGTH];
        for (int i = 0; i < CONVEYORLENGTH; i++){
            canTakeItem[i] = new Semaphore(0, true);
        }

    }


    public void putItem(int place) throws InterruptedException {
        // Check the semaphore to put in place
        canPutItem[place].acquire();
        System.out.println("Item placed at " + place);

        // Let GetRobot take item
        canTakeItem[place].release();
    }

    public void takeItem(int place) throws InterruptedException {
        // Check semaphore
        canTakeItem[place].acquire();

        System.out.println("Item took from " + place);

        // GeneratedItems++
        mutex.acquire();
        TotalObjects++;
        mutex.release();

        // Let PutRobot put item
        canPutItem[place].release();
    }

}
