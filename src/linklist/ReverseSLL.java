package linklist;
/*
* Algorithm Reverse Single LinkList
* 1. current = head
* 2. next = prev = null
* 3. Repeat steps 4 to 7 while current is not null
* 4. next = curr->next
* 5. curr->next = prev
* 6. prev = curr
* 7. curr = next
* 8. return prev
* 9. end
* */
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class ReverseSLL {
    public static Node reverse(Node root){
        Node curr = root;
        Node nextN = null;
        Node prev = null;
        while(curr != null){
            nextN = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextN;
        }
        root = prev;
        return root;
    }
    public static void main(String args[]){
        Node root = new Node(10);
        root.next = new Node(20);
        root.next.next = new Node(30);
        root.next.next.next = new Node(40);
        System.out.println("Before reverse");
        Node temp1 = root;
        while (temp1 != null){
            System.out.print(temp1.data + "\t");
            temp1 = temp1.next;
        }
        System.out.println("\nAfter reverse");
        Node temp = reverse(root);
        while (temp != null){
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
    }
}
