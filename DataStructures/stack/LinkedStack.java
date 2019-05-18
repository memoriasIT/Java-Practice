package dataStructures.stack;

//    __ _             _
//   / _\ |_ __ _  ___| | __
//   \ \| __/ _` |/ __| |/ /
//   _\ \ || (_| | (__|   <
//   \__/\__\__,_|\___|_|\_\
//   MemoriasIT - 2018

public class LinkedStack<T> implements Stack<T> {

    // Nodes for Linked Structure
    static private class Node<E> {
        E elem;
        Node<E> next;

        public Node(E x, Node<E> node) {
            elem = x;
            next = node;
        }
    }

    private Node<T> top;

    // Constructor
    public LinkedStack() {
        top = null;
    }

    // True if is empty, else false
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    // Add element to stack
    @Override
    public void push(T x) {
        top = new Node<>(x, top);
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new EmptyStackException("Can't top on empty Stack");
        }
        return top.elem;
    }

    @Override
    public void pop() {
        if (isEmpty()) {
            throw new EmptyStackException("Can't pop on empty Stack");
        }
        top = top.next;
    }

    @Override
    public String toString() {
        String className = getClass().getName().substring(getClass().getPackage().getName().length() + 1);
        String s = className + "(";
        for (Node<T> node = top; node != null; node = node.next)
            s += node.elem + (node.next != null ? "," : "");
        s += ")";
        return s;
    }
}
