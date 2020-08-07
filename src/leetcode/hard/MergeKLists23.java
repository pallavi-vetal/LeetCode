package leetcode.hard;

import leetcode.LinkNode;

import java.util.PriorityQueue;

/** 23. Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * **/

public class MergeKLists23 {
    public static  LinkNode mergeKLists(LinkNode[] lists) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(LinkNode node: lists){
            LinkNode curr = node;
            while (curr!=null){
                minHeap.add(curr.data);
                curr = curr.next;
            }

        }
        LinkNode dummy = new LinkNode(-1);
        LinkNode temp = dummy;
        while(!minHeap.isEmpty()){
            temp.next = new LinkNode(minHeap.remove());
            temp = temp.next;
        }
        return dummy.next;
    }
    public static void main(String args[]){
        LinkNode head[] = new LinkNode[3];
        LinkNode head1 = new LinkNode(1);
        head1.next = new LinkNode(4);
        head1.next.next = new LinkNode(5);
        head[0] = head1;
        LinkNode head2 = new LinkNode(1);
        head2.next = new LinkNode(3);
        head2.next.next = new LinkNode(4);
        head[1] = head2;
        LinkNode head3 = new LinkNode(2);
        head3.next = new LinkNode(6);
        head[2] = head3;
        LinkNode res = mergeKLists(head);
        LinkNode curr = res;
        while(curr!=null){
            System.out.print(curr.data+" ->\t");
            curr = curr.next;
        }

    }
}
