package treecodes;
import treecodes.TreeNode;
import java.util.ArrayList;

public class LCA {
    private static ArrayList<Integer> p1 = new ArrayList<>();
    private  static ArrayList<Integer> p2 = new ArrayList<>();
    private static boolean findNode(TreeNode root,int n,ArrayList<Integer> p){
        if(root==null)
            return false;
        p.add(root.item);
        if(root.item==n)
            return true;
        if(root.left!=null && findNode(root.left,n,p))
            return true;
        if(root.right!=null && findNode(root.right,n,p))
            return true;
        p.remove(p.size()-1);
        return false;
    }
    public static int findLCA(TreeNode root, int n1, int n2){
        p1.clear();
        p2.clear();
        return findInternal(root,n1,n2);
    }
    private static int findInternal(TreeNode root,int n1,int n2){
        if(!findNode(root,n1,p1) || !findNode(root,n2,p2))
            return -1;
        int i=0;
        while (p1.size()>0 && p2.size()>0){
            if(!p1.get(i).equals(p2.get(i)))
                break;
            i++;
        }
        return p1.get(i-1);
    }
    //optimized
    public static TreeNode findLCASol2(TreeNode root,int n1,int n2){
        if(root==null)
            return null;
        if(root.item==n1 || root.item==n2)
            return root;
        TreeNode leftT = findLCASol2(root.left,n1,n2);
        TreeNode right = findLCASol2(root.right,n1,n2);
        if(leftT!=null && right!=null)
            return root;
        return leftT!=null?leftT:right;
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(13);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(12);
        System.out.println(findLCA(root,12,7));
        System.out.println(findLCASol2(root,12,11).item);
    }
}
