public class Agent extends Thread {
    private Table table;

    public Agent(Table table) {
        this.table = table;
    }

    @Override
    public void run(){
        while (true) try {
            table.putAllIngredientsBut(table.rnd.nextInt(3));
            table.waitForSmoker();


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
