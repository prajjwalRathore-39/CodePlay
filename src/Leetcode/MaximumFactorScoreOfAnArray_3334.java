package Leetcode;

import java.util.ArrayList;
import java.util.Scanner;

public class MaximumFactorScoreOfAnArray_3334 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array.");
        int len = sc.nextInt();
        int arr[] = new int[len];
        System.out.println("Enter the Array Elements.");
        for (int i=0;i<len;i++)
            arr[i] = sc.nextInt();

        MaximumFactorScoreOfAnArray_3334 obj = new MaximumFactorScoreOfAnArray_3334();
        long result = obj.maxScore(arr);
        System.out.println("The maximum factor score of the Array is:\n"+result);
    }

    public long maxScore(int[] nums) {
        // we can remove each element from the array once
        // and calculate the maximum element..

        long result = 0;


        for (int i=0;i<=nums.length;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for (int j=0;j< nums.length;j++){
                if (i!=j){
                    list.add(nums[j]);
                }
            }

            if (list.isEmpty()) continue;

            long gcd = list.getFirst();
            long lcm = list.getFirst();

            for (int j=1;j< list.size();j++){
                gcd = gcd(gcd,list.get(j));
                lcm = lcm(lcm,list.get(j));
            }

            result = Math.max(result,(gcd*lcm));
        }

        return result;
    }

    public long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
