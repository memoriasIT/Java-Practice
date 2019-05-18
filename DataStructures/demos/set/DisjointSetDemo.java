package demos.set;

import dataStructures.set.DisjointSet;
import dataStructures.set.DisjointSetDictionary;

public class DisjointSetDemo {
    public static void main(String[] args) {
        DisjointSet<String> dj = new DisjointSetDictionary<>();
        String[] pals = { "hola", "a", "todos", "como", "estais", "por", "aqui", "bien" };
        for (String s : pals) {
            dj.add(s);
        }

        // Print set with items added
        System.out.println(dj);

        System.out.println("Are hola and por connected?: " + dj.areConnected("hola", "por"));
        //System.out.println(((DisjointSetDictionary<String>) dj).root("hola"));
        //System.out.println(dj.isElem("hola"));
        //System.out.println(dj.isElem("hola2"));



        // Number of elements in set
        System.out.println("Number of elements: " +dj.numElements() + "\n");

        // Join "hola" and "a"
        dj.union("hola", "a");
        System.out.println("Join hola + a: \t\t\t" + dj);

        // Join "como" and "estais"
        dj.union("como", "estais");
        System.out.println("Join como and estais: \t" + dj);

        // Join "por" and "aquí"
        dj.union("por", "aqui");
        System.out.println("Join por and aqui:  \t" +dj);

        // Join "hola" and "bien"
        dj.union("hola", "bien");
        System.out.println("Join hola and bien: \t"+dj);

        // Join "estais" and "por"
        dj.union("estais", "por");
        System.out.println("Join estais and por: \t" +dj +"\n");

        // Return kind of "bien"
        System.out.println("Kind of bien: \t" + dj.kind("bien"));
        System.out.println("Are hola and por connected?: " + dj.areConnected("hola", "por"));
        System.out.println("Hola and adios connected: " + dj.areConnected("hola", "adios"));
        System.out.println("No and esta connected: " +dj.areConnected("no", "esta"));


        // Is root and value in dictionary
        //System.out.println(((DisjointSetDictionary<String>) dj).valueOfDictionary("hola"));
        //System.out.println(((DisjointSetDictionary<String>) dj).isRoot("hola"));


        dj.flatten();
        System.out.println("Set flattened: \n\t" + dj);
        System.out.println(dj.kinds());



    }
}

