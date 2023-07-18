/*
Add two numbers represented by linked lists
Input:
N = 2
valueN[] = {4,5}
M = 3
valueM[] = {3,4,5}
Output: 3 9 0  
Explanation: For the given two linked
list (4 5) and (3 4 5), after adding
the two linked list resultant linked
list will be (3 9 0).
 */

import java.util.*;

class AddTwoList{

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

    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
 
         //first reverse both list because add from least significant node
        first = reverse(first);
        second = reverse(second);
    
        Node temp1 = first;
        Node temp2=second;
        
        int carry=0;
        Node prev = null;
        Node sum=null;
        
        
        while(true)
        {
            //if both list empty and no carry left break the loop
            if(temp1==null && temp2==null && carry==0)
            break;
            
            int add=0;

            //if first list not empty add their value and move to next node
            if(temp1!=null)
            {
                add+=temp1.val;
                temp1=temp1.next;
            }
            
              //if second list not empty add their value and move to next node
            if(temp2!=null)
            {
                add+=temp2.val;
                temp2=temp2.next;
            }

            //add previous carry 
            
            add+=carry;

            //total add value find current value  and carry for next sum
            
             int val = add%10;
            carry = add/10;
              
            //create a newnode with value
              Node newnode = new Node(val);
              newnode.next = null;
              
              //if previous null make current node is head node otherwise current node linked with previous node
              if(prev!=null)
              prev.next = newnode;
              else
              sum=newnode;
              
              //update previous node so that we can link with next new node
              prev = newnode;
            
        }
    
        //final list reverse to get desired list return sum node which is headnode of resulatant list
       
       sum = reverse(sum);
       return sum;
     
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
        System.out.println("Enter size of first list");
        int n = sc.nextInt();

        int val1[] = new int[n];
        System.out.println("Enter elements of first list");
        for(int i=0;i<n;i++)
        val1[i] = sc.nextInt();

        System.out.println("Enter size of second list");
        int m = sc.nextInt();

        int val2[] = new int[m];
        System.out.println("Enter elements of second list");
        for(int i=0;i<m;i++)
        val2[i] = sc.nextInt();

        sc.close();
   

        //create a list
        Node head1 = create(val1);
        Node head2 = create(val2);
       
       Node head =  addTwoLists(head1,head2);
       System.out.println("After add two list is");
       printList(head);

    }
}
