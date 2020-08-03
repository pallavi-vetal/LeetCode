package treecodes.traversal;

import java.util.Stack;
import treecodes.TreeNode;
/*
 *  Algorithm PreOrder
 * 1. curr = root
 * 2. push curr to stack
 * 3. Repeat steps 4 to 7 until stack is not empty
 * 4. curr = st.pop
 * 5. process curr
 * 6. if curr.right!=null then push curr.right
 * 7. if curr.left!=null then push curr.left
 * 8. end
 */

public class PreorderIterative {

    public static void preorder(TreeNode root){
        Stack <TreeNode>st = new Stack<>();
        TreeNode curr = root;
        st.push(curr);
        while(!st.isEmpty()){
            curr = st.pop();
            System.out.println(curr.item);
            if(curr.right != null)
                st.push(curr.right);
            if(curr.left != null)
                st.push(curr.left);
        }
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(13);
        root.left.right = new TreeNode(16);
        root.left.left = new TreeNode(55);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(15);
        root.right.right.right = new TreeNode(65);
        root.right.right.right.right = new TreeNode(64);
        root.right.right.right.left = new TreeNode(62);
        preorder(root);
    }

}
