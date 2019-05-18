package dataStructures.set;

import java.util.Iterator;
import dataStructures.searchTree.AVL;
import dataStructures.searchTree.SearchTree;

//   __      _
//  / _\ ___| |_
//  \ \ / _ \ __|
//  _\ \  __/ |_
//  \__/\___|\__|
// MemoriasIT - 2018

public class AVLSet<T extends Comparable<? super T>> implements Set<T> {

    // Private variables
    private static class Nothing{};
    private static Nothing nothing = new Nothing();

    private SearchTree<T, Nothing> tree;

    // Constructor
    public AVLSet(){
        tree = new AVL<>();
    }

    // Delete elem from set
    public void delete(T elem){
        tree.delete(elem);
    }

    // Insert element in tree
    public void insert(T elem){
        tree.insert(elem, nothing);
    }

    // Test for element in set
    public boolean isElem(T elem){
        return tree.isElem(elem);
    }

    // Return number of elements
    public int size(){
        return tree.size();
    }

    // Test for emptiness
    public boolean isEmpty(){
        return tree.isEmpty();
    }

    // Iterator in ordern
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
