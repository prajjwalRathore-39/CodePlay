//package Leetcode;
//
//import java.util.Scanner;
//
//public class StringToInteger_8 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the String.");
//        String str = sc.nextLine();
//        StringToInteger_8 obj = new StringToInteger_8();
//        System.out.println("The Integer Value for the Corresponding String is: "+obj.myAtoi(str));
//    }
//    public int myAtoi(String s) {
//
//        s = s.trim();
//
//        int result = 0;
//        if (!Character.isDigit(s.charAt(0))){
//            if (s.charAt(0) == '+' || s.charAt(0)=='-'){
//                continue;
//            }else{
//                return 0;
//            }
//        }
//        boolean positive = true;
//        if (s.charAt(0) == '-'){
//            positive = false;
//        }
//        for (int i=0;i<s.toCharArray().length;i++){
//            if ((s.charAt(i)=='-' || s.charAt(i)=='+')&& i==0 ){
//                continue;
//            }
//            if (Character.isDigit(s.charAt(i))){
//                result = (result*10)+(s.charAt(i)-'0');
//            }else{
//                break;
//            }
//        }
//
//        if (!positive){
//            result*=-1;
//        }
//        return result;
//    }
//}
