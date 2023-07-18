/*
Find the first node of loop in linked list
Given a singly linked list of N nodes. Find the first node of the loop if the linked list has a loop. 
If a loop is present 
return the node data of the first node of the loop else return -1.
 */
import java.util.*;

class CountNodeinLoop{

    public static Node create(int ar[], int loop)
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

        //if loop value not 0 means last node linked  with any other node linked last node with given position node
        if(loop!=0)
        {
            Node lastnode = temp;
          
            temp = head;
            int count=1;
            //go to that position and linked with last node
            while(temp!=null)
            {
                if(count==loop)
                {
                    lastnode.next = temp;
                    break;
                }
                count++;
                temp=temp.next;
            }
            

        }

        return head;
    }

   
     //Function to find the length of a loop in the linked list.
     static int nodesinLoop(Node head)
     {
         //Add your code here.
         //find loop exist or not
         Node slow=head;
         Node fast=head;
         
         while(fast!=null && fast.next!=null)
         {
             slow=slow.next;
             fast=fast.next.next;
             
             if(slow==fast)
             break;
         }
         
         //if loop  does not exist return 0
         if(slow!=fast)
         return 0;
         
         //store common point in another node variable which is a part of loop
         Node loopnode = slow;
         //iterate and count no of nodes until we reached again back to loopnode
         int count=1;
         //move slow pointer by one
         slow=slow.next;
         
         while(slow!=loopnode)
         {
            //count no of nodes
             count++;
             //move to next node
             slow=slow.next;
         }
         
         //return total no of counts
         return count;
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

       System.out.println("Enter position in which last node is linked if no loop exist enter 0");
       int loop = sc.nextInt();
       sc.close();
   
       Node head = create(val,loop);

        
        int count = nodesinLoop(head);
      System.out.println("\nTotal no of nodes in a loop is "+ count);

    }
}
