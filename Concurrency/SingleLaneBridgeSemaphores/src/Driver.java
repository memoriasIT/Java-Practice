public class Driver {
    public static void main(String[] args){
        Bridge b = new Bridge();

        // Cars
        // 1 -> Left to right
        // 0 -> Right to left
        Car c1 = new Car(b, 1);
        Car c2 = new Car(b, 1);
        Car c3 = new Car(b, 1);

        Car c4 = new Car(b, 0);
        Car c5 = new Car(b, 0);
        Car c6 = new Car(b, 0);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
    }


}
