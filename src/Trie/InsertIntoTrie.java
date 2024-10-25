package Trie;

public class InsertIntoTrie {
    static void insert(TrieNode root, String key){
        TrieNode currentNode = root;

        for(int i=0;i<key.length();i++){
            int index = key.charAt(i) - 'a';

            /* Check if the node exists for the current character in the trie */



            // If the node does not exist in the node children then create a new node and point it to the index.
            if (currentNode.childNode[index] == null){

                // Keep the reference for the newly created node.
                currentNode.childNode[index] = new TrieNode();
            }

            // Now move the current Node pointer to the newly created Node.

            currentNode = currentNode.childNode[index];
        }

        // Increment the wordCount for the last currentNode pointer this implies that there is a string ending at currentNode.


        currentNode.wordCount ++;
    }
}
