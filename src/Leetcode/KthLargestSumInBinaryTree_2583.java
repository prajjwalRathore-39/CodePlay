// https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/description/?envType=daily-question&envId=2024-10-22

package Leetcode;

import Tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.Collections;
import java.util.Scanner;
import java.util.*;

public class KthLargestSumInBinaryTree_2583 extends Tree{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tree obj = new Tree();
        KthLargestSumInBinaryTree_2583 obj2 = new KthLargestSumInBinaryTree_2583();
        obj.populate(sc);
        System.out.println("Enter the value for variable k");
        int k = sc.nextInt();
        System.out.println("The kth largest level sum for the tree is as presented : " + obj2.kthLargestLevelSum(obj.root,k));
    }
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> res = new ArrayList<>();  // To store sum of each level
        Queue<TreeNode> q = new LinkedList<>();  // Queue for level-order traversal
        q.add(root);  // Start BFS from the root node

        while (!q.isEmpty()) {
            int n = q.size();  // Number of nodes at the current level
            long sum = 0;  // Sum of node values at the current level

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                sum += node.val;

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(sum);  // Store the sum of the current level
        }

        if (k > res.size()) return -1;

        res.sort(Collections.reverseOrder());  // Sort level sums in descending order

        return res.get(k - 1);  // Return the k-th largest sum
    }
}
