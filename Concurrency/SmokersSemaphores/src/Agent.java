public class Agent extends Thread {
    private int ingredientHave;
    private Table table;

    public Agent(int ingredientHave, Table table) {
        this.ingredientHave = ingredientHave;
        this.table = table;
    }

    @Override
    public void run(){
        while (true) try {
            ingredientHave = table.rnd.nextInt(3);
            table.AgentPut(ingredientHave);
        } catch (Exception e)  { e.printStackTrace(); }
    }
}
