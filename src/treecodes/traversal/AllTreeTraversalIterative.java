package treecodes.traversal;

import java.util.Stack;
import treecodes.TreeNode;
public class AllTreeTraversalIterative {
    public static void inorder(TreeNode root){
        Stack <TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(curr !=null || !st.isEmpty()){
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            System.out.print(curr.item+"\t");
            curr = curr.right;
        }
    }
    public static void preorder(TreeNode root){
        TreeNode curr = root;
        Stack<TreeNode> st = new Stack<>();
        st.push(curr);
        while (!st.isEmpty()){
            curr = st.pop();
            System.out.print(curr.item+"\t");
            if(curr.right != null)
                st.push(curr.right);
            if(curr.left != null)
                st.push(curr.left);
        }
    }
    public static void postorder(TreeNode root){
        TreeNode curr = root;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(curr);
        while (!st1.isEmpty()){
            curr = st1.pop();
            st2.push(curr);
            if(curr.left != null)
                st1.push(curr.left);
            if(curr.right != null)
                st1.push(curr.right);
        }
        while (!st2.isEmpty()){
            System.out.print(st2.pop().item+"\t");
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
        /*
        *            10
        *          /    \
        *       12       13
        *      /  \      /  \
        *    55    16   14    15
        *                       \
        *                       65
        *                      /  \
        *                     62  64
        * */
        System.out.println("\n******* Inorder traversal*******\n");
        inorder(root);
        System.out.println("\n******* Preorder traversal*******\n");
        preorder(root);
        System.out.println("\n******* Postorder traversal*******\n");
        postorder(root);
    }
}
