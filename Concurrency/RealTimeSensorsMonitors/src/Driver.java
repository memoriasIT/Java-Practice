public class Driver {

    public static void main(String[] args){
        // Activated by sensors
        Injector inj = new Injector();
        Valve valve = new Valve();

        // Passive object
        Device dev = new Device(inj, valve);

        // Consumer
        Monitor mon = new Monitor(dev);

        // Sensors
        TemperatureSensor tsens = new TemperatureSensor(dev, inj);
        PressureSensor psens = new PressureSensor(dev, valve);

        // Start threads
        tsens.start();
        psens.start();
        mon.start();
    }

}
