package dataStructures.searchTree;

import dataStructures.tuple.Tuple2;

import java.util.function.UnaryOperator;

//    __                     _    _____
//   / _\ ___  __ _ _ __ ___| |__/__   \_ __ ___  ___
//   \ \ / _ \/ _` | '__/ __| '_ \ / /\/ '__/ _ \/ _ \
//   _\ \  __/ (_| | | | (__| | | / /  | | |  __/  __/
//   \__/\___|\__,_|_|  \___|_| |_\/   |_|  \___|\___|
//                                  MemoriasIT - 2018


public interface SearchTree<K extends Comparable<? super K>, V> {

    // True if empty, else false
    boolean isEmpty();

    // Return number of key/value associations in the tree
    int size();

    // Returns height of the tree
    int height();

    // Insert a new key/value association in tree, if key already
    // present, old value is replaced
    void insert(K k, V v);

    // Retrieves value associated to key
    V search(K k);

    // Returns if key association was found
    boolean isElem(K k);

    // Delete element by key
    void delete(K k);

    // Return value with minimum key
    V minim();

    // Return value with maximum key
    V maxim();

    // Remove node with minimum key
    void deleteMinim();

    // Remove node with maximum key
    void deleteMaxim();

    // inOrder Traversal: Left, Root, Right
    Iterable<K> inOrder();

    // postOrder Traversal: Left, Right, Root
    Iterable<K> postOrder();

    // preOrder: Root, Left, Right
    Iterable<K> preOrder();

    // inOrder Values
    Iterable<V> values();

    // inOrder key/values Associations
    Iterable<Tuple2<K, V>> keysValues();

    // Insert new key/Value association with function, if already present update
    void updateOrInsert(UnaryOperator<V> f, K k, V v);

}
