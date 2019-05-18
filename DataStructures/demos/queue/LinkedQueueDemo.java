package demos.queue;

import dataStructures.queue.LinkedQueue;

import static java.lang.System.out;

public class LinkedQueueDemo {
    public static void main(String[] args) {
        LinkedQueue<Integer> foo = new LinkedQueue<>();

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
