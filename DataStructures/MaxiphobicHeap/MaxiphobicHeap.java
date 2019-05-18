public class MaxiphobicHeap<T extends Comparable<? super T>> implements Heap<T> {
    private static class Tree<E> {
        E elem;
        int weight;
        Tree<E> left;
        Tree<E> right;
    }

    private Tree<T> root;

   private static<T extends Comparable<? super T>> Tree<T> merge(Tree<T> h1, Tree<T> h2){
       // Null cases
       if (h1 == null){
           return h2;
       } else if (h2 == null) {
           return h1;
       }

       // Minimum root
       if (h2.elem.compareTo(h1.elem) < 0){
           //Swap
           Tree<T> temp = h1;
           h1 = h2;
           h2 = temp;
       }

       //Maxiphobic
       if (weight(h1.left) > weight(h1.right)){
           // Swap
           Tree<T> temp = h1.left;
           h1.left = h1.right;
           h1.right = temp;
           // Now minimum is on the left
       }

       if (weight(h2) > weight(h1.right)){
           //Swap
           Tree<T> tmp = h1.right;
           h1.right = h2;
           h2 = tmp;
       }

       h1.left = merge(h1.left, h2);
       return h1;



   }


    private static<T> int weight(Tree<T> left){
        int resultado = 0;
        if ( left != null){
            resultado = left.weight;
        }
        return resultado;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        int resultado = 0;
        if (root != null) {
            resultado = root.weight;
        }
        return resultado;
    }

    @Override
    public void insert(T x) {
        Tree<T> newT = new Tree<T>();
        newT.elem = x;
        newT.weight = 1;
        newT.left = null;
        newT.right = null;
    }

    @Override
    public T minElem() {
        if (isEmpty()) {
            throw new EmptyHeapException("minElem on empty tree");
        }
        return root.elem;
    }

    @Override
    public void delMin() {
        if (isEmpty()) {
            throw new EmptyHeapException("Can't delete on empty tree");
        } else {
            root = merge(root.left, root.right);
        }
    }
}
