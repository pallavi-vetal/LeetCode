package leetcode.easy;
/** 206. Reverse Linked List *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * */
import leetcode.LinkNode;
public class ReverseLL206 {
    public static LinkNode reverseLL(LinkNode head){
        LinkNode curr = head;
        LinkNode prev = null;
        LinkNode next1 = null;
        while(curr!=null){
            next1 = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next1;
        }
        return prev;
    }
    public static void main(String args[]){
        LinkNode list = new LinkNode(10);
        list.next = new LinkNode(20);
        list.next.next = new LinkNode(30);
        LinkNode out = reverseLL(list);
        while(out!=null){
            System.out.println(out.data);
            out = out.next;
        }
    }
}
