package dataStructures.set;

import dataStructures.dictionary.AVLDictionary;
import dataStructures.dictionary.Dictionary;
import dataStructures.list.ArrayList;
import dataStructures.list.List;

import java.util.Iterator;

//   __      _
//  / _\ ___| |_
//  \ \ / _ \ __|
//  _\ \  __/ |_
//  \__/\___|\__|
// MemoriasIT - 2018
// Used to solve equivalence relation:
//         https://en.wikipedia.org/wiki/Equivalence_relation

public class DisjointSetDictionary<T extends Comparable<? super T>> implements DisjointSet<T> {

    // Private variables
    private Dictionary<T, T> dic;

    // Constructor
    public DisjointSetDictionary() {
        dic = new AVLDictionary<>();
    }

    // Test for emptiness
    @Override
    public boolean isEmpty() {
        return dic.isEmpty();
    }

    // Test for element
    @Override
    public boolean isElem(T elem) {
        return dic.isDefinedAt(elem);
    }


    // Returns number of elements in set
    @Override
    public int numElements() {
        return dic.size();
    }

    // Adds element to set. If not present create a new eq class, if already present pass
    @Override
    public void add(T elem) {
        // Find if elem is present
        if(isElem(elem)){
            ;
        } else {
            // Create new eq class ( x -> x )
            dic.insert(elem, elem);
        }
    }

    // Returns root of the class. If not found return null
    private T root(T elem) {
        if (!isElem(elem)){
           return null;
        }
        // Found
        return rootRec(elem);
    }

    private T rootRec(T elem){
        T temp = dic.valueOf(elem);

        // Check if it's root
        if (elem == temp){
            return elem;
        }

        // Continue searching root
        return rootRec(temp);
    }

    private T valueOfDictionary(T elem) {
        return dic.valueOf(elem);
    }

    // Test if it's canonical element (root)
    private boolean isRoot(T elem) {
        return elem == dic.valueOf(elem);
    }

    // Test if two elements are in same eq class
    @Override
    public boolean areConnected(T elem1, T elem2) {
        T root1 = root(elem1);
        T root2 = root(elem2);
        // Two elements will be connected if they have the same root
        return root1 == root2 && root1 != null && root2 != null;
    }

    // Returns list with elements in same eq class. If not found return empty list
    @Override
    public List<T> kind(T elem) {
       List<T> temp = new ArrayList<>();

       if (isElem(elem)){
           return kindRec(temp,elem);
       }

       return temp;
    }

    private List<T> kindRec(List<T> temp, T elem) {
        T tempValue = dic.valueOf(elem);

        if(!searchList(tempValue, temp)){        // Not found -> Append and continue
            temp.append(tempValue);
            kindRec(temp, tempValue);
        }
        return temp;
    }

    // Linear search, optimize later lol
    private boolean searchList(T tempValue, List<T> temp){
        boolean result = false;
        Iterator<T> it = temp.iterator();

        while (result == false && it.hasNext()){
            T current = it.next();
            if (current == tempValue){
                result = true;
            }
        }

        return result;
    }

    // Union of both classes
    @Override
    public void union(T elem1, T elem2) {
        // Both elements must be in the set
        if (!isElem(elem1) || !isElem(elem2)){
            throw new IllegalArgumentException();
        }

        // Get higher value
        if (elem1.compareTo(elem2) > 0){
            // Get elements with lower value
            List<T> kind2 = kind(elem2);

            // Set all elements with root elem1
            for (T tmp : kind2){
                dic.insert(tmp, elem1);
            }
        } else { // elem1 is lower
            // Get elements with lower value and join in elem1 class
            List<T> kind1 = kind(elem1);

            // Set all elements with root elem2
            for (T tmp : kind1){
                dic.insert(tmp, elem2);
            }
        }

    }

    // Makes all elements point to their root
    @Override
    public void flatten() {
       for (T tmp : dic.keys()){
           dic.insert(tmp, root(tmp));
       }
    }

    // Returns list of eq classes
    @Override
    public List<List<T>> kinds() {
        // Get eq classes
        // Option 1: Recursively get root of all elements and each different element is a eq class
            //Set<T> roots = new LinkedListSet<>();
            //for (T elem : dic.keys()){
            //    T elemroot = root(elem);
            //    roots.insert(elemroot);
            //}
        // Option 2: Get all elements into a list and delete them as we find they are into a eq class
        // Option 3: Flatten y get list
        flatten();

        List<List<T>> AllKinds = new ArrayList<>();
        for (T elem : dic.keys()){
            if (isRoot(elem)){
                AllKinds.append(kind(elem));
            }
        }

        return AllKinds;
    }

    // String representation
    @Override
    public String toString() {
        return "DisjointSetDictionary(" + dic.toString() + ")";
    }
}
