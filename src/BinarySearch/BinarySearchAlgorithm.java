package BinarySearch;

import java.util.Scanner;

public class BinarySearchAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Array.");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter Array ELements.");
        for (int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        System.out.println("Enter the Element to be searched in the Array.");
        int ele = sc.nextInt();
        int pos = binarysearch(arr,ele);
        if (pos == -1){
            System.out.println("Element is not present in the Array.");
        }else{
            System.out.println("Element is at the position "+pos);
        }
    }
    public static int binarysearch(int[] arr, int ele){
        int pos = -1;
        int left = 0;
        int right = arr.length;
        while(left<=right){
            int mid = left+(right-left)/2;
            if (arr[mid] == ele) {
                pos =  mid;
                break;
            }
            else if(arr[mid] > ele){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return pos;
    }
}
