package treecodes.traversal;
/*
* Print all nodes at distance K from root node.
*/
import treecodes.TreeNode;

public class PrintNodesAtDistKFromRoot {
    public static void printNodesAtDistK(TreeNode root,int k){
        if(root == null)
            return;
        if(k == 0){
            System.out.print(root.item+"\t");
            return;
        }
        printNodesAtDistK(root.left,k-1);
        printNodesAtDistK(root.right,k-1);
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(11);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(13);
        root.left.right = new TreeNode(14);
        root.right.left = new TreeNode(15);
       root.right.right = new TreeNode(16);
       printNodesAtDistK(root,2);
    }
}
