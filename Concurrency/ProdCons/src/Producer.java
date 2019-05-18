import java.util.Random;

public class Producer extends Thread {

    Random r = new Random();
    int numIter; Variable<Integer> sharedVar;
    public Producer(int numIter,Variable<Integer> var){
        this.numIter = numIter; sharedVar = var;
    } public void run(){
        int nData = 0; for (int i = 0; i<numIter;i++){
            nData = r.nextInt(100);
            System.out.println("Producer "+nData);
            sharedVar.loads(nData);
        }
    }
}
