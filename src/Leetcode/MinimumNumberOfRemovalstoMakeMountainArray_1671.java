package Leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumNumberOfRemovalstoMakeMountainArray_1671 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the Array.");
        int len = sc.nextInt();
        int[] arr = new int[len];
        System.out.println("Enter the Array Elements.");
        for (int i=0;i<len;i++){
            arr[i] = sc.nextInt();
        }
        MinimumNumberOfRemovalstoMakeMountainArray_1671 obj = new MinimumNumberOfRemovalstoMakeMountainArray_1671();
        System.out.println("Minimum number of removals needed to make mountain array : "+obj.minimumMountainRemovals(arr));

    }
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n], LDS = new int[n];
        Arrays.fill(LIS, 1);
        Arrays.fill(LDS, 1);

        // Compute LIS for each index
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }

        // Compute LDS from each index
        for (int i = n - 1; i >= 0; --i) {
            for (int j = n - 1; j > i; --j) {
                if (nums[i] > nums[j]) {
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
        }

        System.out.println("LIS is : "+Arrays.toString(LIS));
        System.out.println("LDS is : "+Arrays.toString(LDS));

        int maxMountainLength = 0;

        // Find the maximum mountain length
        for (int i = 1; i < n - 1; ++i) {
            if (LIS[i] > 1 && LDS[i] > 1) {  // Valid peak
                maxMountainLength = Math.max(maxMountainLength, LIS[i] + LDS[i] - 1);
            }
        }

        return n - maxMountainLength;
    }
}
