package demos.set;

import dataStructures.set.LinkedListSet;

import static java.lang.System.out;

//   __      _
//  / _\ ___| |_
//  \ \ / _ \ __|
//  _\ \  __/ |_
//  \__/\___|\__|
// MemoriasIT - 2018

public class LinkedListSetDemo {
    public static void main(String[] args) {
        LinkedListSet<Integer> foo = new LinkedListSet<Integer>();

        // Insert element
        foo.insert(2);

        // Doesn't insert it if it's already in
        foo.insert(2);

        // isElem
        if (foo.isElem(2)) {
            // toString
            out.println(foo);
        }

        // Print Set size
        out.println("Size: " + foo.size());
    }

}
