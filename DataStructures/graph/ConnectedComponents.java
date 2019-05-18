package dataStructures.graph;

import dataStructures.dictionary.Dictionary;
import dataStructures.dictionary.HashDictionary;
import dataStructures.set.HashSet;
import dataStructures.set.Set;

public class ConnectedComponents<V> {
    // Private variables
    private Set<Set<V>> components;
    private Dictionary<V, Integer> inComponent;

    // Constructor
    public ConnectedComponents(Graph<V> g) {
        components = new HashSet<>();
        inComponent = new HashDictionary<>();

        //Insert all vertices in hashSet
        Set<V> unvisited = new HashSet<>();
        for(V v : g.vertices())
            unvisited.insert(v);

        // Visit all vertices
        for(int c = 0; !unvisited.isEmpty(); c++) {
            V src = unvisited.iterator().next();
            inComponent.insert(src, c);

            // Add connected elements by depth first traversal
            Set<V> component = new HashSet<>();
            for(V v : new DepthFirstTraversal<>(g, src).vertices()) {
                component.insert(v);
                inComponent.insert(v, c);
            }

            // Add component
            components.insert(component);

            // Delete vertices added from unvisited
            for(V v : component)
                unvisited.delete(v);
        }
    }

    // Returns components by a set of sets
    public Set<Set<V>> components() {
        return components;
    }

    // Tests if two elements are connected
    public boolean areConnected(V v, V w) {
        return inComponent.valueOf(v).equals(inComponent.valueOf(w));
    }


}
