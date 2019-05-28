public class SmallCar extends Thread{
    private Lift lift;

    public SmallCar(Lift lift) {
        this.lift = lift;
    }

    @Override
    public void run(){
        while (true) try {
           lift.loadSmallCar();
            sleep(1000);
        } catch (Exception e) { e.printStackTrace(); }
    }
}
