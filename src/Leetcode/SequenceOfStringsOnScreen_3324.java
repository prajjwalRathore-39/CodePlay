package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://leetcode.com/problems/find-the-sequence-of-strings-appeared-on-the-screen/description/
public class SequenceOfStringsOnScreen_3324 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SequenceOfStringsOnScreen_3324 obj = new SequenceOfStringsOnScreen_3324();
        System.out.println("Enter the target String.");
        String target = sc.next();
        System.out.println("List of all strings that appear on the screen as Alice types target, in the order they appear, using the minimum key presses are" +
                " :\n"+obj.stringSequence(target));
    }
    public List<String> stringSequence(String target) {
        List<String> result = new ArrayList<String>();
        String str = "a";
        result.add(str);
        for(int i=0;i<target.length();i++){
            char ch = target.charAt(i);
            char ch2 = str.charAt(i);
            int diff = (int)ch - (int)ch2;
            while(diff-->0){
                str = pressKey2(str);
                result.add(str);
            }
            if(target.length()>str.length()){
                str = pressKey1(str);
                result.add(str);
            }
        }
        return result;
    }
    private String pressKey1(String str){
        return str+"a";
    }
    private String pressKey2(String str){
        char last_character = str.charAt(str.length()-1);
        if (last_character == 'z'){
            str = str.substring(0,str.length()-1) + 'a';
        }else{
            last_character++;
            str = str.substring(0,str.length()-1) + last_character;
        }
        return str;
    }
}
