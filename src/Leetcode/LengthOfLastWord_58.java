package Leetcode;

import java.util.Scanner;

public class LengthOfLastWord_58 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence.");
        String sentence = sc.nextLine();
        LengthOfLastWord_58 obj = new LengthOfLastWord_58();
        System.out.println("The length of last world in the Sentence is : "+obj.lengthOfLastWord(sentence));

    }
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int left = s.length()-1;
        int right = s.length()-1;
        while (left>=0 && s.charAt(left)!=' ')
            left--;

        return right-left;
    }
}
