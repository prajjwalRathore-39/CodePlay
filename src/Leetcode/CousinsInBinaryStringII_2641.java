package Leetcode;

import Tree.Tree;

import java.util.Scanner;

public class CousinsInBinaryStringII_2641 extends Tree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking input for the Binary Tree

        // Calling the function from the Tree class

        Tree tree = new Tree();
        tree.populate(sc);
        new CousinsInBinaryStringII_2641().replaceValueInTree(tree.root);
    }
    public TreeNode replaceValueInTree(TreeNode root) {

        // This Question follows a Simple Approach to replace the value of the Node with the sum of the Siblings
        // in the tree.

        /*The main intution behind the solution is that we should take sum of all of the nodes which are at the same level
        * and while replacing the value for the nodes what we can do is that we can remove the sum of the sublings from the total
        * sum of the level. */

        // APPROACH :-
        // Step-1 : Add a new node to the root, equal to 0, as the root will not be having any siblings or the parent tree.
        // Step-2 : Add this root to an array {This array will keep track of all the parent nodes of the tree.}
        // Step-3 : Iterate over the parent nodes from the array and find the sum of all the childrens of the node.


        // Step-1 :
        DepthFirstSearch(new TreeNode[] {root});
        root.val = 0;
        return root;

    }
    public void DepthFirstSearch(TreeNode[] arr){
        // End DFS if the input array is empty
        if (arr.length == 0){
            return;
        }

        int sum = 0;   // this variable will store the sum of the children of a particular parent node.

        for(TreeNode node : arr){        // Iterating over the parent nodes from the array.
            if (node == null) continue;
            if (node.left != null) sum+=node.left.val;
            if (node.right != null) sum+=node.right.val;
        }

        TreeNode[] childArray = new TreeNode[arr.length*2];
        int index = 0;
        for (TreeNode node : arr){
            int currentSum = 0;
            if (node.left != null) currentSum+=node.left.val;
            if (node.right != null) currentSum += node.right.val;

            if (node.left != null){
                node.left.val = sum - currentSum;
                childArray[index++] = node.left;
            }

            if (node.right != null){
                node.right.val = sum - currentSum;
                childArray[index++] = node.right;
            }
        }
        DepthFirstSearch(java.util.Arrays.copyOf(childArray,index));
    }
}
