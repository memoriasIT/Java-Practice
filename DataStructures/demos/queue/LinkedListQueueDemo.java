package demos.queue;

import static java.lang.System.out;

import dataStructures.queue.LinkedListQueue;


public class LinkedListQueueDemo {
    public static void main(String[] args) {
        LinkedListQueue<Integer> foo = new LinkedListQueue();

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
