package treecodes.traversal;
import java.util.*;
import treecodes.TreeNode;
/*
* Inorder :
* 1. curr = root
* 2. while curr!=null or stack is not empty repeat steps 3 to 5
* 3. while curr!=null
*       3.1 push curr to stack
*       3.2 curr = curr.next
* 4. if curr = null then pop curr from stack and print - curr = s.pop
* 5. curr = curr.right
* 6. end
* */

public class InorderTraversalWithoutRecursion {
    public static void inorder(TreeNode root){
        if(root==null)
            return;
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || s.size()>0){
            while(curr!=null){
                s.push(curr);
                curr = curr.left;
            }
            if(s.size()>0  ){
                curr = s.pop();
                System.out.println(curr.item);
            }

            curr = curr.right;
        }
    }
    public static void levelOrder(TreeNode root){
        int h = height(root);
        for(int i=1;i<=h;i++){
            print(root,i);
        }
    }
    private static void print(TreeNode root,int level){
        if(root==null)
            return;
        if(level==1)
            System.out.print(root.item+"\t");
        else if(level>1){
            print(root.left,level-1);
            print(root.right,level-1);
        }
    }
    static private int height(TreeNode root){
        if(root==null)
            return 0;
        int lt = height(root.left);
        int rt = height(root.right);
        if(lt>rt)
            return lt+1;
        else
            return rt+1;
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(13);
        root.left.right = new TreeNode(16);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(15);
        levelOrder(root);
    }
}
