public class Driver {
    public static void main(String[] args){
        Table table = new Table();

        Agent agent = new Agent(table);

        Smoker sm1 = new Smoker(0, table);
        Smoker sm2 = new Smoker(1, table);
        Smoker sm3 = new Smoker(2, table);

        agent.start();
        sm1.start();
        sm2.start();
        sm3.start();

    }

}
