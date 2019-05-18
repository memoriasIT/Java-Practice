package memoriasIT;

public class Main {
    public static final int NUMBER_OF_PLANES = 10;

    public static void main(String[] args) {
        Runway r = new Runway();

        Controller[] c = {
                new Controller(0,r),
                new Controller(1, r)
        };

        Plane p[] = new Plane[NUMBER_OF_PLANES];
        for (int i = 0; i < NUMBER_OF_PLANES; i++){
            p[i] = new Plane(i, r);
        }

        c[0].start();
        c[1].start();
        for(int i = 0; i < NUMBER_OF_PLANES; i++){
            p[i].start();
        }
    }
}
