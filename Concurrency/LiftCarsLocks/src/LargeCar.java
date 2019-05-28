public class LargeCar extends Thread {
    private Lift lift;

    public LargeCar(Lift lift) {
        this.lift = lift;
    }

    @Override
    public void run(){
        while (true) try {
            lift.loadLargeCar();
            sleep(1000);

        } catch (Exception e) { e.printStackTrace(); }
    }
}
