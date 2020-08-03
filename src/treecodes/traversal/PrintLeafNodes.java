package treecodes.traversal;
import treecodes.TreeNode;
import java.util.Stack;
/* Print all leaf nodes
* 1. curr = root
* 2. Push curr to stack
* 3. While stack is not empty
*       3.1 curr = st.pop
*       3.2 if curr.left is not null then add curr.left to stack
*       3.3 if curr.right is not null then add curr.right to stack
*       3.4 if curr.left is null and curr.right is null then print curr.data
* 4. end
*/
public class PrintLeafNodes {
    public static void printLeaves(TreeNode root){
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            System.out.print(root.item+"\t");
        if(root.left != null)
            printLeaves(root.left);
        if(root.right != null)
            printLeaves(root.right);
    }
    private static boolean isLeaf(TreeNode node){
        return node.left == null && node.right==null;
    }
    public static void print(TreeNode root){
        if(root == null)
            return;;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        st.push(curr);
        while (!st.isEmpty()){
            curr = st.pop();
            if(curr.left != null)
                st.push(curr.left);
            if(curr.right != null)
                st.push(curr.right);
            if(isLeaf(curr))
                System.out.print(curr.item+"\t");
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
        System.out.println("Leaf nodes : ");
        printLeaves(root);
        System.out.println("\nLeaf nodes without recursion : ");
        print(root);
    }
}
