package Set;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedSet<T extends Comparable<? super T>> implements Set<T> {
   protected LinkedList<T> elements;
   public LinkedSet () {
       elements = new LinkedList<>();
   }

   public boolean isElem(T elem) {
       return elements.contains(elem);
   }

   public void insert(T elem) {
       if (!isElem(elem)) {
           elements.addLast(elem);
       }
   }

   public void delete(T elem) {
       elements.remove(elem);
   }

   public boolean isEmpty() {
       return elements.isEmpty();
   }

   public int size() {
       return elements.size();
   }

    @Override
    public String toString() {
       String name = "(";
       Iterator<T> it = elements.iterator();
       while(it.hasNext()) {
           name += it.next() + (it.hasNext() ? "," : "");
       }
       return name;
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }
}
