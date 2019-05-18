package memoriasIT;

public class SensorLight extends Thread {

    private Factory f;


    public SensorLight(Factory f) {
        this.f = f;
    }

    @Override
    public void run(){
        while(true) try {
            // Simulate get data
            sleep(f.rnd.nextInt(1000));
            f.putSampleLight();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
