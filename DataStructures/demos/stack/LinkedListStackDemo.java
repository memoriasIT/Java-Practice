package demos.stack;

import dataStructures.stack.LinkedListStack;

import static java.lang.System.out;

//    __ _             _
//   / _\ |_ __ _  ___| | __
//   \ \| __/ _` |/ __| |/ /
//   _\ \ || (_| | (__|   <
//   \__/\__\__,_|\___|_|\_\
//   MemoriasIT - 2018

public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack<Integer> foo = new LinkedListStack<>();

        if (foo.isEmpty()) {
            out.println("foo is empty.");
        }

        foo.push(2);
        foo.push(3);

        out.println(foo.top());
        foo.pop();
        out.println(foo);

    }

}
