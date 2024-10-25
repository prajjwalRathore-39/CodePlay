package Trie;

public class DeletionInTrie {
    /*There are three cases when deleting a word from Trie.

        1. The deleted word is a prefix of other words in Trie.
        2. The deleted word shares a common prefix with other words in Trie.
        3.  The deleted word does not share any common prefix with other words in Trie.
*/


    public static boolean deleteKey(TrieNode root, String word) {
        TrieNode currentNode = root;
        TrieNode lastBranchNode = null;
        char lastBranchChar = 'a';

        for (char c : word.toCharArray()) {
            if (currentNode.childNode[c - 'a'] == null) {
                // If the current node has no child, the word is not present
                return false;
            } else {
                int count = 0;
                // Count the number of non-null child nodes
                for (int i = 0; i < 26; i++) {
                    if (currentNode.childNode[i] != null)
                        count++;
                }

                if (count > 1) {
                    // If there are more than one child, store the last branch information
                    lastBranchNode = currentNode;
                    lastBranchChar = c;
                }
                currentNode = currentNode.childNode[c - 'a'];
            }
        }

        int count = 0;
        // Count the number of non-null child nodes at the last character
        for (int i = 0; i < 26; i++) {
            if (currentNode.childNode[i] != null)
                count++;
        }

        // Case 1: The deleted word is a prefix of other words in Trie.
        if (count > 0) {
            // Decrement the word count and indicate successful deletion
            currentNode.wordCount--;
            return true;
        }

        // Case 2: The deleted word shares a common prefix with other words in Trie.
        if (lastBranchNode != null) {
            // Remove the link to the deleted word
            lastBranchNode.childNode[lastBranchChar - 'a'] = null;
            return true;
        }
        // Case 3: The deleted word does not share any common prefix with other words in Trie.
        else {
            // Remove the link to the deleted word from the root
            root.childNode[word.charAt(0) - 'a'] = null;
            return true;
        }
    }
}
