package dataStructures.vector;

import java.util.Iterator;

public class SparseVector<T> implements Iterable<T> {

    protected interface Tree<T> {

        T get(int sz, int i);

        Tree<T> set(int sz, int i, T x);
    }

    // Unif Implementation

    protected static class Unif<T> implements Tree<T> {

        private T elem;

        public Unif(T e) {
            elem = e;
        }

        @Override
        public T get(int sz, int i) {
           if(i > sz || i < 0) {
               throw new VectorException("Index out of Bounds");
           }
           return elem;
        }

        @Override
        public Tree<T> set(int sz, int i, T x) {
           if (i < 0 || i > sz){
               throw new VectorException("Index out of Bounds");
           }
           if (sz == 1){
               elem = x;
               return this;
           } else {
               if (x.equals(elem)){
                   elem = x;
                   return this;
               } else {
                   if (i < sz/2){
                       return new Node<T>(new Unif<T>(elem).set(sz/2, i%(sz/2), x), new Unif<T>(elem)).simplify();
                   } else {
                       return new Node<T>(new Unif<T>(elem), new Unif<T>(elem).set(sz/2, i%(sz/2),x)).simplify();
                   }
               }
           }
        }

        @Override
        public String toString() {
            return "Unif(" + elem + ")";
        }
    }

    // Node Implementation

    protected static class Node<T> implements Tree<T> {

        private Tree<T> left, right;

        public Node(Tree<T> l, Tree<T> r) {
            left = l;
            right = r;
        }

        @Override
        public T get(int sz, int i) {
           if (i < 0 || i > sz){
               throw new VectorException("Index out of Bounds exception");
           }
           T res = null;
           // If is UNIF
           if (left instanceof  Unif && right instanceof Unif){
               // Return res
               if (i < sz/2){
                   Unif<T> aux = (Unif<T>) left;
                   res = aux.elem;
               } else {
                   Unif<T> aux = (Unif<T>) right;
                   res = aux.elem;
               }
           // NOT UNIF
           } else {
               // Recursive call to get with left or right
               if (i < sz/2) {
                   return left.get((sz/2), i);
               } else if (i > sz/2){
                   return right.get(sz/2, i-(sz/2));
               }
           }

           return res;
        }

        @Override
        public Tree<T> set(int sz, int i, T x) {
           // Recursive call to set
            if (i < sz/2){
               left = left.set(sz/2, i, x);
           } else {
               right = right.set(sz/2, i, x);
           }

           return simplify();
        }


        protected Tree<T> simplify() {
            if(left instanceof Unif && right instanceof Unif){
                Unif<T> l = (Unif<T>) left;
                Unif<T> r = (Unif<T>) right;

                if (l.elem.equals(r.elem)){
                    return l;
                } else{
                    return this;
                }
            }
            return this;
        }

        @Override
        public String toString() {
            return "Node(" + left + ", " + right + ")";
        }
    }

    // SparseVector Implementation

    private int size;
    private Tree<T> root;

    public SparseVector(int n, T elem) {
       if (n < 0){
           throw new VectorException("Index < 0");
       }
       size = Math.toIntExact(Math.round(Math.pow(2, n)));
       root = new Unif<>(elem);

    }

    public int size() {
       return size;
    }

    public T get(int i) {
       return root.get(size, i);
    }

    public void set(int i, T x) {
        root = root.set(size, i, x);
    }



    @Override
    public Iterator<T> iterator() {
       return new SparseIterator();
    }

    private class SparseIterator implements Iterator<T>{
        private int current;

        public SparseIterator(){
            current = 0;
        }

        @Override
        public boolean hasNext(){
            return current < size;
        }

        @Override
        public T next(){
            T res = root.get(size, current);
            current++;
            return res;
        }
    }


    @Override
    public String toString() {
        return "SparseVector(" + size + "," + root + ")";
    }
}

