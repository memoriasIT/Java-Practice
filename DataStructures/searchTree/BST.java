package dataStructures.searchTree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.UnaryOperator;

import dataStructures.either.Either;
import dataStructures.either.Left;
import dataStructures.either.Right;
import dataStructures.stack.LinkedStack;
import dataStructures.stack.Stack;
import dataStructures.tuple.Tuple2;


//    ___  __  _____
//   / __\/ _\/__   \
//  /__\//\ \   / /\/
// / \/  \_\ \ / /
// \_____/\__/ \/
// MemoriasIT - 2019


public class BST<K extends Comparable<? super K>, V> implements SearchTree<K, V> {

    // Tree Structure for BST
    private static class Tree<K, V> {
        K key;
        V value;

        //Branches
        Tree<K, V> left;
        Tree<K, V> right;

        // Constructor
        public Tree(K k, V v) {
            key = k;
            value = v;
            left = null;
            right = null;
        }
    }

    private Tree<K, V> root;
    private int size;

    // Empty BST Constructor
    public BST() {
        root = null;
        size = 0;
    }

    // True if empty, else false | O(1)
    public boolean isEmpty() {
        return root == null;
    }

    // Returns size of tree | O(1)
    public int size() {
        return size;
    }

    // Returns height of the tree recursively
    public int height() {
        return heightRec(root);
    }
    private static int heightRec(Tree<?, ?> root) {
        return root == null ? 0 : 1 + Math.max(heightRec(root.left), heightRec(root.right));
    }

    // Insert element into tree
    @Override
    public void insert(K k, V v) {
        root = insertRec(root, k, v);
    }
    private Tree<K,V> insertRec(Tree<K, V> node, K key, V value){
       if (node == null) {                      // Null/exit case
           node = new Tree<> (key, value);
           size++;
       } else if (key.compareTo(node.key) < 0){ // Given node is less than current
           node.left = insertRec(node.left, key, value);
       } else if (key.compareTo(node.key) > 0) { // Given node is greater than current
           node.right = insertRec(node.right, key, value);
       } else {                                  // Same key, replace value
           node.value = value;
       }

       return node;
    }

    // Search element by key
    @Override
    public V search(K k) {
        return searchRec(root, k);
    }
    private static <K extends Comparable<? super K>, V> V searchRec(Tree<K, V> tree, K key){
        if (tree == null){                        // Null/exit case
            return null;
        } else if (key.compareTo(tree.key) < 0){ // Lower than current node
            return searchRec(tree.left, key);
        } else if (key.compareTo(tree.key) > 0) { // Greater than current node
            return searchRec(tree.right, key);
        } else {                                  // Found value
            return tree.value;
        }

    }

    // Test for element
    @Override
    public boolean isElem(K k) {
        return search(k) != null;
    }


    // Pre: node is a non-empty tree
    // Removes minimum key (and value) from tree rooted at node. Before
    // deletion, key and value are saved into temp node.
    // Returns modified tree (without min key and value)
    private static <K extends Comparable<? super K>,V>
    Tree<K, V> split(Tree<K, V> node, Tree<K, V> temp) {
        if (node.left == null) {
            // Min node found, so copy min key and value
            temp.key = node.key;
            temp.value = node.value;
            return node.right; // Remove node
        } else {
            // Remove min from left subtree
            node.left = split(node.left, temp);
            return node;
        }
    }

    // Delete element by key
    @Override
    public void delete(K k) {
        root = deleteRec(root, k);
    }
    private Tree<K, V> deleteRec(Tree<K, V> node, K key) {
        if (node == null)                               // Key not found; do nothing
            ;
        else if (key.compareTo(node.key) < 0)           // Key less than current node
            node.left = deleteRec(node.left, key);
        else if (key.compareTo(node.key) > 0)           // Key greater than current node
            node.right = deleteRec(node.right, key);
        else {                                          // Found node
            if (node.left == null)                          // Left child free -> Set right child as current
                node = node.right;
            else if (node.right == null)                    // Right child free -> Set left child as current
                node = node.left;
            else                                            // Not free -> Split right spine
                node.right = split(node.right, node);
            size--;
        }
        return node;
    }

    // Returns minimum element
    @Override
    public V minim() {
        // Tree is empty
        if (root == null)
            throw new EmptySearchTreeException("minim on empty tree");
        else {
            // Temp variable to traverse tree
            Tree<K,V> node = root;

            // Traverse along left spine until child found
            while (node.left != null)
                node = node.left;
            return node.value;
        }
    }

    @Override
    public V maxim() {
        // Tree is empty
        if (root == null)
            throw new EmptySearchTreeException("maxim on empty tree");
        else {
            // Temp variable to traverse tree
            Tree<K,V> node = root;

            // Traverse along right spine until child found
            while (node.right != null)
                node = node.right;
            return node.value;
        }
    }

    @Override
    public void deleteMinim() {
        // Tree is empty
        if (isEmpty())
            throw new EmptySearchTreeException("deleteMinim on empty tree");
        else {
            // Temp variables for traversing
            Tree<K,V> parent = null;
            Tree<K,V> node = root;

            // Traverse left spine until child found
            while (node.left != null) {
                parent = node;
                node = node.left;
            }

            // Check if left child is empty
            if (parent == null)
                root = root.right;
            else
                parent.left = node.right;
            size--;
        }
    }

