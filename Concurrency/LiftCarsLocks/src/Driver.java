public class Driver {
    public static void main (String[] args) {
        Lift lift = new Lift();

        // Small Cars
        SmallCar sm1 = new SmallCar(lift);
        SmallCar sm2 = new SmallCar(lift);
        SmallCar sm3 = new SmallCar(lift);
        SmallCar sm4 = new SmallCar(lift);
        SmallCar sm5 = new SmallCar(lift);
        SmallCar sm6 = new SmallCar(lift);
        SmallCar sm7 = new SmallCar(lift);
        SmallCar sm8 = new SmallCar(lift);

        // Large cars
        LargeCar lg1 = new LargeCar(lift);
        LargeCar lg2 = new LargeCar(lift);
        LargeCar lg3 = new LargeCar(lift);

        // STart Threads
        sm1.start();
        sm2.start();
        sm3.start();
        sm4.start();
        sm5.start();
        sm6.start();
        sm7.start();
        sm8.start();

        lg1.start();
        lg2.start();
        lg3.start();
    }

}
