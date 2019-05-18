package dataStructures.graph;

/*
--{ DFS Stack }--

1) Place 1 vertex with color in Stack
2) While Stack is not empty
    2.1) Extract 1 element from stack
    2.2) ¿Does element have a color assigned?
        NO  : Not visited, so visit it by adding it to dictionary. Push succs to Stack with opposite color if not visited.
        YES : Already Visited, check if it's the same color
            SAME COLOR : Continue algorithm without pushing to Stack
            DIFFERENT  : Stop algorithm - Return Null
3) If stack is empty return dictionary



dictionary
----------
        keys(vertices)  values(colors)
            1               R


Stack
-----

 (1, R)         ->  We have to visit vertex 1 and give color Red
_________
  STACK
*/

import dataStructures.dictionary.Dictionary;
import dataStructures.dictionary.HashDictionary;

import dataStructures.set.Set;
import dataStructures.stack.Stack;
import dataStructures.stack.LinkedStack;



public class BipartiteGraph {

    // Tuple structure for "toVisit" stack
    static class Pair<V> {
        V vertex;
        Boolean color;

        Pair(V v, Boolean c) {
            vertex = v;
            color  = c;
        }
    }


    static <V> Dictionary<V, Boolean> colorGraph(Graph<V> g){
        boolean ok = true;

        // Initialize stack and dictionary for algorithm
        Stack<Pair<V>> toVisit = new LinkedStack<>();
        Dictionary<V, Boolean> Visited = new HashDictionary<>();

        Set<V> vertices = g.vertices();

        // Start vertex
        if (!vertices.isEmpty()){

            // Place first element in stack
            V first = vertices.iterator().next();
            toVisit.push(new Pair<>(first, true));

            while (ok && !toVisit.isEmpty()){
                // Get and remove first element
                Pair<V> current = toVisit.top();
                toVisit.pop();

                // Check for element in dictionary
                Boolean color = Visited.valueOf(current.vertex);

                if (color != null){
                    // Unvisited - Add to dictionary
                    Visited.insert(current.vertex, current.color);

                    // Push all succesors to stack
                    for (V vertex: g.successors(current.vertex)) {
                        // Check if visited
                        if (!Visited.isDefinedAt(vertex)){
                            toVisit.push(new Pair<>(vertex, !current.color));
                        }
                    }


                } else {
                    // Visited - Check if it's the same color
                    if (color.equals(current.color)){
                        ; // Continue
                    } else {
                        ok = false; // Contradiction found
                    }
                }

            }

        } else {
            return Visited; // Graph was empty
        }

        return ok ? Visited : null;
    }


    static Graph<Integer> completeBipartite(int n, int m){
        Graph<Integer> g = new DictionaryGraph<>();

        // Generate vertices
        for (int v = 0; v < n+m; v++){
            g.addVertex(v);
        }

        // Generate edges for those vertices
        for (int v = 0; v < n; v++){
            for (int w = 0; w < m; w++){
                g.addEdge(v, n+w);
            }
        }

        return g;
    }

    public static void main(String[] args){
        Graph<Integer> g1 = new DictionaryGraph<>();
        g1.addVertex(0);
        g1.addVertex(1);
        g1.addVertex(2);
        g1.addVertex(3);
        g1.addVertex(4);

        g1.addEdge(0, 3);
        g1.addEdge(0, 4);
        g1.addEdge(1, 3);
        g1.addEdge(1, 4);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);

        System.out.println(colorGraph(g1));

        Graph<Integer> g2 = (Graph<Integer>) g1.clone();
        g2.addEdge(3,4);
        System.out.println(colorGraph(g2));

        // Generate a complete bipartite graph
        Graph<Integer> g3 = completeBipartite(30, 55);
        System.out.println(colorGraph(g3));

    }


}
