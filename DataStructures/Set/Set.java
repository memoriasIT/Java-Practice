package Set;

public interface Set<T> extends Iterable<T> {
    boolean isEmpty();
    int     size();
    void    insert(T x);
    boolean isElem(T x);
    void    delete(T x);
}
