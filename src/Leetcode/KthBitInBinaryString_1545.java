package Leetcode;
 // https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/description/?envType=daily-question&envId=2024-10-19
import java.util.Scanner;

public class KthBitInBinaryString_1545 {
    String finalString = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Value for n.");
        int n = sc.nextInt();
        System.out.println("Enter the Value for k");
        int k = sc.nextInt();
        System.out.println("The kth Bit in Nth String is : " + new KthBitInBinaryString_1545().findKthBit(n,k));
    }
    public char findKthBit(int n, int k) {
        findNthString(n,1,"0");
        System.out.println("The final String is : "+finalString);
        return finalString.charAt(k-1);
    }
    private String reverse(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
    private String inverse(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if (ch == '0')
                sb.append('1');
            else
                sb.append('0');
        }
        return sb.toString();
    }
    private void findNthString(int n, int count, String oldStr){
        String newStr = "";
        if (count == n){
            finalString = oldStr;
            return;
        }else{
            newStr = oldStr + "1" + reverse(inverse(oldStr));
        }
        findNthString(n,count+1,newStr);
    }
}
