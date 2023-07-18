/*
Reverse a Linked List in groups of given size.
Input:
LinkedList: 1->2->2->4->5->6->7->8
K = 4
Output: 4 2 2 1 8 7 6 5 
Explanation: 
The first 4 elements 1,2,2,4 are reversed first 
and then the next 4 elements 5,6,7,8. Hence, the 
resultant linked list is 4->2->2->1->8->7->6->5.
 */
import java.util.*;

class ReverseKNodes{

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
    public static Node reverseKnode(Node node, int k)
    {
        //created a dummy node which value -1 which always point to head node
        Node dummy = new Node(-1);
        dummy.next = node;
        
        Node curr=dummy.next;
        Node prev = dummy;
        Node next = dummy;
        
        int count=0;
        //first count total no of nodes
        while(curr!=null)
        {
            count++;
            curr=curr.next;
        }
    
        int min = count>k?k:count;
        
        while(count>=min && count!=0)
        {
            //starting two nodes of group of size k
           curr = prev.next;
           next = curr.next;
           
           //k-1 links reverse in a group of size k
           for(int i=1;i<min;i++)
           {
               //reverse a link of two nodes
                curr.next = next.next;
                next.next = prev.next;
                
                //second node comes in starting and prev which indicate last node of previous group
                //linked with second node 
                prev.next = next;
                //update next for next links to reverse
                next = curr.next;
           }
           
           //when k-1 links reverse a group of size k reversed
           //update prev
           prev = curr;
           count-=min;
           min = count>min?min:count;
        }
        
        
        //return dummy.next which point to head node
        return dummy.next;
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
    
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);;
        System.out.println("Enter size of list");
        int n = sc.nextInt();

        int val[] = new int[n];
        System.out.println("Enter elements of list");
        for(int i=0;i<n;i++)
        val[i] = sc.nextInt();

        //create a list
        Node head = create(val);
       // printList(head);
       System.out.println("Enter group size of list to reverse");
       int k = sc.nextInt();
    
       sc.close();
   
        head = reverseKnode(head,k);

        System.out.println("After reverse node of group of size k");
        printList(head);
    
    }
}
