public class Smoker extends Thread {
    private int ingredientNeed;
    private Table table;

    public Smoker(int ingredientNeed, Table table) {
        this.ingredientNeed = ingredientNeed;
        this.table = table;
    }

    public void run(){
        while (true) try{
            table.SmokerTake(ingredientNeed);
        } catch (Exception e) { e.printStackTrace(); }
    }

}
