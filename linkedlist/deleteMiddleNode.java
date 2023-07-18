/*
Modify Linked List
1. Modify the value of the first half nodes such that 1st node's new value is equal to the value of the last node minus the first node's current value, 2nd node's new value is equal to the second last nodes value minus 2nd nodes current value, likewise for first half nodes.
2. Replace the second half of nodes with the initial values of the first half nodes(values before modifying the nodes).
3. If N is odd then the value of the middle node remains unchanged.

 */

import java.util.*;

class deleteMiddleNode{

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

    public static Node deleteMid(Node head) {
     
        //find middle element
        Node slow=head;
        Node fast = head;
        Node prev = null;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            //current node store prev before move to next node for remove the middle node
            prev = slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        
      // System.out.println(fast.data);

        //if even no of node exist move one node forward because mwe want to remove second middle node
        if(fast.next!=null && fast.next.next==null)
        {
            //store previous node of middle node
            prev=slow;
            //move to second middle node which we want to remove
            slow=slow.next;
        }    
        
       //  System.out.println(slow.data);
       //connect previous node of middle with next node of middle
        prev.next = slow.next;
        
        //return head node
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
       
       head = deleteMid(head);
       System.out.println("List after remove middle node is ");
       printList(head);

    }
}
