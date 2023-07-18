/*
Add 1 to a number represented as linked list
Input:
LinkedList: 4->5->6
Output: 457 
 */

import java.util.*;

class Plus1{

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
    public static Node reverse(Node head)
    {
        Node temp=head;
        Node prev = null;
        while(temp!=null)
        {
            Node nextnode = temp.next;
            temp.next = prev;
            prev = temp;
            temp=nextnode;
        }
        
        return prev;
    }
    public static Node addOne(Node head) 
    { 
        //code here.
        //reverse given list 
        head = reverse(head);
        int carry = 1 ;
        Node temp = head;
        Node prev = head;
        while(temp!=null)
        {
            //after adding 1 to value store value and carry
           int value = (temp.val + carry)%10;
           carry = (temp.val + carry)/10;
           //update node value by cal value
            temp.val = value;
            
            //if carry is zero break no  need to move to next node
            if(carry==0)
            break;
            
            //else store prev and move to next node
            prev = temp;
            temp=temp.next;
        }
        
        ///if after last node still carry exist create a new node and linked with previous node
        if(temp==null && carry==1)
        prev.next = new Node(1);
        
        //after that reverse list to get final result
        head = reverse(head);

        //return head
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
       
       head = addOne(head);
       System.out.println("After adding 1 in to list is");
       printList(head);

    }
}
