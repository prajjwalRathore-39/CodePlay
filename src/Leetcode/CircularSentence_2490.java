package Leetcode;

import java.util.Scanner;

public class CircularSentence_2490 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Sentence.");
        String sentence = sc.nextLine();
        CircularSentence_2490 obj = new CircularSentence_2490();
        if (obj.isCircularSentence(sentence,sentence.length())){
            System.out.println("The sentence is a circular sentence. "+ obj.isCircularSentence(sentence,sentence.length()));
        }else{
            System.out.println("The sentence is not a circular sentence. " + obj.isCircularSentence(sentence,sentence.length()));
        }
    }
    public boolean isCircularSentence(String sentence) {
        // In this we have to check whether the given sentence is a circular sentence or not.
        sentence = sentence.trim();
        if (sentence.charAt(0)!=sentence.charAt(sentence.length()-1)){
            return false;
        }
        String[] words = sentence.split(" ");
        for (int i=0;i<words.length-1;i++){
            if (words[i].charAt(words[i].length()-1) != words[i+1].charAt(0)){
                return false;
            }
        }
        return true;
    }

    // Trying Space-Optimized Search

    public boolean isCircularSentence(String sentence, int n){

        // What I need to do is, that i have to check for the string without storing it into a sepearate array
        // inorder to save the space consumption

        if (sentence.charAt(0)!=sentence.charAt(sentence.length()-1)) return false;

        for (int right = 1; right<sentence.length()-1;right++){
            if (sentence.charAt(right) == ' '){
                if (sentence.charAt(right-1)!=sentence.charAt(right+1)) return false;
            }
        }

        return true;
    }

}
