/*Find middle element in a Linked List
Problem Statement: Given the head of a singly linked list, return the middle node of the linked list.
 If there are two middle nodes, return the second middle node.

 Approach used:
 Tortoise-Hare-Approach
 *
 */
import java.util.*;

class FineMiddleNode{

    public static Node create(int ar[])
    {
        Node head = new Node(ar[0]);
        Node temp = head;
        for(int i=1;i<ar.length;i++)
        {
            Node newnode = new Node(ar[i]);
            newnode.next = null;

            temp.next = newnode;
            temp = newnode;
        }

        return head;
    }
    
    public static void printList(Node head)
    {
        Node temp=head;
        System.out.println("Node in a list is: ");
        while(temp!=null)
        {
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
    }
   
  
    public static int getMiddle(Node head)
    {
         // Your code here.
         //used two pointer slow and fast start from the head node
         Node slow=head;
         Node fast =head;
         
         //fast pointer traverse double than slow pointer if fast pointer cover all nodes slow pointer point to middle node
         while(fast!=null && fast.next!=null)
         {
             slow=slow.next;
             fast=fast.next.next;
         }
         
         //return slow pointer value which indicate the middle node
         return slow.val;
    }

    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);;
        System.out.println("Enter size of list");
        int n = sc.nextInt();

        int val[] = new int[n];
        System.out.println("Enter elements of list");
        for(int i=0;i<n;i++)
        val[i] = sc.nextInt();

        sc.close();
   

        //create a list
        Node head = create(val);
       // printList(head);

        int mid = getMiddle(head);
        System.out.println("\nMiddle node of linked list value is "+ mid);
       

       
    }
}
