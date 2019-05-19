public class Monitor extends Thread {
   private Device dev;


    public Monitor(Device dev){
        this.dev = dev;
    }


    @Override
    public synchronized void run(){
        while (true) try{
            // Get data
            dev.getData();

            // Wait while data is not ready
            while(!dev.dataReady) {
                wait();
            }

            // Display string
            System.out.printf("[T - %d] [P - %d] [InjOpen - %b] [ValveOpen - %b]\n", dev.temperature, dev.pressure, dev.inj.isOpen(), dev.valve.isOpen());
            dev.dataReady = false;
            sleep(1000);


        } catch (Exception e) { e.printStackTrace(); }
    }
}
