public class Barber extends Thread {
    private BarberShop bs;

    public Barber(BarberShop bs) {
        this.bs = bs;
    }

    public void run() {
        while (true){
             bs.attendingNextCustomer();

             try {
                sleep(BarberShop.rnd.nextInt(100));
            } catch (InterruptedException e) { e.printStackTrace();
            }
        }

    }


}
