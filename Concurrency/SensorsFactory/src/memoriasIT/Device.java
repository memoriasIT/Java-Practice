package memoriasIT;

public class Device extends Thread {
    private Factory f;

    public Device(Factory f) {
        this.f = f;
    }


    @Override
    public void run(){
        while(true) try {
            f.retrieveSamples();
            sleep(f.rnd.nextInt(1000));
            f.informDeviceFinished();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
