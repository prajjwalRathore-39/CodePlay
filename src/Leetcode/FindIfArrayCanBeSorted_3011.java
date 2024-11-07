package Leetcode;

import java.util.Scanner;

public class FindIfArrayCanBeSorted_3011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        System.out.println("Enter the Array Elements.");
        for (int i=0;i<len;i++)
            nums[i] = sc.nextInt();
        FindIfArrayCanBeSorted_3011 obj = new FindIfArrayCanBeSorted_3011();
        System.out.println("Result: "+obj.canSortArray(nums));
    }
    public boolean canSortArray(int[] nums) {
        int[] arr = nums;
        boolean result = isSorted(arr);
        if(result){
            return true;
        }
        // Now we have to check whether, the same setbits element are together

        // We have to check for the groups, if they are occuring together

        int left = 0;
        int right = 1;

        int t = nums.length;

        while(t-->0){
            for(int i=0;i<nums.length-1;i++){
                if(countSetBits(nums[i]) == countSetBits(nums[i+1])){
                    if(nums[i]>nums[i+1]){
                        swap(nums,i,i+1);
                    }
                }
            }
        }
        return isSorted(nums);
    }
    private int countSetBits(int num){
        String binary = Integer.toBinaryString(num);
        int count = 0;
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }
    private boolean isSorted(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                return false;
            }
        }
        return true;
    }
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
