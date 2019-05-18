public class Consumer extends Thread {
    int numIter;
    Variable<Integer> sharedVar;

    public Consumer(int numIter,Variable<Integer> var){
        this.numIter = numIter; sharedVar = var;
    }

    public void run(){
        Integer nData = 0;
        for (int i = 0; i<numIter;i++){
            nData = sharedVar.takes();
            System.out.println("Consumer "+nData);
        }
    }
}
