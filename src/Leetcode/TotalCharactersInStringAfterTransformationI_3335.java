package Leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TotalCharactersInStringAfterTransformationI_3335 {
    public static void main(String[] args) {
        System.out.println("Enter the initial String.");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Enter the Number of Times the transformations are to be made.");
        int times = sc.nextInt();
        TotalCharactersInStringAfterTransformationI_3335 obj = new TotalCharactersInStringAfterTransformationI_3335();
        System.out.println("Length after transformations is : "+obj.lengthAfterTransformations(str,times));
    }
    public int lengthAfterTransformations(String s, int t) {
        // Frequency array to store character counts
        final int MOD = 1_000_000_007;
        int[] freq = new int[26];

        // Count initial frequency of each character in the string
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        // Now the need is to change the frequency
        int[] copyArray = new int[26];

        while (t-->0){
            for (int i=0;i<26;i++){
                if (i == 25) {  // 'z' transforms to 'a' and 'b'
                    copyArray[0] = (copyArray[0] + freq[25]) % MOD;
                    copyArray[1] = (copyArray[1] + freq[25]) % MOD;
                } else {  // Other characters move to the next character
                    copyArray[i + 1] = (copyArray[i + 1] + freq[i]) % MOD;
                }
            }
            for (int i = 0;i<26;i++){
                freq[i] = copyArray[i];
            }
            Arrays.fill(copyArray,0);
        }

        // Calculate the total length after all transformations
        int length = 0;
        for (int count : freq) {
            length = (length+count)%MOD;
        }
        System.out.println(Arrays.toString(freq));
        return length;
    }
}
