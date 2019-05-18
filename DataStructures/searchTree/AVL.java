package dataStructures.searchTree;

// Java imports

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.UnaryOperator;

// DataStructures import
import dataStructures.either.Either;
import dataStructures.either.Left;
import dataStructures.either.Right;
import dataStructures.stack.LinkedStack;
import dataStructures.stack.Stack;
import dataStructures.tuple.Tuple2;

//      _         __
//     /_\/\   /\/ /
//    //_\\ \ / / /
//   /  _  \ V / /___
//   \_/ \_/\_/\____/
//  MemoriasIT - 2018

public class AVL<K extends Comparable<? super K>, V> implements SearchTree<K, V> {
    // Tree Structure
    private static class Tree<K, V> {
        K key;
        V value;
        int height;
        Tree<K, V> left;
        Tree<K, V> right;

        // Constructor
        public Tree(K k, V v) {
            key = k;
            value = v;
            height = 1;
            left = null;
            right = null;
        }

        // Return height of tree
        public static int height(Tree<?, ?> tree) {
            return tree == null ? 0 : tree.height;
        }

        // By the nature of AVL it should self balance
        public boolean rightLeaning() {
            return height(right) >= height(left);
        }

        public boolean leftLeaning() {
            return height(right) <= height(left);
        }

        // Calculate height
        void setHeight() {
            height = 1 + Math.max(height(left), height(right));
        }

        // Rotate right to balance tree
        // Animation: https://en.wikipedia.org/wiki/AVL_tree#/media/File:AVL_Tree_Example.gif
        public Tree<K, V> rotR() {
            Tree<K, V> lt = this.left;
            Tree<K, V> lrt = lt.left;

            this.left = lrt;
            this.setHeight();

            lt.right = this;
            lt.setHeight();

            return lt;
        }

        // Rotate right to balance tree
        // Animation: https://en.wikipedia.org/wiki/AVL_tree#/media/File:AVL_Tree_Example.gif
        public Tree<K, V> rotL() {
            Tree<K, V> rt = this.right;
            Tree<K, V> rlt = rt.left;

            this.right = rlt;
            this.setHeight();

            rt.left = this;
            rt.setHeight();

            return rt;
        }

        // Returns balanced tree
        public Tree<K, V> balance() {
            int lh = height(left);
            int rh = height(right);

            Tree<K, V> balanced;

            // All cases illustrated
            // http://wikistack.com/wp-content/uploads/2017/11/avl-tree-rotation.jpeg
            if (lh - rh > 1 && left.rightLeaning()) {           // Left-Right Case
                left = left.rotL();
                balanced = this.rotR();
            } else if (lh - rh > 1) {                           // Left-Left Case
                balanced = this.rotR();
            } else if (rh - lh > 1 && right.leftLeaning()) {    // Right-Left Case
                right = right.rotR();
                balanced = this.rotL();
            } else if (rh - lh > 1) {                           // Right-Right Case
                balanced = this.rotL();
            } else {
                balanced = this;                                // Already Balanced
                balanced.setHeight();
            }
            return balanced;
        }

        interface Predicate<T> {
            boolean apply(T x);
        }

        // Apply to tree
        public static <K> boolean all(Predicate<K> p, Tree<K, ?> tree) {
            if (tree == null) {
                return true;
            } else {
                return (p.apply(tree.key) && all(p, tree.left) && all(p, tree.right));
            }
        }

        // Check if a tree is AVL
        public static <K extends Comparable<? super K>> boolean isAVL(final Tree<K, ?> tree) {
            if (tree == null)                                                              // Empty tree are always AVL
                return true;
            else {                                                                      // Not empty
                Predicate<K> lesser = new Predicate<K>() {                              // Lesser Predicate
                    public boolean apply(K k) {
                        return k.compareTo(tree.key) < 0;
                    }
                };

                Predicate<K> greater = new Predicate<K>() {                              // Greater Predicate
                    public boolean apply(K k) {
                        return k.compareTo(tree.key) > 0;
                    }
                };

                return (Math.abs(height(tree.left) - height(tree.right)) < 2)               // Must be balanced
                        && all(lesser, tree.left)                                          //less(tree.key,tree.left)
                        && all(greater, tree.right)                                        //greater(tree.key,tree.right)
                        && isAVL(tree.left)                                               // Subtrees must be AVL too
                        && isAVL(tree.right);                                             // Subtrees must be AVL too
            }
        }
    }

