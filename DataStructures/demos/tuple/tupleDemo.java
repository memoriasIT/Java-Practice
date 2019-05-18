package demos.tuple;

import static java.lang.System.out;

import dataStructures.tuple.Tuple2;

//    _____             _
//   /__   \_   _ _ __ | | ___
//     / /\/ | | | '_ \| |/ _ \
//    / /  | |_| | |_) | |  __/
//    \/    \__,_| .__/|_|\___|
//               |_| MemoriasIT - 2018

public class tupleDemo {
    public static void main(String[] args) {
        Tuple2<Integer, Double> foo = new Tuple2<Integer, Double>(1, 2.345);

        Double sumcomponents = foo.first() + foo.second();
        out.println(foo);
        out.println("Sum of their components = " + sumcomponents);


        // Change values of tuple
        foo.setFirst(10);
        foo.setSecond(5.0);
        sumcomponents = foo.first() + foo.second();
        out.print("Sum after change: " + sumcomponents);
    }
}
