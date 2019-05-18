public class Driver {

    public static void main(String[] args){
        BarberShop bs = new BarberShop();
        new Barber(bs).start();
        new Environment(bs).start();
    }
}
