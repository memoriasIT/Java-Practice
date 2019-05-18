package memoriasIT;

public class SensorTemperature extends Thread {
    private Factory f;

    public SensorTemperature(Factory f) {
        this.f = f;
    }


    @Override
    public void run(){
        while(true) try {
            sleep(f.rnd.nextInt(1000));
            f.putSampleTemperature();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
