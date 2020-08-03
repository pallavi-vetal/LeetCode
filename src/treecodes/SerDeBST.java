/*
* Serialization and deserialization of BST
* 1. BST - (left child value < root value & right child value > root value )use preorder or postorder
* 2. Complete Binary Tree - (All levels are filled ,last level can be incomplete ) Use level order
* 3. Full binary tree - Each node have 0 or 2 nodes - use preorder and set bit for internal node
*/
package treecodes;
import java.io.*;
import java.util.Scanner;
class Node{
    int value;
    Node left;
    Node right;

    Node(int value){
        this.value=value;

    }
}
public class SerDeBST {
    public static Node newroot = null;
    public  void serialize(Node root,BufferedWriter writer) throws IOException{
        if(root==null)
        {
            writer.write("-1"+"\n");
            return;
        }
        System.out.println(root.value);
        writer.write(String.valueOf(root.value)+"\n");
        serialize(root.left,writer);
        serialize(root.right,writer);
    }
    public static  void deserialize(Node root,BufferedReader reader) throws IOException{

        String val2 = reader.readLine();
        if ( val2==null || val2=="-1")
        return;

        // Else create node with this item and recur for children
        root = new Node(Integer.parseInt(val2));
        deserialize(root.left, reader);
        deserialize(root.right, reader);
    }
    public static void print(Node root){
        if(root!=null){
            System.out.println(root.value);
            print(root.left);
            print(root.right);
        }
    }
    public static  void main(String args[]) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("*********************\n1. Serialize\n2. Deserialize\nMake Choice\n");
        Node root = new Node(10);
        root.left= new Node(10);
        root.left.left = new Node(5);
        root.right = new Node(20);
        root.right.right = new Node(25);
        SerDeBST obj = new SerDeBST();
        FileWriter out = null;
        BufferedWriter writer = null;
        FileReader inFile = null;
        BufferedReader reader = null;
        int choice = in.nextInt();
        switch (choice){
            case 1:
               try{
                     out = new FileWriter("serde1.txt",true);
                     writer = new BufferedWriter(out);
                    obj.serialize(root,writer);

                } catch (IOException e) {
                    System.err.format("IOException: %s%n", e);
                }
               finally {
                   writer.close();
                   out.close();

               }
                break;
            case 2:
                try {
                    inFile = new FileReader("serde1.txt");
                    reader = new BufferedReader(inFile);
                    Node temp =null;
                    deserialize(temp,reader);
                    print(temp);
                }
                catch (IOException e){

                }
                finally {
                    inFile.close();
                    reader.close();
                }
                break;
            default:
                System.out.println("Invalid choice \n");
                System.exit(1);
        }
    }
}
