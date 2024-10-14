package Tree;
import java.util.Scanner;
public class Tree {

    public Tree(){

    }
    private static class Node{

        private int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    // insert elements

    public void populate(Scanner scanner){
        System.out.println("Enter the root Node Value: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }
    private void populate(Scanner scanner, Node node){
        System.out.println("Do you want to enter the left of "+node.value);
        boolean left = scanner.nextBoolean();
        if (left){
            System.out.println("Enter the Value for the left of "+node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to enter the right of "+node.value);
        boolean right = scanner.nextBoolean();
        if (right){
            System.out.println("Enter the value for the right of "+node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner,node.right);
        }
    }

    public void display(){
        display(root,"");
    }
    private void display(Node node, String indent){
        if (node==null){
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent+"\t");
    }

    public void prettyDisplay(){
        prettyDisplay(this.root);
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Tree tree = new Tree();
        tree.populate(sc);
        tree.display();
    }
}
