public class Car extends Thread {
    private int direction;
    private Bridge b;


    public Car(Bridge b, int i) {
        this.direction = i;
        this.b = b;
    }

    @Override
    public void run(){
        while (true) try{
            b.cross(direction);

        } catch (Exception e) { e.printStackTrace(); }
    }
}