    // Private Variables
    private Tree<K, V> root;
    private int size;

    // Constructor | O(1)
    public AVL() {
        root = null;
        size = 0;
    }

    // Check if tree is AVL (public for testing)
    public boolean isAVL() {
        return Tree.isAVL(root);
    }

    // True if tree is empty, else false | O(1)
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns size of tree | O(1)
    @Override
    public int size() {
        return size;
    }

    // Returns tree height | O(log n)
    @Override
    public int height() {
        return Tree.height(root);
    }

    // TreeSearch | O(log n)
    @Override
    public V search(K k) {
        return searchRec(root, k);
    }

    // Recursive search
    private static <K extends Comparable<? super K>, V> V searchRec(Tree<K, V> tree, K key) {
        // If tree is empty element not present
        if (tree == null)
            return null;
        else if (key.compareTo(tree.key) < 0)   // Element lower -> left branch
            return searchRec(tree.left, key);
        else if (key.compareTo(tree.key) > 0)   // Element greater -> right branch
            return searchRec(tree.right, key);
        else
            return tree.value;                  // Equal -> Found
    }


    // Recursive insertion | O(log n)
    @Override
    public void insert(K k, V v) {
        root = insertRec(root, k, v);
    }

    // Returns modified tree, tree must be balanced after insertion
    private Tree<K, V> insertRec(Tree<K, V> node, K key, V value) {
        if (node == null) {                                         // Not found/tree empty, create node
            node = new Tree<>(key, value);
            size++;
        } else if (key.compareTo(node.key) < 0) {                   // Lower -> left branch
            node.left = insertRec(node.left, key, value);
            node = node.balance();
        } else if (key.compareTo(node.key) > 0) {                   // Greater -> right branch
            node.right = insertRec(node.right, key, value);
            node = node.balance();
        } else                                                      // Equal -> Change value
            node.value = value;
        return node;
    }


    // True if element found
    @Override
    public boolean isElem(K k) {
        return search(k) != null;
    }

    // pre: node is a non-empty tree
    // Removes minimum key (and value) from tree rooted at node. Before
    // deletion, key and value are saved into temp node.
    // returns modified tree (without min key and value)
    private static <K extends Comparable<? super K>, V>
    Tree<K, V> split(Tree<K, V> node, Tree<K, V> temp) {
        if (node.left == null) {
            // min node found, so copy min key and value
            temp.key = node.key;
            temp.value = node.value;
            return node.right; // remove node
        } else {
            // remove min from left subtree
            node.left = split(node.left, temp);
            node = node.balance();
            return node;
        }
    }

    // Recursive deletion | O(log n)
    @Override
    public void delete(K key) {
        root = deleteRec(root, key);
    }

    // Returns modified tree
    private Tree<K, V> deleteRec(Tree<K, V> node, K key) {
        if (node == null)
            ;                                           // Key not found; do nothing
        else if (key.compareTo(node.key) < 0) {         // Key is lower than node ->   Left branch
            node.left = deleteRec(node.left, key);
            node = node.balance();
        } else if (key.compareTo(node.key) > 0) {       // Key is greater than node -> Right branch
            node.right = deleteRec(node.right, key);
            node = node.balance();
        } else {                                       // Equal -> Delete
            if (node.left == null)                      // Left is already null
                node = node.right;
            else if (node.right == null)                // Both null
                node = node.left;                       //
            else {
                node.right = split(node.right, node);
                node = node.balance();
            }
            size--;
        }
        return node;
    }

    // Return minim elem | O(log n)
    @Override
    public V minim() {
        if (root == null) {
            throw new EmptySearchTreeException("Can't do minim on empty tree");
        }

        Tree<K, V> node = root;

        while (node.left != null) {
            node = node.left;
        }

        return node.value;
    }

    // Return maximum element
    @Override
    public V maxim() {
        if (root == null) {
            throw new EmptySearchTreeException("Can't do maxim on empty tree");
        }

        Tree<K, V> aux = root;
        while (aux.right != null) {
            aux = aux.right;
        }

        return aux.value;
    }

    @Override
    public void deleteMinim() {
        if (isEmpty()) {
            throw new EmptySearchTreeException("deleteMinim on empty tree");
        }

        root = deleteMinimRec(root);
        size--;
    }

