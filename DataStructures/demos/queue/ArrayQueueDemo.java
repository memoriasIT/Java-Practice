package demos.queue;

import static java.lang.System.out;

import dataStructures.queue.ArrayQueue;


//     ____
//    /___ \_   _  ___ _   _  ___
//   //  / / | | |/ _ \ | | |/ _ \
//  / \_/ /| |_| |  __/ |_| |  __/
//  \___,_\ \__,_|\___|\__,_|\___|
// Memorias de un informático - 2018

public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue<Integer> foo = new ArrayQueue<>();

        // isEmpty
        if (foo.isEmpty()) {
            out.println("Queue is empty");
        }

        // Add elements
        foo.enqueue(1);
        foo.enqueue(2);
        foo.enqueue(3);

        // Delete elements
        foo.dequeue();


        // To String
        out.println(foo);
    }

}
