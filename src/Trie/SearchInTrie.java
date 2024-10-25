package Trie;

public class SearchInTrie {
    // Prefix search in a trie data Structure.

    public static boolean isPrefixExist(TrieNode root, String key){
        /* Initialize the currentNode pointer to the root Node. */

        TrieNode currentNode = root;

        // Iterate accross the String

        for(char ch : key.toCharArray()){

            // Check if the node for the current Character exists in the trie.
            if (currentNode.childNode[ch-'a'] == null){

                // if the node doesnot exists then simply return false;

                return false;
            }

            // Move the currentNode pointer to the already existing mode for the current character.

            currentNode = currentNode.childNode[ch-'a'];
        }
        return true;
    }

    // Searching complete word in the trie data structure

    public static boolean search(TrieNode root, String key){

        // Initialize the currentNode with the root Node.
        TrieNode currentNode = root;

        // Iterate over the length of the String

        for (int i=0;i<key.length();i++){
            int index = key.charAt(i) - 'a';

            // if the there is no need that exists for the current character in the trie.

            if (currentNode.childNode[index] == null) {
                return false;

                // Move the currentNode to the already existing node for the character in the trie data structure.
            }

            currentNode = currentNode.childNode[index];

        }

        return (currentNode.wordCount > 0);
    }
}