    private static <K, V> Tree<K, V> deleteMinimRec(Tree<K, V> node) {
        if (node.left == null) {
            node = node.right;
        } else {
            node.left = deleteMinimRec(node.left);
            node = node.balance();
        }
        return node;
    }

    // Deletes the maximum element
    @Override
    public void deleteMaxim() {
        if (isEmpty()) {
            throw new EmptySearchTreeException("Can't delete maxim on empty tree");
        } else {
            root = deleteMaximRec(root);
            size--;
        }
    }

    private static <K, V> Tree<K, V> deleteMaximRec(Tree<K, V> node) {
        if (node.right == null) {
            node = node.left;
        } else {
            node.right = deleteMinimRec(node.right);
            node = node.balance();
        }

        return node;
    }

    // We traverse using a stack
    private abstract class Traversal {
        Stack<Either<Tree<K, V>, Tree<K, V>>> stack = new LinkedStack<>();

        abstract void save(Tree<K, V> node);

        // Constructor
        public Traversal() {
            if (root != null) {
                save(root);
            }
        }

        // Will have next if the stack isn't empty
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public Tree<K, V> nextTree() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Either<Tree<K, V>, Tree<K, V>> either = stack.top();
            stack.pop();

            while (either.isRight()) {
                Tree<K, V> node = either.right();
                save(node);
                either = stack.top();
                stack.pop();
            }

            return either.left();
        }
    }


    private class InOrderTraversal extends Traversal {
        void save(Tree<K, V> node) {
            // in reverse order, cause stack is LIFO
            if (node.right != null)
                stack.push(new Right<>(node.right));
            stack.push(new Left<>(node));
            if (node.left != null)
                stack.push(new Right<>(node.left));
        }
    }

    private class PreOrderTraversal extends Traversal {
        void save(Tree<K, V> node) {
            // in reverse order, cause stack is LIFO
            if (node.right != null)
                stack.push(new Right<>(node.right));
            if (node.left != null)
                stack.push(new Right<>(node.left));
            stack.push(new Left<>(node));
        }
    }

    private class PostOrderTraversal extends Traversal {
        void save(Tree<K, V> node) {
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
        return new Iterable<K>() {
            public Iterator<K> iterator() {
                return new InOrderIt();
            }
        };
    }

    public Iterable<K> preOrder() {
        return new Iterable<K>() {
            public Iterator<K> iterator() {
                return new PreOrderIt();
            }
        };
    }

    public Iterable<K> postOrder() {
        return new Iterable<K>() {
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
        return new Iterable<V>() {
            public Iterator<V> iterator() {
                return new ValuesIt();
            }
        };
    }

    private class KeysValuesIt extends InOrderTraversal implements Iterator<Tuple2<K, V>> {
        public Tuple2<K, V> next() {
            Tree<K, V> node = super.nextTree();
            return new Tuple2<>(node.key, node.value);
        }
    }

    public Iterable<Tuple2<K, V>> keysValues() {
        return new Iterable<Tuple2<K, V>>() {
            public Iterator<Tuple2<K, V>> iterator() {
                return new KeysValuesIt();
            }
        };
    }

    public void updateOrInsert(UnaryOperator<V> f, K k, V v) {
        root = updateOrInsertRec(root, f, k, v);
    }

    // returns modified tree
    private Tree<K, V> updateOrInsertRec(Tree<K, V> node, UnaryOperator<V> f, K key, V value) {
        if (node == null) {
            node = new Tree<>(key, value);
            size++;
        } else if (key.compareTo(node.key) < 0) {
            node.left = updateOrInsertRec(node.left, f, key, value);
            node = node.balance();
        } else if (key.compareTo(node.key) > 0) {
            node.right = updateOrInsertRec(node.right, f, key, value);
            node = node.balance();
        } else
            node.value = f.apply(node.value);
        return node;
    }


    private static String toStringRec(Tree<?, ?> tree) {
        return tree == null ? "null" : "Node<" + toStringRec(tree.left) + ","
                + tree.key + "," + tree.value + "," + toStringRec(tree.right) + ">";
    }

    /**
     * Returns representation of AVL tree as a String.
     */
    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        return className + "(" + toStringRec(this.root) + ")";
    }


}
