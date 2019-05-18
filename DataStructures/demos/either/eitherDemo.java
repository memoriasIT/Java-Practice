package demos.either;

import dataStructures.either.Left;
import dataStructures.either.Right;

import static java.lang.System.out;

public class eitherDemo {
    public static void main(String[] args) {
        Right<Integer, Integer> derecha = new Right<>(1);
        Left<Integer, Integer> izquierda = new Left<>(2);

        out.println("---{ Right }---");
        out.println("Is it left? " + derecha.isLeft());
        out.println("Is it right? " + derecha.isRight());
        out.println(derecha);


        out.println("\n---{ Left }---");
        out.println("Is it left? " + izquierda.isLeft());
        out.println("is it right?" + izquierda.isRight());
        out.println(izquierda);
    }
}
