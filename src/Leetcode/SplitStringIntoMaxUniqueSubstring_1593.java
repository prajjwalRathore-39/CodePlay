// https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/description/
package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SplitStringIntoMaxUniqueSubstring_1593 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String.");
        String str = sc.next();
        System.out.println("the maximum number of unique substrings that the given string can be split into is : "+new SplitStringIntoMaxUniqueSubstring_1593().maxUniqueSplit(str));
    }
    public int maxUniqueSplit(String s) {
        return backtrack(0,s,new HashSet<>());
    }
    private int backtrack(int start, String s, HashSet<String> seen){
        if (start == s.length()){
            return 0;
        }
        int maxSplits = 0;
        for (int end = start + 1; end<=s.length();end++){
            String substring = s.substring(start,end);
            if (!seen.contains(substring)){
                seen.add(substring);
                maxSplits = Math.max(maxSplits, 1 + backtrack(end,s,seen));
                seen.remove(substring);
            }
        }
        return maxSplits;
    }
}
