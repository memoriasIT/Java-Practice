public class Smoker extends Thread {
    private int ingredientLack;
    private Table table;

    public Smoker(int i, Table table) {
        this.table = table;
        this.ingredientLack = i;
    }


    @Override
    public void run(){
        while (true) try {
            table.checkTable(ingredientLack);
            table.smoke();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
