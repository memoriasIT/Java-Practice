public class GetRobot extends Thread {
    private ConveyorBelt cv;
    private int id;

    public GetRobot(int id, ConveyorBelt cv){
        this.id = id;
        this.cv = cv;
    }

    @Override
    public void run(){
        while (true) try {
            sleep(1000);
            cv.takeItem(id);


        } catch (Exception e) { e.printStackTrace(); }
    }



}
