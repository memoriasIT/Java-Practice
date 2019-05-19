public class TemperatureSensor extends Thread {
    private Device dev;
    private Injector inj;

    public TemperatureSensor(Device dev, Injector inj){
        this.dev = dev;
        this.inj = inj;
    }


    @Override
    public synchronized void run(){
        while (true) try {
           int mean = 0;

           // Simulate getting 1000 samples of temperature
           for (int i = 0; i < 1000; i++){
               mean += dev.rnd.nextInt(200);
           }
           dev.temperature = mean/1000;
            sleep(1000);

        } catch (Exception e) { e.printStackTrace(); }
    }

}
