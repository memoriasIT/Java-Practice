package dataStructures.tuple;
//    _____             _
//   /__   \_   _ _ __ | | ___
//     / /\/ | | | '_ \| |/ _ \
//    / /  | |_| | |_) | |  __/
//    \/    \__,_| .__/|_|\___|
//               |_| MemoriasIT - 2018


// Generic Tuple implementation
public class Tuple2<A, B> {
    private A elem1;
    private B elem2;

    // Constructor
    public Tuple2(A x, B y) {
        elem1 = x;
        elem2 = y;
    }

    // Getters
    public A first() {
        return elem1;
    }

    public B second() {
        return elem2;
    }

    // Setters
    public void setFirst(A x) {
        elem1 = x;
    }

    public void setSecond(B y) {
        elem2 = y;
    }

    // String Representation
    @Override
    public String toString() {
        String className = getClass().getName().substring(getClass().getPackage().getName().length() + 1);
        return className + "(" + elem1 + "," + elem2 + ")";
    }


}


