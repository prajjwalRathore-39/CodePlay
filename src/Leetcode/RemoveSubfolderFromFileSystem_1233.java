package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RemoveSubfolderFromFileSystem_1233 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the folder array.");
        int n = sc.nextInt();
        String[] folder = new String[n];
        System.out.println("Enter the Directories in the Array.");
        for (int i = 0;i<n;i++){
            folder[i] = sc.next();
        }
        System.out.println("The folders after removing all sub-folders in the folders array is : \n"+new RemoveSubfolderFromFileSystem_1233().removeSubfolders(folder));

    }
    public List<String> removeSubfolders(String[] folder) {
        List<String> result = new ArrayList<>();

        Arrays.sort(folder);
        result.add(folder[0]);
        // Iterate through remaining folders starting from index 1
        for (int i = 1; i < folder.length; i++) {
            // Get the last added folder path and add a trailing slash
            String lastFolder = result.get(result.size() - 1) + "/";

            // Check if current folder starts with lastFolder
            // If it doesn't start with lastFolder, then it's not a subfolder
            if (!folder[i].startsWith(lastFolder)) {
                result.add(folder[i]);
            }
        }
        return result;
    }
}
