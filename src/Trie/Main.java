package Trie;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the choice for your Operation according to the Menu.");
        System.out.println("1--> Insert into the Trie.");
        System.out.println("2--> Search into the Trie.");
        System.out.println("3--> Delete from the Trie.");
        System.out.println("Press Any other Key to Quit.");
        System.out.println("___________________________________________________________________");
        System.out.println("Enter the Choice:-");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        TrieNode root = new TrieNode();
        while (choice < 4){
            switch (choice){

                case 1 :
                    System.out.println("Enter the String that you want to Enter to the Data Structure.");
                    String key = sc.next();
                    InsertIntoTrie.insert(root,key);
                    break;

                case 2:
                    System.out.println("Enter the String that you want to search into the Data Structure.");
                    String str = sc.next();
                    System.out.println("Enter the choice.");
                    System.out.println("1 --> Check for the Prefix.");
                    System.out.println("2 --> Check for the Complete String.");
                    int ch = sc.nextInt();
                    if (ch == 1){
                        boolean result = SearchInTrie.isPrefixExist(root,str);
                        if (result){
                            System.out.println("Prefix matched String is present in the Data Structure.");
                        }else{
                            System.out.println("No Match Found!!");
                        }
                    }else if (ch == 2){
                        boolean result = SearchInTrie.search(root,str);
                        if (result){
                            System.out.println("String is present in the Data Structure.");
                        }else{
                            System.out.println("No Match Found!!");
                        }
                    }else{
                        System.out.println("Pressed the Wrong Key, Sorry Try again Later....");
                    }
                    break;

                case 3:
                    System.out.println("Enter the String that you want to delete from the data Structure.");
                    String keyy = sc.next();
                    boolean result = DeletionInTrie.deleteKey(root,keyy);
                    if (result){
                        System.out.println("The String is deleted from the Data Structure.");
                    }else{
                        System.out.println("The String is not Present in the String.");
                    }
                    break;

                default:
                    System.out.println("Exiting from the menu ...");
                    break;
            }
            System.out.println("Enter the choice...");
            choice = sc.nextInt();
        }

    }
}
