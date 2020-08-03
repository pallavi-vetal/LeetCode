package treecodes.traversal;
import treecodes.TreeNode;

public class HeightOfTree {
    public static int height(TreeNode root){
        if(root == null)
            return 0;
        else{
            int leftT = height(root.left);
            int rightT = height(root.right);
           return leftT > rightT ? leftT + 1: rightT + 1;
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
       System.out.println("Height of Binary tree is : "+height(root));
    }
}
