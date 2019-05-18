package demos.stack;

import dataStructures.stack.LinkedStack;

import static java.lang.System.out;

public class LinkedStackDemo {
    public static void main(String[] args) {
        LinkedStack<Integer> foo = new LinkedStack<>();

        if (foo.isEmpty()) {
            out.println("Está vacio");
        }

        foo.push(3);
        foo.push(13);

        out.print(foo);
    }

}
