package Trie;

public class TrieNode {
    public TrieNode[] childNode;
    public int wordCount;

    public TrieNode(){
        childNode = new TrieNode[26];
        /*This will keep the track of number of strings that are stored
        * in the Trie from root node to any Trie node.*/

        wordCount = 0;
    }
}
