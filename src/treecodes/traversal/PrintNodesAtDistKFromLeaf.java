package treecodes.traversal;
import treecodes.TreeNode;
/* Find all nodes which are at distance k from given leaf node */
public class PrintNodesAtDistKFromLeaf {
    public static int printNodes(TreeNode root, int k){
        if(root == null)
            return -1;
        int leftSTree = printNodes(root.left,k);
        int rightSTree = printNodes(root.right,k);
        boolean isLeaf = leftSTree == -1 && (leftSTree==rightSTree);
        if(leftSTree == 0 || rightSTree == 0 || (isLeaf && k == 0))
            System.out.print(root.item+"\t");
        if(isLeaf && k>0)
            return k-1;
        if(leftSTree >0 && leftSTree < k)
            return leftSTree - 1;
        if(rightSTree >0 && rightSTree < k)
            return rightSTree - 1;
        return -2;
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
        System.out.println("Nodes at distance 1 from leaf nodes are : ");
        printNodes(root,1);
    }
}
