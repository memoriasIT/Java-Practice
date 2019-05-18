public class Driver {

    public static void main(String[] args) {
        ConveyorBelt cv = new ConveyorBelt();

        // Main Robot
        PutRobot pr = new PutRobot(cv);

        // Packaging robots
        GetRobot gr1 = new GetRobot(0, cv);
        GetRobot gr2 = new GetRobot(1, cv);
        GetRobot gr3 = new GetRobot(2, cv);


        pr.start();
        gr1.start();
        gr2.start();
        gr3.start();

    }

}
