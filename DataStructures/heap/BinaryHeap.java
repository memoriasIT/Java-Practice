package dataStructures.heap;

import java.util.Arrays;

public class BinaryHeap<T extends Comparable<? super T>> implements Heap<T> {
    // Private variables
    private int size;
    private T elements[];

    // Constructors
    public BinaryHeap(int n){
        elements = (T[]) new Comparable[n];
        size = 0;
    }

    // Constructor without input
    private static final int DEFAULT_INITIAL_CAPACITY = 128;
    public BinaryHeap(){
        this(DEFAULT_INITIAL_CAPACITY);
    }

    // Constructor with binary heap
    public BinaryHeap(BinaryHeap<T> h){
        elements = Arrays.copyOf(h.elements, h.elements.length);
        size = h.size;
    }

    // Double capacity if full
    private void ensureCapacity(){
        if (size == elements.length){
            elements = Arrays.copyOf(elements, 2*elements.length);
        }
    }

    // Return number of elements in heap
    public int size(){
        return size;
    }

    // Test for emptiness
    public boolean isEmpty(){
        return size == 0;
    }

    // Delete all elements
    public void clear(){
        size = 0;
    }

    // Compare two elements by array index
    private boolean lessThan(int idx1, int idx2){
        return elements[idx1].compareTo(elements[idx2]) < 0;
    }

    // Swaps elements in array at positions idx1 and idx2
    private void swap(int idx1, int idx2) {
        T aux = elements[idx1];
        elements[idx1] = elements [idx2];
        elements[idx2] = aux;
    }


    // Root of heap is at index 0
    private static final int ROOT_INDEX = 0;

    // Check if index is root
    private static boolean isRoot(int idx){
        return idx == ROOT_INDEX;
    }

    // Returns index for parent of node with index idx
    private static int parent(int idx) {
        return (idx-1)/2;
    }

    // Returns index for left child of node with index idx
    private static int leftChild(int idx) {
        return 2*idx+1;
    }

    // Returns index for right child of node with index idx
    private static int rightChild(int idx) {
        return 1+leftChild(idx);
    }

    // Returns true if idx corresponds index of a node in tree
    private boolean isNode(int idx) {
        return idx<size;
    }

    // Returns true if idx has a left child
    private boolean hasLeftChild(int idx) {
        return leftChild(idx)<size;
    }

    // Returns true if idx is index of a leaf node
    private boolean isLeaf(int idx) {
        return !hasLeftChild(idx);
    }

    // Consider heap propert with parent
    private void heapifyUp(int idx){
        while(!isRoot(idx)) {
            int idxParent = parent(idx);

            // Check if need to swap with parent
            if (lessThan(idx, idxParent)){
                swap(idx, idxParent);
                idx = idxParent;
            } else {
                break;
            }
        }
    }

    // Insert element in heap
    public void insert(T x) {
        // Check for capacity
        ensureCapacity();

        // Enough capacity so save element
        elements[size] = x;
        // Might be necessary to change with parent
        heapifyUp(size);

        size++;
    }

    // Returns minElem();
    public T minElem(){
        if (isEmpty()) {
            throw new EmptyHeapException("Can't minElem on empty heap");
        } else {
            return elements[ROOT_INDEX];
        }
    }

    // Ensure heap property with childs
    private void HeapifyDown(){
        int idx = ROOT_INDEX;

        while(!isLeaf(idx)){
            // Get indexes of childs
            int idxChild = leftChild(idx);
            int idxRightChild = rightChild(idx);

            // idx child is index of child with minimum value
            if (isNode(idxRightChild) && lessThan(idxRightChild, idxChild)){
                idxChild = idxRightChild;
            }

            // Swap child if necessary
            if (lessThan(idxChild, idx)) {
                swap(idxChild, idx);
                idx = idxChild;
            } else {
                break;
            }
        }
    }

    public void delMin() {
        if(isEmpty()){
            throw new EmptyHeapException("Cant del min on empty heap");
        } else {
            elements[ROOT_INDEX] = elements[size-1];
            size--;
            HeapifyDown();
        }

    }


    // String Representation
    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        String s = className+"(";
        for(int i=0; i<size; i++)
            s += elements[i] + (i<size-1 ? "," : "");
        s += ")";
        return s;
    }

}
