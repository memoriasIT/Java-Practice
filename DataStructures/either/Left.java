package dataStructures.either;

import java.util.NoSuchElementException;

//      __ _ _   _
//     /__(_) |_| |__   ___ _ __
//    /_\ | | __| '_ \ / _ \ '__|
//   //__ | | |_| | | |  __/ |
//   \__/ |_|\__|_| |_|\___|_|
// Memorias de informático - 2018


public class Left<A, B> implements Either<A, B> {
    // Internal variable
    private A left;

    // Constructor
    public Left(A x) {
        left = x;
    }

    // Retrieve if it's a left object
    public boolean isLeft() {
        return true;
    }

    // Check if it's a right object
    public boolean isRight() {
        return false;
    }

    // Retrieve left object
    public A left() {
        return left;
    }

    // Retrieve right object (doesn't exist -> exception)
    public B right() {
        throw new NoSuchElementException("Right on left object");
    }

    // String representation
    public String toString() {
        String className = getClass().getName().substring(getClass().getPackage().getName().length() + 1);
        return className + "(" + left + ")";
    }
}
