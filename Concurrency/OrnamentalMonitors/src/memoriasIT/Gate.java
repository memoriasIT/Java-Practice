package memoriasIT;

public class Gate extends Thread {
    Garden garden;

    public Gate(Garden g){
        this.garden = g;
    }

    @Override
    public void run(){
       for (int i = 0; i < 10000; i++){
           synchronized(garden){
               garden.count++;
           }
       }
    }
}
