package SlidingWindows;

import java.util.HashMap;
import java.util.Scanner;

public class ContainsDuplicate_219 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array.");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the Array Elements.");
        for (int i=0;i<nums.length;i++)
            nums[i] = sc.nextInt();
        System.out.println("Enter the value for k");
        int k = sc.nextInt();


        ContainsDuplicate_219 obj = new ContainsDuplicate_219();
        System.out.println("The result for the evaluation is : "+obj.containsNearbyDuplicate(nums,k));

    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                int idx = map.get(nums[i]);
                if (Math.abs(i - idx) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }
}
