package dataStructures.stack;

//    __ _             _
//   / _\ |_ __ _  ___| | __
//   \ \| __/ _` |/ __| |/ /
//   _\ \ || (_| | (__|   <
//   \__/\__\__,_|\___|_|\_\
//   MemoriasIT - 2018

public interface Stack<T> {
    // Return true if empty, else false
    boolean isEmpty();

    // Inserts new item on top of stack
    void push(T x);

    // Returns element on top of stack (doesn't remove)
    // @throws EmptyStackException
    T top();

    // Removes element on top of stack
    // @throws EmptyStackException
    void pop();
}
