package Leetcode;

import java.util.Scanner;

public class MinimumNumberOfChangestoMakeBinaryStringBeautiful_2914 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Binary String.");
        String s = sc.next();
        MinimumNumberOfChangestoMakeBinaryStringBeautiful_2914 obj = new MinimumNumberOfChangestoMakeBinaryStringBeautiful_2914();
        System.out.println("Minimum Number of Changes to Make Binary String beautiful is: "+obj.minChanges(s));
    }
    public int minChanges(String s) {
        int left = 0;
        int right = 0;
        int change = 0;
        for (right=0;right<s.length();right++){
            if (s.charAt(left)!=s.charAt(right)){
                if (right % 2 ==  1){
                    change++;
                }
                left = right;
            }
        }
        return change;
    }
    public int minChangesOptimal(String s) {
            int res = 0;
            for (int i = 1; i < s.length(); i += 2) {
                if (s.charAt(i - 1) != s.charAt(i)) {
                    res++;
                }
            }
            return res;
        }
}
