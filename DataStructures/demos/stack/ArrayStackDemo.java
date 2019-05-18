package demos.stack;

import static java.lang.System.out;

import dataStructures.stack.ArrayStack;

//    __ _             _
//   / _\ |_ __ _  ___| | __
//   \ \| __/ _` |/ __| |/ /
//   _\ \ || (_| | (__|   <
//   \__/\__\__,_|\___|_|\_\
//   MemoriasIT - 2018

public class ArrayStackDemo {
    public static void main(String[] args) {
        // Generate empty stack
        ArrayStack<Character> foo = new ArrayStack<Character>();

        // Print empty Stack
        out.println("Empty Stack: " + foo);

        // Add element
        foo.push('a');
        out.println("Adding element: " + foo);

        // Delete element
        foo.pop();
        out.println("Foo after pop: " + foo);

        // isEmpty and top
        if (foo.isEmpty()) {
            out.println("Stack is empty");
        } else {
            out.println("Stack is not empty and top element is: " + foo.top());
        }
    }
}
