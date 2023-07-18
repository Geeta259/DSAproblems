/*
Modify Linked List
1. Modify the value of the first half nodes such that 1st node's new value is equal to the value of the last node minus the first node's current value, 2nd node's new value is equal to the second last nodes value minus 2nd nodes current value, likewise for first half nodes.
2. Replace the second half of nodes with the initial values of the first half nodes(values before modifying the nodes).
3. If N is odd then the value of the middle node remains unchanged.

 */

import java.util.*;

class ModifyLinkedList{

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

        //reverse the list
        public static Node reverse(Node head)
        {
            Node temp = head;
            Node prev = null;
            
            while(temp!=null)
            {
                Node nextnode= temp.next;
                temp.next = prev;
                prev = temp;
                temp=nextnode;
                
            }
            
            return prev;
        }
        public static Node modifyTheList(Node head)
        {
            //find middle node
            Node slow = head;
            Node fast = head;
            
            while(fast.next!=null && fast.next.next!=null)
            {
                slow=slow.next;
                fast=fast.next.next;
            }
      
            //after mid node reverse the list
            Node midnode = slow;
            Node righthead = reverse(midnode.next);
           
           //last node of left part of mid terminate null
            midnode.next = null;
             
            //traverse both right part and left part simultaneously
            Node temp2 = righthead;
            Node temp1= head;
            
            //iterate until right part not end
               while(temp2!=null)
            {
                //left part node value rightnode - leftnode
                //right part node value contain of left part node
                int x =temp1.val;
                temp1.val = temp2.val-temp1.val;
                temp2.val = x;
                
                temp1=temp1.next;
                temp2=temp2.next;
            }
    
            
            //after middle node right part again reverse linked with midnode->next
            midnode.next = reverse(righthead);
            
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
       
       head = modifyTheList(head);
       printList(head);

    }
}
