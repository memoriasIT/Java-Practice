package dataStructures.graph;

public interface Store<T> {
    boolean isEmpty();
    void insert(T elem);
    T extract();

}
