package dataStructures.set;

import java.util.Iterator;
import java.util.LinkedList;

//   __      _
//  / _\ ___| |_
//  \ \ / _ \ __|
//  _\ \  __/ |_
//  \__/\___|\__|
// MemoriasIT - 2018

public class LinkedListSet<T extends Comparable<? super T>> implements Set<T> {
    protected LinkedList<T> elements;

    public LinkedListSet() {
        elements = new LinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public void insert(T x) {
        if (!elements.contains(x)) {
            elements.addLast(x);
        }
    }

    @Override
    public boolean isElem(T x) {
        return elements.contains(x);
    }

    @Override
    public void delete(T x) {
        elements.remove(x);
    }

    @Override
    public String toString() {
        String className = getClass().getName().substring(getClass().getPackage().getName().length() + 1);
        String text = className + "(";
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            text += it.next() + (it.hasNext() ? "," : "");
        }
        return text + ")";
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }
}
