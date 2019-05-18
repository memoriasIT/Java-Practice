package dataStructures.queue;

//     ____
//    /___ \_   _  ___ _   _  ___
//   //  / / | | |/ _ \ | | |/ _ \
//  / \_/ /| |_| |  __/ |_| |  __/
//  \___,_\ \__,_|\___|\__,_|\___|
// Memorias de un informático - 2018

public interface Queue<T> {

    // True if queue is empty
    boolean isEmpty();

    // Add element at the rear of the queue
    void enqueue(T x);

    // Gets first element
    T first();

    // Removes first element from queue
    void dequeue();
}
