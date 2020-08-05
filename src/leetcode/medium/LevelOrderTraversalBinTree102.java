package leetcode.medium;

import treecodes.TreeNode;

import javax.print.DocFlavor;
import java.util.*;

/** 102. Binary Tree Level Order Traversal **/
public class LevelOrderTraversalBinTree102 {
    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return  result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode temp = q.remove();
                currentLevel.add(temp.item);
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
            result.add(currentLevel);
        }
        return result;
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(13);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(12);
       List<List<Integer>> result = new ArrayList<>();
       result = levelOrder(root);
       for(List<Integer> res: result){
           System.out.println(Arrays.toString(res.toArray()));
       }
    }
}
