package dataStructures.graph;

import dataStructures.set.Set;

//      ___                 _
//     / _ \_ __ __ _ _ __ | |__
//    / /_\/ '__/ _` | '_ \| '_ \
//   / /_\\| | | (_| | |_) | | | |
//   \____/|_|  \__,_| .__/|_| |_|
//   MemoriasIT      |_|

public interface Traversable<T> {
    Set<T> successors(T x);

}