    @Override
    public void deleteMaxim() {
        // Tree is empty
        if (isEmpty())
            throw new EmptySearchTreeException("deleteMaxim on empty tree");
        else {
            // Temp variables for traversing
            Tree<K,V> parent = null;
            Tree<K,V> node = root;

            // Traverse along right spine until child found
            while (node.right != null) {
                parent = node;
                node = node.right;
            }

            // Check if childs are empty
            if (parent == null)
                root = root.left;
            else
                parent.right = node.left;
            size--;
        }
    }

    // Update or insert by using unary operator
    public void updateOrInsert(UnaryOperator<V> f, K k, V v) {
        root = updateOrInsertRec(root, f, k, v);
    }
    private Tree<K, V> updateOrInsertRec(Tree<K, V> node, UnaryOperator<V> f, K key, V value) {
        if (node == null) {                                             // Tree is empty
            node = new Tree<>(key, value);
            size++;
        } else if (key.compareTo(node.key) < 0)                         // Value is at the left
            node.left = updateOrInsertRec(node.left, f, key, value);
        else if (key.compareTo(node.key) > 0)                           // Value is at the right
            node.right = updateOrInsertRec(node.right, f, key, value);
        else                                                            // Value found apply function
            node.value = f.apply(node.value);
        return node;
    }


    private abstract class Traversal {
        Stack<Either<Tree<K,V>, Tree<K,V>>> stack = new LinkedStack<>();

        abstract void save(Tree<K,V> node);

        public Traversal() {
            if (root != null)
                save(root);
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public Tree<K,V> nextTree() {
            if (!hasNext())
                throw new NoSuchElementException();

            Either<Tree<K,V>, Tree<K,V>> either = stack.top();
            stack.pop();

            while (either.isRight()) {
                Tree<K,V> node = either.right();
                save(node);
                either = stack.top();
                stack.pop();
            }
            return either.left();
        }
    }

    private class InOrderTraversal extends Traversal {
        void save(Tree<K,V> node) {
            // in reverse order, cause stack is LIFO
            if (node.right != null)
                stack.push(new Right<>(node.right));
            stack.push(new Left<>(node));
            if (node.left != null)
                stack.push(new Right<>(node.left));
        }
    }

    private class PreOrderTraversal extends Traversal {
        void save(Tree<K,V> node) {
            // in reverse order, cause stack is LIFO
            if (node.right != null)
                stack.push(new Right<>(node.right));
            if (node.left != null)
                stack.push(new Right<>(node.left));
            stack.push(new Left<>(node));
        }
    }

    private class PostOrderTraversal extends Traversal {
        void save(Tree<K,V> node) {
            // in reverse order, cause stack is LIFO
            stack.push(new Left<>(node));
            if (node.right != null)
                stack.push(new Right<>(node.right));
            if (node.left != null)
                stack.push(new Right<>(node.left));
        }
    }

    private class InOrderIt extends InOrderTraversal implements Iterator<K> {
        public K next() {
            return super.nextTree().key;
        }
    }

    private class PreOrderIt extends PreOrderTraversal implements Iterator<K> {
        public K next() {
            return super.nextTree().key;
        }
    }

    private class PostOrderIt extends PostOrderTraversal implements Iterator<K> {
        public K next() {
            return super.nextTree().key;
        }
    }

    public Iterable<K> inOrder() {
        return new Iterable<K>(){
            public Iterator<K> iterator() {
                return new InOrderIt();
            }
        };
    }

    public Iterable<K> preOrder() {
        return new Iterable<K>(){
            public Iterator<K> iterator() {
                return new PreOrderIt();
            }
        };
    }

    public Iterable<K> postOrder() {
        return new Iterable<K>(){
            public Iterator<K> iterator() {
                return new PostOrderIt();
            }
        };
    }


    private class ValuesIt extends InOrderTraversal implements Iterator<V> {
        public V next() {
            return super.nextTree().value;
        }
    }

    public Iterable<V> values() {
        return new Iterable<V>(){
            public Iterator<V> iterator() {
                return new ValuesIt();
            }
        };
    }

    private class KeysValuesIt extends InOrderTraversal implements Iterator<Tuple2<K,V>> {
        public Tuple2<K,V> next() {
            Tree<K,V> node = super.nextTree();
            return new Tuple2<>(node.key, node.value);
        }
    }

    public Iterable<Tuple2<K,V>> keysValues() {
        return new Iterable<Tuple2<K,V>>(){
            public Iterator<Tuple2<K,V>> iterator() {
                return new KeysValuesIt();
            }
        };
    }

    private static String toStringRec(Tree<?, ?> tree) {
        return tree == null ? "null" : "Node<" + toStringRec(tree.left) + ","
                + tree.key + "," + tree.value + "," + toStringRec(tree.right) + ">";
    }

    // String representation
    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        return className+"("+toStringRec(this.root)+")";
    }


}
