/*
Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

 */

import java.util.*;

class deleteNthNodefromLast{

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

    public static Node removeNthFromEnd(Node head, int n) {
        
        //single traversal solve
        Node slow= null;
        Node fast = head;
        Node prev = null;

        int count=1;
        while(fast!=null)
        {
            //if we reached nth node from start then start increment slow pointer 
            //before nth node from starting count of nodes is same as before nth node from the ending
            //when fast pointer traverse all nodes slow pointer raeched nth node from the end

            if(count>=n)
            {
                //update prev pointer before increment slow pointer
                prev = slow;
                slow = slow==null?head:slow.next;

            }

            //move to next node
            fast = fast.next;
            //increment count by one
            count++;
        }

        //if slow null we did not reach nth node return null empty list given
        if(slow==null)
        return null;

        //nth node from last is starting node return list  from next node 
        if(slow==head)
        return slow.next;

        //otherwise linked previous node of nth node linked with next node of nth node to delete nth node from last
        prev.next = slow.next;

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


        System.out.println("Enter nth node from last which you want to delete");
        int node = sc.nextInt();

        sc.close();
   

        //create a list
        Node head = create(val);
       
       head = removeNthFromEnd(head,node);
       System.out.println("List after remove " + node + " node from last is ");
       printList(head);

    }
}
