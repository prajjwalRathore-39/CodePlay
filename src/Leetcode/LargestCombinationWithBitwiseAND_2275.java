package Leetcode;

import java.util.Scanner;
// https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/submissions/1446032876/?envType=daily-question&envId=2024-11-07
public class LargestCombinationWithBitwiseAND_2275 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array.");
        int[] arr = new int[sc.nextInt()];
        System.out.println("Enter the Array Elements");
        for (int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }

        LargestCombinationWithBitwiseAND_2275 obj = new LargestCombinationWithBitwiseAND_2275();
        System.out.println("The Length of the largest Combination is: "+obj.largestCombination(arr));
    }
    public int largestCombination(int[] candidates) {
        // we have to find
        int[] bitCount = new int[24];
        for(int i=0;i< bitCount.length;i++){
            for(int x : candidates){
                if ((x & (1<<i))!=0){
                    bitCount[i]++;
                }
            }
        }

        int max = 0;
        for (int x : bitCount){
            if (x>max){
                max=x;
            }
        }

        return max;
    }
}
