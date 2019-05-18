package dataStructures.trees;

import dataStructures.dictionary.AVLDictionary;
import dataStructures.dictionary.Dictionary;

import dataStructures.list.LinkedList;
import dataStructures.list.List;

import dataStructures.priorityQueue.BinaryHeapPriorityQueue;
import dataStructures.PriorityQueue.PriorityQueue;

import dataStructures.tuple.Tuple2;

import dataStructures.trees.WLeafTree;

public class Huffman {

    // Get number of appearances
    public static Dictionary<Character, Integer> weights(String s) {
        Dictionary<Character, Integer> dic = new AVLDictionary<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            // Char already saved, char count++
            if(dic.isDefinedAt(current)){
                dic.insert(current, dic.valueOf(current)+1);
            } else {
                dic.insert(current, 1);
            }
        }

        return dic;
    }

    // Create priority queue for creating tree
    public static PriorityQueue<WLeafTree<Character>> huffmanLeaves(String s) {
        // Create dictionary with weights and queue to return
        Dictionary<Character, Integer> dic = weights(s);
        PriorityQueue<WLeafTree<Character>> Q = new BinaryHeapPriorityQueue<>();

        // Enqueue dictionary entries as leaves
        for (Character temp : dic.keys()){
            WLeafTree<Character> tempLeaf = new WLeafTree<>(temp, dic.valueOf(temp));
            Q.enqueue(tempLeaf);
        }

        return Q;
    }

    // Generate Huffman Tree
    public static WLeafTree<Character> huffmanTree(String s) {
        PriorityQueue<WLeafTree<Character>> leaves = huffmanLeaves(s);

        // Exception if we don't have at least 2 elements
        if (leaves.isEmpty()){
            throw new HuffmanException();
        }

        // Build tree with 2 first elements
        WLeafTree<Character> first = leaves.first();
        leaves.dequeue();

        if (leaves.isEmpty()){
            throw new HuffmanException();
        }
        WLeafTree<Character> second = leaves.first();

        //Huffman
        WLeafTree<Character> tree = new WLeafTree<>(first, second);

        // Continue algorithm until empty
        while (!leaves.isEmpty()){
            tree = new WLeafTree<>(tree, leaves.first());
            leaves.dequeue();
        }

        return tree;
    }

    // Join two dictionaries which are disjointed
    public static Dictionary<Character, List<Integer>> joinDics(Dictionary<Character, List<Integer>> d1, Dictionary<Character, List<Integer>> d2) {
        for (Character tempChar : d1.keys()) {
            d2.insert(tempChar, d1.valueOf(tempChar));
        }

        return d2;
    }

    // Add prefix to dictionary
    public static Dictionary<Character, List<Integer>> prefixWith(int i, Dictionary<Character, List<Integer>> d) {
       for ( Character tempChar : d.keys()){
           d.valueOf(tempChar).prepend(i);
           d.insert(tempChar, d.valueOf(tempChar));
       }

       return d;
    }

    // Return Huffman Code from Tree
    public static Dictionary<Character, List<Integer>> huffmanCode(WLeafTree<Character> ht) {
        Dictionary<Character, List<Integer>> dic = new AVLDictionary<>();
        return codeRec(ht, dic);
    }

    private static Dictionary<Character, List<Integer>> codeRec(WLeafTree<Character> ht, Dictionary<Character,List<Integer>> dic){
        // If is leaf don't continue
        if (ht.isLeaf()){
            return dic;
        }
        // Get left child if possible - prepend 0
        if (ht.leftChild() != null){
            //dic.insert(ht.elem(), prefixWith(0, dic));
        }

        // Get right child if possible - prepend 1

        return null;
    }



    // Encode message using huffman code
    public static List<Integer> encode(String s, Dictionary<Character, List<Integer>> hc) {
        List<Integer> encodedMsg = new LinkedList<>();

        // Get each letter in string
        for ( int i = 0 ; i < s.length(); i++ ){
            List<Integer> codeforChar = hc.valueOf(s.charAt(i));

            // Add number into encoded message
            for ( Integer tempNum : codeforChar){
                encodedMsg.append(tempNum);
            }
        }
        return encodedMsg;
    }

    // Decode message with a huffman tree
    public static String decode(List<Integer> bits, WLeafTree<Character> ht) {
        String decodedMsg = new String();

        return decodeRec(bits, ht, decodedMsg);
    }

    private static String decodeRec(List<Integer> bits, WLeafTree<Character> ht, String decodedMsg){
        while (!bits.isEmpty()){
            // Get first element
            Integer current = bits.get(0);

            // Left child if 0
            if (current == 0){
                bits.remove(0);

                // Left child is leaf
                if (ht.leftChild().isLeaf()){
                    decodedMsg += ht.leftChild().elem();
                } else { // Not leaf continue searching
                    decodeRec(bits, ht, decodedMsg);
                }


            } else { // Right child 1
                bits.remove(0);

                // Right child is leaf
                if (ht.rightChild().isLeaf()) {
                    decodedMsg += ht.leftChild().elem();
                } else {
                    decodeRec(bits, ht, decodedMsg);
                }
            }

        }

        return decodedMsg;
    }



}
