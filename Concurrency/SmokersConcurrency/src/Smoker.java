public class Smoker extends Thread{
    private Table table;
    private int myIngredient;

    public Smoker(Table table, int i) {
        this.table = table;
        this.myIngredient = i;
    }

    @Override
    public void run(){
        while (true) try {
            table.checkAndWaitForMyIngredient(myIngredient);

            // This smoker has the complementary ingredient and can smoke
            sleep(table.rnd.nextInt(1000)+1000);
            table.notifySmokingFinished();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
