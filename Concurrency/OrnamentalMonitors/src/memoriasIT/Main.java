package memoriasIT;

public class Main {

    public static void main(String[] args) {
        Garden g = new Garden();
        Gate p1 = new Gate();
        Gate p2 = new Gate();
        p1.start();
        p2.start();
        try {
            p1.join();
            p2.join();
        } catch (InterruptedException ie) {
        }
        System.out.println(g.display());
    }
    }
}
