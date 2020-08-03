package leetcode.easy;
import treecodes.TreeNode;
public class LCABinaryTree235 {
    public static TreeNode LCA(TreeNode root, TreeNode p,TreeNode q){
        if(p.item < root.item && q.item < root.item)
            return LCA(root.left,p,q);
        else if(p.item > root.item && q.item > root.item)
            return LCA(root.right,p,q);
        else
            return root;
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(13);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(12);

        System.out.println(LCA(root,root.left,root.right.right).item);
    }
}
