package leetcode.medium;

import treecodes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/** 116. Populating Next Right Pointers in Each Node **/
public class ConnectNodesAtSameLevel116 {
    public static TreeNode connect(TreeNode root){
        TreeNode temp = null;
        if(root==null)
            return  root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode prev = temp;
                temp = q.poll();
                if(i>0)
                    prev.next = temp;
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
            temp.next = null;
        }
        return root;
    }
}
