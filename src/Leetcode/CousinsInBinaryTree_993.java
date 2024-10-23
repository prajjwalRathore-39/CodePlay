package Leetcode;

import Tree.Tree;
import java.util.*;

import java.util.Scanner;

// https://leetcode.com/problems/cousins-in-binary-tree/description/
public class CousinsInBinaryTree_993 extends Tree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner sc = new Scanner(System.in);
        CousinsInBinaryTree_993 obj = new CousinsInBinaryTree_993();
        tree.populate(sc);
        System.out.println("Enter the Value for first node.");
        int x = sc.nextInt();
        System.out.println("Enter the value for the second node.");
        int y = sc.nextInt();
        System.out.println("The result for the nodes to be siblings is : \n" + obj.isCousins(tree.root,x,y));

    }
    public boolean isCousins(TreeNode root, int x, int y) {
        // Two nodes in the binary tree are cousins if they have same depth but with different parents.
        // We have to check if two nodes are cousins or not.


        // Iterate the tree in a level-order fashion
        // The main two conditions that need to be followed are :-
        // 1 --> SAME LEVEL
        // 2 --> DIFFERENT PARENT

        // Level Order Traversal

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> traversal = new ArrayList<>();

        if(root == null){
            return false;
        }

        queue.offer(root);
        boolean xCovered = false;
        int xParent = -1;
        boolean yCovered = true;
        int yParent = -1;
        int iteration = -1;
        int xLevel = -1;
        int yLevel = -1;
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<levelNum;i++){
                if(queue.peek().left != null){
                    if(queue.peek().left.val == x){
                        xCovered = true;
                        xParent = queue.peek().val;
                        xLevel = traversal.size();
                    }else if(queue.peek().left.val == y){
                        yCovered = true;
                        yParent = queue.peek().val;
                        yLevel = traversal.size();
                    }
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right != null){
                    if(queue.peek().right.val == x){
                        xCovered = true;
                        xParent = queue.peek().val;
                        xLevel = traversal.size();
                    }else if(queue.peek().right.val == y){
                        yCovered = true;
                        yParent = queue.peek().val;
                        yLevel = traversal.size();
                    }
                    queue.add(queue.peek().right);
                }
                list.add(queue.poll().val);
            }
            traversal.add(list);
        }
        // System.out.println("xCovered : " + xCovered);
        // System.out.println("yCovered : " + yCovered);
        // System.out.println("xIteration : "+ xIteration);
        // System.out.println("yIteration : "+ yIteration);
        // System.out.println("xLevel : " + xLevel);
        // System.out.println("yLevel : " + yLevel);
        if (xCovered && yCovered && (xParent != yParent) && (xLevel==yLevel)){
            return true;
        }
        return false;

    }
}
