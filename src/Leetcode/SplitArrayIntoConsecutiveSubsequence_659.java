package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitArrayIntoConsecutiveSubsequence_659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the Array.");
        int[] nums = new int[sc.nextInt()];
        System.out.println("Enter the Array Elements");
        for (int i=0;i<nums.length;i++){
            nums[i] = sc.nextInt();
        }

        boolean result = new SplitArrayIntoConsecutiveSubsequence_659().isPossible(nums);
        if (result)
            System.out.println("The Array can be broken down into subsequences : "+result);
        else
            System.out.println("The Array cannot be broken down into subseuences : "+result);
    }
    public boolean isPossible(int[] nums) {
        // We have to check whether can we split the array into one or more subsequence such that they follow the below conditions :
        // 1 : Each Subsequence is a consecutive increasing sequence ( Each Integer is exactly one more than the previous Integer )
        // 2 : All sequences have a length of 3 or more.
        List<List<Integer>> listContainer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - list.get(list.size() - 1) == 1) {
                    list.add(nums[i]);
                    nums[i] = -1;
                }
            }
            listContainer.add(list);

        System.out.println("List Container 1 : "+listContainer);
        System.out.println("List is "+list);
        list.removeAll(list);
            while (true){
                for (int i = 0;i<nums.length;i++){
                    if (nums[i] != -1)
                        list.add(nums[i]);
                }
                if (list.size()==0){break;}
                for (int i = 1; i < nums.length; i++) {
                    if (nums[i] - list.get(list.size() - 1) == 1) {
                        list.add(nums[i]);
                        nums[i] = -1;
                    }
                }
                listContainer.add(list);
                list.removeAll(list);
            }
            System.out.println("Collections List : "+listContainer);
            for (List<Integer> listt : listContainer){
                if (listt.size()<3) return false;
            }
            StringBuilder sb = new StringBuilder();
            return true;
    }
}
