package demos.set;

import static java.lang.System.out;

import dataStructures.set.SortedLinkedSet;

//   __      _
//  / _\ ___| |_
//  \ \ / _ \ __|
//  _\ \  __/ |_
//  \__/\___|\__|
// MemoriasIT - 2018

public class SortedLinkedSetDemo {
    public static void main(String[] args) {
        SortedLinkedSet<Integer> foo = new SortedLinkedSet<>();

        // Insert elements in random order
        foo.insert(4);
        foo.insert(3);
        foo.insert(23);

        // toString
        out.println(foo);

        // Delete element
        foo.delete(3);

        // isEmpty
        if (!foo.isEmpty()) {
            out.print(foo);
        }
    }
}
