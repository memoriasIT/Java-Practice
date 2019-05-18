package memoriasIT;

public class Controller extends Thread {
    private int id;
    private Runway r;

    public Controller(int i, Runway r) {
        this.id = id;
        this.r = r;
    }

    @Override
    public void run(){
        while (true) try {
            int planeID = r.waitForPlane(id);
            r.waitForRunway();
            r.informPlaneCanLand(id);
            r.waitForPlaneLanding();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
