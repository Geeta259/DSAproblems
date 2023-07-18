/*
Given a linked list of 0s, 1s and 2s, sort it
Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s 
linked list such that all zeros segregate to head side
, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.

Input:
N = 8
value[] = {1,2,2,1,2,0,2,2}
Output: 0 1 1 2 2 2 2 2
Explanation: All the 0s are segregated
to the left end of the linked list,
2s to the right end of the list, and
1s in between.

 */

import java.util.*;

class Sort012List{

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

    public static Node segregate(Node head)
    {
        // add your code here
        //three separate list zero , one , two with inital value -1
        Node zero = new Node(-1);
        Node one = new Node(-1);
        Node two = new Node(-1);

        //previous node for each list
        Node prev0 = zero;
        Node prev1 = one;
        Node prev2 = two;
        
        while(head!=null)
        {
            //make a node which contain value of current node
            Node curr = new Node(head.val);
            
            //if it is zero add into zerolist  and update prev node of zero list
            if(curr.val==0)
            {
                 prev0.next = curr;
                 prev0 = curr;
            }

             //if it is one add into onelist  and update prev node of one list
            else if(curr.val==1)
            {
                 prev1.next = curr;
                 prev1 = curr;
            }

             //if it is two add into twolist  and update prev node of two list
            else{
                 prev2.next = curr;
                 prev2 = curr;   
            }
            
            head = head.next;
        }
        
        //if zero exist
        //now linked all three list with each other
        //intial head zero list 
        head = zero.next;

        //if zero exist in a list
        if(prev0.val!=-1)
        {
            //check if one exist or not
            if(prev1.val!=-1)
            {
                //zerolist linked with onelist
                 prev0.next = one.next;

                 //if twolist contain any value of 2 
                 //onelist linked with twolist
                 if(prev2.val!=-1)
                 prev1.next = two.next;
            }
           
            //if not any 1 exist in a onelist
            //direct zerolist linked with twolist
            else
            prev0.next = two.next;
            
        }else
        {
            //if no zero exist in a zero list
            //check 1 exist in a onelist if it exist
            //head start from onelist
             if(prev1.val!=-1)
             {
                 prev1.next = two.next;
                 head = one.next;
             }
           
             //if not 1 exist in a onelist head start from twolist
            else
            head = two.next;
        }

        //return head of list
       
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
        System.out.println("Enter elements of list either 0 ,1 or 2");
        for(int i=0;i<n;i++)
        val[i] = sc.nextInt();

        sc.close();
   

        //create a list
        Node head = create(val);
       
       head = segregate(head);
       System.out.println("List after arranged them in a sorted way");
       printList(head);

    }
}
