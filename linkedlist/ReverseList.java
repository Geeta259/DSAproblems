/*

 *Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
import java.util.*;

class ReverseList{

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

    public static Node revList(Node head)
    {
        // code here
        Node temp = head;
        Node  prev = null;
        
        //reverse the link
        while(temp!=null)
        {
            //store next node into another node
            Node nextnode = temp.next;
            //previous node linked with current node
            temp.next = prev;
            //update previous node for next node
            prev= temp;
            //iterate to next node
            temp = nextnode;
        }
        
        //return last node which stored in prev as a head node 
        return prev;
    }

    /*
    by using recursion

     * Node revList(Node curr,Node prev)
    {
        //if current node null return last node which stored in prev

        if(curr==null)
        return prev;

        //store next node
        Node nextnode = curr.next;

        //current node link with previous node
        curr.next = prev;
        
        //again call for nextnode 
        return revList(nextnode,curr);
    }
    
     */
    
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
       printList(head);

        System.out.println("\nReverse Linked list is ");  
        head = revList(head);

        printList(head); 
    }
}
