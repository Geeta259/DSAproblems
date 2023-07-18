/*
Given the head of a linked list, rotate the list to the right by k places.

 Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
 */

 import java.util.*;

 class RotateListFromLast{
 
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

     public static Node rotateRight(Node head, int k) {
        
        //if list is blank or only single node present in a list return null
        if(head==null || head.next==null)
        return head;

        //start from head and count total no of nodes
        Node curr = head;
        int count=1;
        while(curr.next!=null)
        {
            curr=curr.next;
            count++;
        }

        //if given no is greater than count get modulus of it so that can get rotation position
        if(k>count)
        {
                 k = k%count;
              //  System.out.println(k);
                
        }
   
        //rotation poisition start from end means count-k position from start
        k = count-k;
      // System.out.println(k);

        //if rotation position 0 or count return same list after rotation get original list
        if(k==0 || k==count)
        return head;

        //store last node into last pointer
        Node last = curr;

        //create a new dummmy node which point to head node
        Node dummy = new Node(-1);
        dummy.next = head;

        //find rotation point which is after k position
        curr = head;
        count=0;

        Node prev = dummy;

        while(count!=k)
        {
            //if count less than rotation position just iterate through nodes 
            prev = curr;
            curr=curr.next;
            count++;
        }

        //if find kth rotation posiiton nodes break the link from there and link which dummy next node which indicate head node
        //last node linked with head node
        prev.next = null;
        dummy.next = curr;
        last.next = head;

        //return head node which pointed by dummy node
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
         System.out.println("Enter elements in a list");
         for(int i=0;i<n;i++)
         val[i] = sc.nextInt();
 
         System.out.println("Enter rotation posiition from last");
         int k = sc.nextInt();
 
         sc.close();
    
 
         //create a list
         Node head = create(val);
        
        head = rotateRight(head,k); 
        printList(head);
 
     }
 }
 