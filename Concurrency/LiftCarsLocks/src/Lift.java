import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lift {
    private Lock l = new ReentrantLock();

    private Condition ConditionSmallCar;
    private Condition ConditionLargeCar;

    private int smallCarAvailable;
    private int largeCarAvailable;

    public Lift(){
        // Set conditions to lock
        ConditionSmallCar = l.newCondition();
        ConditionLargeCar = l.newCondition();

        // Set booleans to false
        smallCarAvailable = 0;
        largeCarAvailable = 0;
    }


    public void loadSmallCar() {
        try {
            l.lock();

            smallCarAvailable++;
            System.out.printf("%d small cars available\n", smallCarAvailable);
            ReadyForLift();
        } finally {
            l.unlock();
        }
    }

    public void ReadyForLift(){
        try {
            l.lock();

            if (smallCarAvailable >= 2 && largeCarAvailable >= 1){
                largeCarAvailable--;
                smallCarAvailable = smallCarAvailable - 2;
                System.out.println("\tA large car and two small cars were lifted.");
            } else if (smallCarAvailable >= 4) {
                smallCarAvailable = smallCarAvailable -4;
                System.out.println("\tFour small cars were lifted.");
            }


        } finally {
            l.unlock();
        }
    }


    public void loadLargeCar() {
        try {
            l.lock();

            largeCarAvailable++;
            System.out.printf("%d large cars available\n", largeCarAvailable);
            ReadyForLift();
        } finally {
            l.unlock();
        }
    }
}
