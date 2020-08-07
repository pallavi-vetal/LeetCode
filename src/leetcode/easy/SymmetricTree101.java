package leetcode.easy;

import treecodes.TreeNode;

/** 101. Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *    */
public class SymmetricTree101 {
    public static boolean isSymmetric(TreeNode root){
        if(root==null)
            return true;
        return isSymmetric(root.left,root.right);
    }
    private static boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null || right == null)
            return left == right;
        if(left.item != right.item)
            return false;
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
    public static void  main(String args[]){
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(2);
            root.left.left = new TreeNode(3);
            root.left.right = new TreeNode(4);
            root.right.left = new TreeNode(4);
            root.right.right = new TreeNode(3);
            System.out.println(isSymmetric(root));
    }
}
