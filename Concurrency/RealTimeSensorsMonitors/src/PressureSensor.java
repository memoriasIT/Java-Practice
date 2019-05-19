public class PressureSensor extends Thread {
    private Device dev;
    private Valve valve;

    public PressureSensor(Device dev, Valve valve){
        this.dev = dev;
        this.valve = valve;
    }


    @Override
    public synchronized void run(){
        while (true) try {
           int mean = 0;

           // Simulate getting 650 samples of temperature
           for (int i = 0; i < 650; i++){
               mean += dev.rnd.nextInt(200);
           }
           dev.pressure = mean/650;

            // Wait 2 s
            sleep(2000);
        } catch (Exception e) { e.printStackTrace(); }
    }


}
