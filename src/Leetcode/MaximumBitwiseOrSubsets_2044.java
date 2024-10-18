package Leetcode;

import java.util.Scanner;

// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/?envType=daily-question&envId=2024-10-18
public class MaximumBitwiseOrSubsets_2044 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MaximumBitwiseOrSubsets_2044 obj = new MaximumBitwiseOrSubsets_2044();
        System.out.println("Enter the Length of the Array.");
        int len = sc.nextInt();
        System.out.println("Enter the Array Elements.");
        int[] nums = new int[len];
        for(int i=0;i<nums.length;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("The maximum possible bitwise OR of a subset is " + obj.countMaxOrSubsets(nums)  );

    }
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        // Compute the Maximum OR

        for(int num : nums)
            maxOR |= num;

        int[] count = new int[1];
        backtrack(nums,0,0,maxOR,count);

        return count[0];
    }

    public void backtrack(int[] nums, int index, int currentOR, int maxOR, int[] count){
        if(currentOR == maxOR){
            count[0]++;
        }

        for (int i=index;i<nums.length;i++){
            backtrack(nums,i+1,currentOR|nums[i],maxOR,count);
        }
    }
}
