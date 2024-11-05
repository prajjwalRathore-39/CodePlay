package Leetcode;

import java.util.Scanner;

public class StringCompressionIII_3163 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String.");
        String str = sc.nextLine();
        StringCompressionIII_3163 obj = new StringCompressionIII_3163();
        System.out.println("The Compressed String is : "+obj.compressedString(str));
    }
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int left = 0;
        int right = 0;
        while(right<word.length()){
            while (right<word.length() && word.charAt(right) == word.charAt(left)){
                right++;
            }
            int c = right - left;
            if (c > 9){
                int times = c/9;
                int rem = c%9;
                while (times-->0){
                    comp.append("9"+word.charAt(left));
                }
                if (rem!=0){
                    comp.append(rem+""+word.charAt(left));
                }
            }else{
                comp.append(c+""+word.charAt(left));
            }
            left = right;
        }
        return comp.toString();
    }
}
