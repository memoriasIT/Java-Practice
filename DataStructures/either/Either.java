package dataStructures.either;

//      __ _ _   _
//     /__(_) |_| |__   ___ _ __
//    /_\ | | __| '_ \ / _ \ '__|
//   //__ | | |_| | | |  __/ |
//   \__/ |_|\__|_| |_|\___|_|
// Memorias de informático - 2018

public interface Either<A, B> {

    // Test if it is the left value
    boolean isLeft();

    // Test if it is the right value
    boolean isRight();

    // Retrieve left value
    A left();

    // Retrieve right value
    B right();
}
