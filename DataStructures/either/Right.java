package dataStructures.either;

import java.util.NoSuchElementException;

//      __ _ _   _
//     /__(_) |_| |__   ___ _ __
//    /_\ | | __| '_ \ / _ \ '__|
//   //__ | | |_| | | |  __/ |
//   \__/ |_|\__|_| |_|\___|_|
// Memorias de informático - 2018

public class Right<A, B> implements Either<A, B> {
    // Private variables
    private B right;

    public Right(B x) {
        right = x;
    }

    // Check if it's a let object
    @Override
    public boolean isLeft() {
        return false;
    }

    // Check if it's a right object
    @Override
    public boolean isRight() {
        return true;
    }

    // Retrieve left element (doesn't exist -> exception)
    @Override
    public A left() {
        throw new NoSuchElementException("Not a left object");
    }

    // Retrieve right element
    @Override
    public B right() {
        return right;
    }

    public String toString() {
        String className = getClass().getName().substring(getClass().getPackage().getName().length() + 1);
        return className + "(" + right + ")";
    }
}
