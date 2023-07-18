/*
Odd Even Linked List
The first node is considered odd, and the second node is even, and so on.
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
 */

import java.util.*;

class AlternateEvenOdd{

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
    public static Node oddEvenList(Node head) {

        //if only one node exist or blank list return head
        if(head==null || head.next==null)
        return head;

        Node temp = head;
        //count total no of nodes
        int count=0;
        while(temp.next!=null)
        {
            temp=temp.next;
               count++;
        }
            
        //count even & odd nodes
        //first node is always odd
        int even = count/2;
        int odd = count-even;

        Node lastnode = temp,evennode=null;
        int countodd = 0;
        temp=head;
        while(temp!=null)
        {
            //if all odd nodes covered break from loop
            if(countodd==odd)
            break;

            //if current node is odd store next node which is even
             evennode = temp.next; 

             //got o another odd nodes
            if(temp.next.next!=null)
            temp.next = temp.next.next;

            //and even node linked with last node 
            lastnode.next = evennode;
            evennode.next = null;
            countodd++;

            //update last node go to next odd node
            lastnode = evennode;
             temp = temp.next;

        }        
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
        System.out.println("Enter elements of list alternate odd / even first node is odd");
        for(int i=0;i<n;i++)
        val[i] = sc.nextInt();

        sc.close();
   

        //create a list
        Node head = create(val);
       
       head = oddEvenList(head);
       printList(head);

    }
}
