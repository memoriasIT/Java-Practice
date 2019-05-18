package memoriasIT;

import java.util.concurrent.Semaphore;

public class Runway {
    Semaphore[] requestForLandSem = {
            new Semaphore(0, true),
            new Semaphore(0, true)
    };

    Semaphore runwayMutex = new Semaphore(1, true);

    public int waitForPlane(int id) throws InterruptedException {
        requestForLandSem[id].acquire();
        return id;
    }

    public void requestForLand(int id, int way){
        requestForLandSem[way].release();
    }

    public void finishLanding(){

    }

    public void waitForRunway() throws InterruptedException {
        runwayMutex.acquire();
    }

    // Called bya a controller
    public void informPlaneCanLand(int way) {
    }

    public void waitForPlaneLanding() {
    }
}
