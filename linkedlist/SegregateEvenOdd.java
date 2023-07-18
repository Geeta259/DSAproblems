/*
Segregate even and odd nodes in a Link List
all the even numbers appear before all the odd numbers in the modified list. 
The order of appearance of numbers within each 
segregation should be same as that in the original list.

Input: 
N = 7
Link List:
17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6 -> NULL

Output: 8 2 4 6 17 15 9

 */

import java.util.*;

class SegregateEvenOdd{

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

    public static Node divideEvenOdd(Node head){
        // code here
           // code here
        Node odd=null;
        Node even=null;
        Node firstodd=null;
        Node firsteven = null;
        
        Node temp = head;
        
        while(temp!=null)
        {
            if(temp.val%2==0)
            {
                //if current node is even 
                //check it is first even node or not if it is first even node initialize in firsteven 
                 if(firsteven==null)
                {  firsteven = temp;}
                //if firstnode initialized add current even node linked with previous even node
                else
                { even.next = temp; }
                    
                //update even node by current node for linking with next even node
                even=temp;
             
            }else
            {
                //if current node is odd
                //if it is first odd node initialize with firstodd
                if(firstodd==null)
                { firstodd = temp;}
                //otherwise current odd node linked with previous odd node 
                else
                { odd.next = temp;}
                
                //update odd node by current node for linking with next odd node
                odd=temp;
            }
            
            //move to next  node 
            temp = temp.next;
        }
        
        //if even node  exist last even node linked with first odd node
        if(even!=null)
        even.next = firstodd;
        
        //if odd node exist add last odd node next to null to terminate the list
        if(odd!=null)
        odd.next=null;
        
        //if even exist return firsteven which is head node
        if(even!=null)
        return firsteven;
        //if even node not exist return firstodd which is head node of odd list
        else
        return firstodd;
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
       
       head = divideEvenOdd(head);
       printList(head);

    }
}
