public class Agent extends  Thread{
    private Table table;

    public Agent(Table table) {
        this.table = table;
    }



    @Override
    public void run(){
        while (true) try {
            // Put a random missing element into table
            table.putTable(table.rnd.nextInt(3));
        } catch (Exception e) { e.printStackTrace(); }
    }
}
