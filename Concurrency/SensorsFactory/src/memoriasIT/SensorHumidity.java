package memoriasIT;

public class SensorHumidity extends Thread {

    private Factory f;
    public SensorHumidity(Factory f) {
        this.f = f;
    }


    @Override
    public void run(){
        while(true) try {
            sleep(f.rnd.nextInt(1000));
            f.putSampleHumidity();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
