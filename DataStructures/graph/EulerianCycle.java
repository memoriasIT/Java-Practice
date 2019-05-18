package dataStructures.graph;

import dataStructures.list.*;

public class EulerianCycle<V> {
    private List<V> eCycle;

    // Constructor
    @SuppressWarnings("unchecked")
    public EulerianCycle(Graph<V> g) {
        Graph<V> graph = (Graph<V>) g.clone();
        eCycle = eulerianCycle(graph);
    }

    public boolean isEulerian() {
        return eCycle != null;
    }

    public List<V> eulerianCycle() {
        return eCycle;
    }

    // Check if it is eulerian
    private static <V> boolean isEulerian(Graph<V> g) {
        // Degree of vertices must be even
        for (V tempVert : g.vertices()){
            if (g.degree(tempVert) % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    // Deletes edges from graph and vertices that end up alone
    private static <V> void remove(Graph<V> g, V v, V u) {
        g.deleteEdge(v, u);
        for ( V tempVertix : g.vertices() ){
            if (g.degree(tempVertix) == 0){
                g.deleteVertex(v);
            }
        }

    }

    // Returns a Cycle in a eulerian Graph
    private static <V> List<V> extractCycle(Graph<V> g, V v0) {
        List<V> cycle = new ArrayList<>();


        V current = v0;
        // Add starting vertex to cycle
        cycle.prepend(current);

        // Get first successor
        V next = g.successors(v0).iterator().next();
        remove(g, v0, next);

        while (!next.equals(v0)){
            // Add vertex to cycle and remove it from graph
            cycle.prepend(next);
            remove(g, next, current);

            // Advance a place
            current = next;
            next = g.successors(current).iterator().next();
        }

        // End cycle with starting vertex
        remove(g, current, v0);
        cycle.prepend(v0);

        return cycle;

    }

    // Connect two cycles (I know this code is shit, don't @ me)
    private static <V> void connectCycles(List<V> xs, List<V> ys) {
        // List is empty
        if (xs.isEmpty()){
            xs = ys;
        } else {
            int xsIdx = 0;
            int ysIdx = 0;

            // Compare lists to insert cycle
            if (xs.get(xsIdx).equals(ys.get(ysIdx))){           // First occurence
                // Insert cycle
                for (int k = ysIdx + 1; k < ys.size(); k++){
                    xs.insert(xsIdx, ys.get(k));
                }
            } else {                                            // Not found - linear search
                boolean found = false;
                while (!found && xsIdx < xs.size()){
                    if (xs.get(xsIdx).equals(ys.get(ysIdx))){
                        for(int k = ysIdx + 1; k < ys.size(); k++) {
                            xs.insert(xsIdx, ys.get(k));
                        }
                        found = true;
                    } else {
                        xsIdx++;
                    }
                }

            }
        }


    }

    // Return a vertex in common - must exist at least one
    private static <V> V vertexInCommon(Graph<V> g, List<V> cycle) {
        for (V vertex : g.vertices()){
            for (V edge : cycle) {
                if (edge.equals(vertex)){
                    return vertex;
                }
            }
        }
        return null;
    }

    // Returns an eulerian Cycle
    private static <V> List<V> eulerianCycle(Graph<V> g) {
        if (!isEulerian(g)){
            throw new RuntimeException("Graph is not eulerian");
        }

        List<V>  cycle = new ArrayList<>();
        cycle = extractCycle(g, g.vertices().iterator().next());

        List<V>  aux = new ArrayList<>();
        while (g.numVertices() != 0){
            aux = extractCycle(g, g.vertices().iterator().next());
            connectCycles(cycle, aux);
        }

        return cycle;
    }
}

