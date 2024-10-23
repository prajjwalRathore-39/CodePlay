package Tree;
import java.util.Scanner;
public class Tree {

    public Tree(){

    }
    public static class TreeNode{

        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode root;

    // insert elements

    public void populate(Scanner scanner){
        System.out.println("Enter the root TreeNode Value: ");
        int val = scanner.nextInt();
        root = new TreeNode(val);
        populate(scanner, root);
    }
    public void populate(Scanner scanner, TreeNode node){
        System.out.println("Do you want to enter the left of "+node.val);
        boolean left = scanner.nextBoolean();
        if (left){
            System.out.println("Enter the Value for the left of "+node.val);
            int val = scanner.nextInt();
            node.left = new TreeNode(val);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to enter the right of "+node.val);
        boolean right = scanner.nextBoolean();
        if (right){
            System.out.println("Enter the val for the right of "+node.val);
            int val = scanner.nextInt();
            node.right = new TreeNode(val);
            populate(scanner,node.right);
        }
    }

    public void display(){
        display(root,"");
    }
    public void display(TreeNode node, String indent){
        if (node==null){
            return;
        }
        System.out.println(indent + node.val);
        display(node.left, indent + "\t");
        display(node.right, indent+"\t");
    }

    public void prettyDisplay(){
        prettyDisplay(root,0);
    }
    public void prettyDisplay(TreeNode node, int level){
        if(node == null){
            return;
        }

        prettyDisplay(node.right, level+1);

        if (level!=0){
            for (int i=0;i<level-1;i++){
                System.out.print("|\t\t");

            }
            System.out.print("|--------->"+ node.val);
        }else{
            System.out.println(node.val);
        }

        prettyDisplay(node.left , level+1);
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Tree tree = new Tree();
        tree.populate(sc);
        tree.prettyDisplay();
    }
}
