package leetcode.medium;

import leetcode.LinkNode;

public class AddNumbers2 {
    public static  LinkNode addTwoNumbers(LinkNode l1, LinkNode l2) {
        LinkNode ptr1 = l1;
        LinkNode ptr2 = l2;
        LinkNode dummy = new LinkNode(-1);
        LinkNode curr = dummy;
        int carry = 0;
        while(ptr1!=null && ptr2!=null){
            int prev_carry = carry;
            if(ptr1.data+ptr2.data+prev_carry>=10){
                curr.next = new LinkNode((ptr1.data+ptr2.data)%10+prev_carry);
                carry = Integer.parseInt(String.valueOf(String.valueOf((ptr1.data+ptr2.data)).charAt(0)));
            }
            else {
                curr.next = new LinkNode((ptr1.data+ptr2.data)+prev_carry);
                carry = 0;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
            curr = curr.next;
        }
        if(carry>0){
            curr.next = new LinkNode(carry);
        }
       return dummy.next;
    }
    public static void main(String args[]){
        LinkNode p1 = new LinkNode(1);
        p1.next = new LinkNode(2);
        p1.next.next = new LinkNode(3);
        LinkNode p2 = new LinkNode(1);
        p2.next = new LinkNode(2);
        p2.next.next = new LinkNode(3);
        LinkNode res = addTwoNumbers(p1,p2);
        LinkNode curr = res;
        while(curr!=null){
            System.out.print(curr.data);
            curr = curr.next;
        }
    }
}
