package dataStructures.priorityQueue;
import dataStructures.heap.BinaryHeap;
import dataStructures.PriorityQueue.EmptyPriorityQueueException;
//     ___      _            _ _           ____
//    / _ \_ __(_) ___  _ __(_) |_ _   _  /___ \_   _  ___ _   _  ___
//   / /_)/ '__| |/ _ \| '__| | __| | | |//  / / | | |/ _ \ | | |/ _ \
//  / ___/| |  | | (_) | |  | | |_| |_| / \_/ /| |_| |  __/ |_| |  __/
//  \/    |_|  |_|\___/|_|  |_|\__|\__, \___,_\ \__,_|\___|\__,_|\___|
//  Memorias de un informático     |___/

public class BinaryHeapPriorityQueue<T extends Comparable<? super T>> implements dataStructures.PriorityQueue.PriorityQueue<T> {

    // Internal binary heap
    private BinaryHeap<T> heap;

    // Constructor
    public BinaryHeapPriorityQueue(){
        heap = new BinaryHeap();
    }

    // Test for emptiness
    public boolean isEmpty(){
        return heap.isEmpty();
    }

    // Adds element to queue with priority
    public void enqueue(T x){
        heap.insert(x);
    }

    // Returns first element if possible
    public T first(){
        if (isEmpty()){
            throw new EmptyPriorityQueueException("Can't do first on empty queue");
        } else{
            return heap.minElem();
        }
    }

    // Delete minimum element in queue
    public void dequeue(){
        if (isEmpty()){
            throw new EmptyPriorityQueueException("Can't dequeue on empty queue");
        } else{
            heap.delMin();
        }
    }

    // String Representation
    @Override
    public String toString() {
        BinaryHeap<T> clonedHeap = new BinaryHeap<>(heap);
        String className = getClass().getSimpleName();
        String s = className+"(";
        boolean stop = clonedHeap.isEmpty();
        while(!stop) {
            s += clonedHeap.minElem();
            clonedHeap.delMin();
            stop = clonedHeap.isEmpty();
            if(!stop)
                s += ",";
        }
        s += ")";
        return s;
    }



}
