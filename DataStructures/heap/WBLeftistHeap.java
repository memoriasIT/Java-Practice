package dataStructures.heap;

//   /\  /\___  __ _ _ __
//  / /_/ / _ \/ _` | '_ \
// / __  /  __/ (_| | |_) |
// \/ /_/ \___|\__,_| .__/
// MemoriasIT - 2019|_|

public class WBLeftistHeap<T extends Comparable<? super T>> implements Heap<T>{

    // Internal tree structure
    private static class Tree<E> {
        E elem;
        int weight;        // elements in tree
        Tree<E> left;
        Tree<E> right;
    }

    private Tree<T> root;

    // Constructor
    public WBLeftistHeap() {
        root = null;
    }
    public WBLeftistHeap(WBLeftistHeap<T> h){
        root = copy(h.root);
    }

    // Return number of elements
    private static<T> int weight(Tree<T> t){
        return t==null ? 0 : t.weight;
    }

    // Merge two heap trees with right spines to retun merged heap
    private static <T extends Comparable<? super T>> Tree<T> merge(Tree<T> h1, Tree<T> h2){
        // Any of the two are empty
        if (h1 == null){
            return h2;
        }
        if (h2 == null){
            return h1;
        }

        // Must have smaller root
        if (h2.elem.compareTo(h1.elem) < 0 ){
            // Swap
            Tree<T> tmp = h1;
            h1 = h2;
            h2 = tmp;
        }

        // Keep merging with right spine
        h1.right = merge(h1.right, h2);

        // Compute weight for left and right branches
        int wL = weight(h1.left);
        int wR = weight(h1.right);
        h1.weight = wL + wR +1; // Set new weight

        // Heavier on the left side
        if (wL < wR) {
            // Swap
            Tree<T> aux = h1.left;
            h1.left = h1.right;
            h1.right = aux;
        }

        return h1;
    }

    // Creates a copy of a tree
    private static <T extends Comparable<? super T>> Tree<T> copy(Tree<T> h){
        if (h == null){
            return null;
        } else {
            Tree<T> h1 = new Tree<>();
            h1.elem = h.elem;
            h1.weight = h.weight;
            h1.left = copy(h.left);
            h1.right = copy(h.right);
            return h1;
        }
    }

    // Test for emptiness
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    // Returns number of elements in heap
    @Override
    public int size() {
        return isEmpty() ? 0 : root.weight;
    }


    // Insert new element in heap
    @Override
    public void insert(T x) {
        // Create new Heap with given element
        Tree<T> newHeap = new Tree<>();
        newHeap.elem = x;
        newHeap.weight = 1;
        newHeap.left = null;
        newHeap.right = null;

        // Merge with current heap
        root = merge(root, newHeap);
    }

    // Returns min element
    @Override
    public T minElem() {
       if (isEmpty()){
           throw new EmptyHeapException("Heap is empty");
       } else {
           return root.elem;
       }
    }

    // Delete mininum element by merging branches
    @Override
    public void delMin() {
        if (isEmpty()){
            throw new EmptyHeapException("Heap is Empty");
        } else {
            root = merge(root.left, root.right);
        }
    }

    // Delete the whole tree
    public void clear() {
        root = null;
    }


    // String representation of Heap
    private static String toStringRec(Tree<?> tree) {
        return tree == null ? "null" : "Node<" + toStringRec(tree.left) + ","
                + tree.elem + "," + toStringRec(tree.right) + ">";
    }
    @Override
    public String toString() {
        String className = getClass().getSimpleName();

        return className+"("+toStringRec(this.root)+")";
    }
}
