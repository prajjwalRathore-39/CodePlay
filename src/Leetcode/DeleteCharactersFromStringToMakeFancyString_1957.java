package Leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class DeleteCharactersFromStringToMakeFancyString_1957 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String.");
        String str = sc.nextLine();
        DeleteCharactersFromStringToMakeFancyString_1957 obj = new DeleteCharactersFromStringToMakeFancyString_1957();
        System.out.println("The final String after deleting the character is : "+obj.makeFancyString(str));
    }
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        sb.append(s.charAt(0));
        for (int i = 1;i<s.length();i++){
            if (s.charAt(i)==sb.toString().charAt(sb.toString().length()-1)){
                count++;
                if (count<3){
                    sb.append(s.charAt(i));
                }
            }else{
                count = 1;
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
