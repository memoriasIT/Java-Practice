package dataStructures.set;
import dataStructures.searchTree.BST;
import dataStructures.searchTree.SearchTree;

import java.util.Iterator;

//   __      _
//  / _\ ___| |_
//  \ \ / _ \ __|
//  _\ \  __/ |_
//  \__/\___|\__|
// MemoriasIT - 2018

public class BSTSet<T extends Comparable<? super T>> implements Set<T>{

    // Private BST Tree for storing elements
    private static class Nothing{};
    private static Nothing nothing = new Nothing();

    private SearchTree<T, Nothing> tree;


    // Constructor
    public BSTSet(){
        tree = new BST<>();
    }

    // Delete element from tree
    public void delete(T elem){
        tree.delete(elem);
    }

    // Insert element to tree
    public void insert(T elem) {
        tree.insert(elem, nothing);
    }

    // Test for element in set
    public boolean isElem(T elem) {
        return tree.isElem(elem);
    }

    // Return number of elements in set
    public int size() {
        return tree.size();
    }

    // Test for emptiness
    public boolean isEmpty() {
        return tree.isEmpty();
    }


    // Iterator in order for set
    public Iterator<T> iterator(){
        return tree.inOrder().iterator();
    }

    // String representation
    public String toString() {
        String className = getClass().getSimpleName();
        String s = className+"(";
        Iterator<T> it = this.iterator();
        while(it.hasNext())
            s += it.next() + (it.hasNext() ? "," : "");
        s += ")";
        return s;
    }

}
