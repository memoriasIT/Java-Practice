public class PutRobot extends Thread {
    private ConveyorBelt cv;

    public PutRobot(ConveyorBelt cv){
        this.cv = cv;
    }


    @Override
    public void run(){
        while(true) try {
            sleep(1000);
            cv.putItem(0);
            sleep(1000);
            cv.putItem(1);
            cv.putItem(2);

        } catch (Exception e) { e.printStackTrace(); }
    }


}
