package dataStructures.graph;
import dataStructures.set.Set;
//      ___                 _
//     / _ \_ __ __ _ _ __ | |__
//    / /_\/ '__/ _` | '_ \| '_ \
//   / /_\\| | | (_| | |_) | | | |
//   \____/|_|  \__,_| .__/|_| |_|
//   MemoriasIT      |_|

public interface Graph<V> extends Traversable<V>, Cloneable {
    // Adds given vertex to graph
    void addVertex(V v);

    // Delete given vertex
    void deleteVertex(V v);

    // Adds edge
    void addEdge(V v, V w);

    // Deletes edge
    void deleteEdge(V v, V w);

    // Returns number of vertices
    int numVertices();

    // Returns number of edges
    int numEdges();

    // Returns vertices as a set
    Set<V> vertices();

    // Returns the degree of a given vertix
    int degree(V v);

    // Returns clone of graph
    Object clone();

}
