import java.util.Random;


// Passive Object for concurrency
public class Device {
    protected int temperature, pressure;
    protected Injector inj;
    protected Valve valve;

    protected boolean dataReady = false;
    public Random rnd = new Random();


    public Device( Injector inj, Valve valve){
        this.inj = inj;
        this.valve = valve;
    }

    public synchronized void getData() throws InterruptedException {
        System.out.println("\tGetting temp");
        getTemperature();
        System.out.println("\tGetting pressure");
        getPressure();

        dataReady = true;

    }

    private synchronized void getPressure() throws InterruptedException {
       // Open when not open and mean > 100, close when mean goes bellow 100
       if (pressure > 100 && !valve.isOpen()){
           valve.Open();
       } else if (pressure < 100){
          valve.Close();
       }


    }


    private synchronized  void getTemperature() throws InterruptedException {
        // Open when not open and mean > 100, close when mean goes bellow 100
       if (temperature > 100 && !inj.isOpen()){
           inj.Open();
       } else if (temperature < 100){
          inj.Close();
       }


    }

}
