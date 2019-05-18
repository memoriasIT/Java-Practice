public class Environment extends Thread {
    private BarberShop bs;

    public Environment(BarberShop bs) {
        this.bs = bs;
    }

    public void run() {
       while(true){
           BarberShop.rnd.nextInt(100);
           bs.arriveNewCustomer();

           try {
                sleep(BarberShop.rnd.nextInt(100));
            } catch (InterruptedException e) { e.printStackTrace();
            }


       }
    }
}
