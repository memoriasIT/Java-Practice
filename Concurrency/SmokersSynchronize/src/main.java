public class main {
    public static void main(String[] args){
        Table table = new Table();

        Smoker t = new Smoker (table, 0);
        Smoker v = new Smoker (table, 1);
        Smoker m = new Smoker (table, 2);

        Agent a = new Agent(table);

        t.start();
        v.start();
        m.start();
        a.start();
    }
}
