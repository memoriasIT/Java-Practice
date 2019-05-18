package dataStructures.graph;

import dataStructures.set.HashSet;
import dataStructures.set.LinkedListSet;
import dataStructures.set.Set;

import java.util.Iterator;

public class StronglyConnectedComponents {

    // Returns reverse direction for graph
    public static <V> DiGraph<V> reverseDiGraph(DiGraph<V> g){
        DiGraph<V> temp = new DictionaryDiGraph<>();

        // All vertices in g
        Set<V> vertG = g.vertices();

        // Add all vertex from g to temp
        for (V vertex : vertG){
            // Add vertex if not present (vertices is set so wont have dup)
            temp.addVertex(vertex);

            // Add references to temp but in reverse order
            for (V succ : g.successors(vertex)){
                // Add succ vertex if not present
                temp.addVertex(succ);

                // Add edge between two elements in reverse order
                temp.addDiEdge(succ, vertex);
            }
        }
        return temp;
    }

    public static <V> DiGraph<V> restrictDiGraph(DiGraph<V> g, Set<V> vs){
        DiGraph<V> temp = new DictionaryDiGraph<>();

        // Add al vertex in set
        for (V vertex : g.vertices()){
            // Check vertex in set
            if (vs.isElem(vertex)){
                temp.addVertex(vertex);

                // Add successors of vertex
                for (V succ : g.successors(vertex)){
                     temp.addVertex(succ);
                     temp.addDiEdge(vertex, succ);
                 }
            }
        }

        return temp;
    }

    public static <V> Set<V> sccOf (DiGraph<V> g, V src) {
        // Depth first traversal starting at src
        DepthFirstTraversal<V> dft = new DepthFirstTraversal<>(g, src);

        // Restrict graph with only dft vertices
        Set<V> restriction = new HashSet<>();
        Iterator<V> it = dft.verticesIterator();
        //Extract elements from dft to set
        while (it.hasNext()){
            V tmpV = it.next();
            restriction.insert(tmpV);
        }
        // Restricted graph
        DiGraph<V> restricted = restrictDiGraph(g, restriction);


        // Calculate inverse of restricted graph
        DiGraph<V> inverse = reverseDiGraph(restricted);


        // DFT of inversed restricted graph
        DepthFirstTraversal<V> dftEnd = new DepthFirstTraversal<>(inverse, src);

        // Extract element from dft
        Set<V> result = new HashSet<>();
        for (V vertex : dftEnd.vertices()){
            result.insert(vertex);
        }

        return result;
    }

    // Gets all strongly connected components
    public static <V> Set<Set<V>> stronglyConnectedComponentsDiGraph(DiGraph<V> g) {
        Set<Set<V>> result = new HashSet<>();

        // Algorithm will finish when original graph is empty
        while (g.numVertices() != 0){
            V first = g.vertices().iterator().next();

            //Add
            Set<V> connectedComp = sccOf(g, first);
            result.insert(connectedComp);

            for (V vertex : g.vertices()){
                // Delete if already present
                if (connectedComp.isElem(vertex)){
                    g.deleteVertex(vertex);
                }
            }
        }

        return result;
    }


    public static void main(String[] args){
        DiGraph<Character> test = new DictionaryDiGraph<>();

        // Vertices (A-H)
        test.addVertex('A');
        test.addVertex('B');
        test.addVertex('C');
        test.addVertex('D');
        test.addVertex('E');
        test.addVertex('F');
        test.addVertex('G');
        test.addVertex('H');

        // Edges between vertices
        // A
        test.addDiEdge('A', 'B');
        // B
        test.addDiEdge('B', 'E');
        test.addDiEdge('B', 'F');
        // C
        test.addDiEdge('C', 'D');
        test.addDiEdge('C', 'G');
        // D
        test.addDiEdge('D', 'C');
        test.addDiEdge('D', 'H');
        // E
        test.addDiEdge('E', 'A');
        test.addDiEdge('E', 'F');
        // F
        test.addDiEdge('F', 'G');
        // G
        test.addDiEdge('G', 'F');
        // H
        test.addDiEdge('H', 'G');
        test.addDiEdge('H', 'D');

        // Print Graph
        System.out.println("  ORIGINAL DIGRAPH \n-------------------");
        System.out.println(test + "\n\n");

        // Inverse Graph
        System.out.println("  REVERSED DIGRAPH \n-------------------");
        System.out.println(reverseDiGraph(test) + "\n\n");

        // Restricted Graph
        System.out.println("  RESTRICTED DIGRAPH \n---------------------");
        Set<Character> restriction = new LinkedListSet<>();
        restriction.insert('A');
        restriction.insert('B');
        restriction.insert('E');
        restriction.insert('F');
        restriction.insert('G');
        System.out.println("Restriction: " + restriction);
        System.out.println("Result:      " + restrictDiGraph(test, restriction)+ "\n\n");


        // Strongly Connected Component
        System.out.println("  STRONGLY CONNECTED \n----------------------");
        System.out.println(sccOf(test,'A') + "\n\n");

         // All Strongly Connected Component
        System.out.println("  ALL CONNECTED COMP \n----------------------");
        System.out.println(stronglyConnectedComponentsDiGraph(test) + "\n\n");



    }




}
