public class Variable<T> {
    private T var;
    private boolean isDatum = false;


    public void loads(T data){
        while(isDatum) Thread.yield();
        var = data;
        System.out.println("Producer " + var);
        isDatum = true;
    }

    public T takes(){
        while (!isDatum) Thread.yield();
        // Status of var has to be gotten before changing isDatum
        T v = var;
        System.out.println("Consumer " + v);

        isDatum = false;

        return v;
    }
}
