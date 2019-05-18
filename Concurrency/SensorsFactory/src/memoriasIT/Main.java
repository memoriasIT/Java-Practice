package memoriasIT;

public class Main {

    public static void main(String[] args) {
        // Passive object for synchro
        Factory f = new Factory();

        // Sensors
        SensorTemperature st = new SensorTemperature(f);
        SensorHumidity sh = new SensorHumidity(f);
        SensorLight sl = new SensorLight(f);

        // Device
        Device d = new Device(f);

        // Threads start
        d.start();
        st.start();
        sl.start();
        sh.start();



    }
}
