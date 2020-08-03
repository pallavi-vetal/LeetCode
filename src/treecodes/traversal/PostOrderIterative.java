package treecodes.traversal;
import treecodes.TreeNode;
import java.util.Stack;

//left right root
public class PostOrderIterative {
    public static void postorder(TreeNode root){
        TreeNode curr = root;
        Stack <TreeNode> st1 = new Stack<>();
        Stack <TreeNode> st2 = new Stack<>();
        st1.push(curr);
        while(!st1.isEmpty()){
           curr = st1.pop();
           st2.push(curr);

           if(curr.left !=null)
               st1.push(curr.left);

           if(curr.right !=null)
                st1.push(curr.right);
        }
        while(!st2.isEmpty()){
            System.out.println(st2.pop().item);
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
        postorder(root);
    }
}
