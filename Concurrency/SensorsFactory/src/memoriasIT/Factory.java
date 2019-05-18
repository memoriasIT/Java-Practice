package memoriasIT;

import java.util.Random;
import java.util.concurrent.Semaphore;

// Passive object to achieve synchronization
public class Factory {
    public Random rnd = new Random();
    private Semaphore sampleTemperatureAvailable = new Semaphore(0, true);
    private Semaphore sampleHumidityAvailable = new Semaphore(0, true);
    private Semaphore sampleLightAvailable = new Semaphore(0, true);

    private Semaphore canPutSampleHumidity = new Semaphore(1, true);
    private Semaphore canPutSampleLight = new Semaphore(1, true);
    private Semaphore canPutSampleTemperature = new Semaphore(1, true);

    public void retrieveSamples() throws InterruptedException {
        sampleTemperatureAvailable.acquire();
        sampleHumidityAvailable.acquire();
        sampleLightAvailable.acquire();

        System.out.println("Processing 3 samples.");
    }

    public void informDeviceFinished() {
        canPutSampleTemperature.release();
        canPutSampleHumidity.release();
        canPutSampleLight.release();
        System.out.println("Releasing 3 sensors.");
    }

    public void putSampleLight() throws InterruptedException {
        canPutSampleLight.acquire();
        System.out.println("\t New Light value");
        sampleLightAvailable.release();
    }

    public void putSampleHumidity() throws InterruptedException {
        canPutSampleHumidity.acquire();
        System.out.println("\t New Humidity value");
        sampleHumidityAvailable.release();
    }

    public void putSampleTemperature() throws InterruptedException {
        // Wait for the device to be ready
        canPutSampleTemperature.acquire();
        System.out.println("\t New Temperature value");
        sampleTemperatureAvailable.release();

    }
}
