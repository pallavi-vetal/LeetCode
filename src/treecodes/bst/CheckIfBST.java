/** Microsoft * */
package treecodes.bst;
import treecodes.TreeNode;

import java.util.ArrayList;

public class CheckIfBST {
    private static ArrayList<Integer> rootData = new ArrayList<>();
    public static void inorder(TreeNode root,ArrayList<Integer> list){
        if(root!=null){
            inorder(root.left,list);
            System.out.println(root.item);
            list.add(root.item);
            inorder(root.right,list);
        }
    }
    public static boolean isBST(TreeNode root){
        inorder(root,rootData);
        for(int i=0;i<rootData.size()-1;i++){
            if(rootData.get(i)>rootData.get(i+1))
                return false;
        }
        return true;
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(13);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(15);
        root.left.left = new TreeNode(7);

        System.out.print("Is BST : "+isBST(root));
    }

}
