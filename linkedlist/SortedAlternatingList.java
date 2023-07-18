/*
Linked List that is Sorted Alternatingly
Input:
LinkedList: 1->9->2->8->3->7
Output: 1 2 3 7 8 9
Explanation: After sorting the given
list will be 1-> 2-> 3-> 7-> 8-> 9.

Approach

first convert into two list
1)one list of ascending order
2)another list of descending order
3)reverse descending order list
4)compare two list and merge them in a sorted way

 */

import java.util.*;

class SortedAlternatingList{

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
     
      //reverse function to reverse decreasing nodes list 
      public static Node reverse(Node head)
    {
        Node temp = head;
        Node prev = null;
        
        while(temp!=null)
        {
            Node nextnode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextnode;
        }
        
        return prev;
    }
    
   public static Node sort(Node head){
       
    //if single node exist return that node
        if(head.next==null)
        return head;
        
        //temp variable to iterate asc and desc node
        //main head variable of two list asc and desc
        //prev node to store previous node of both list

        Node tempasc = head;
        Node aschead = head;
        Node prevasc = null;
        
         Node tempdesc = head.next;
         Node deschead = head.next;
        Node prevdesc = null;
        
       // Node temp = head;
        int count=1;
        
        while(tempasc!=null && tempdesc!=null)
        {
            //odd position contains nodes in an ascending order it is given start from ascending order
            if(count%2!=0)
            {
                //if it first node of asc list update prev by tempasc 
                //otherwise linked with previous node
                if(prevasc!=null)
                prevasc.next = tempasc;
                
                prevasc = tempasc;

                //move to next node of ascending list
                 tempasc=tempasc.next.next;
                
            }
            //even position contain nodes in a deceasing order 
            else{
                
                //if it first node of desc list update prev by tempdesc 
                //otherwise linked with previous node

                 if(prevdesc!=null)
                prevdesc.next = tempdesc;
                
                prevdesc = tempdesc;

                //move to next node of descending order
                 tempdesc=tempdesc.next.next;
            }
            
            //update count to tarck whether current node is a part of ascending list or descending list 
            count++;
        }
        
        //if last node is descending order and ascending list complete
        if(count%2==0 && tempdesc!=null)
        {
          //  System.out.println(count+ " " + prevdesc.val);
              if(prevdesc!=null)
                prevdesc.next = tempdesc;
                
                //liked that current node with previous node of descending list
                tempdesc.next = null;  
                prevdesc = tempdesc;
        }
      
        //if last node is ascending order and descending list complete
         if(count%2!=0 && tempasc!=null)
        {
            if(prevasc!=null)
                prevasc.next = tempasc;
                
                //liked that current node with previous node of ascending list
            tempasc.next = null; 
            prevasc = tempasc;
        }
        
        //terminate both list by null
        prevasc.next = null;
        prevdesc.next = null;
       
        //reverse descending list
       deschead = reverse(deschead);
       
   
        //merge two sorted list
        tempasc = aschead;
        tempdesc = deschead;
    
        count=1;
        
        //iterate over two list compare both nodes
        while(tempasc!=null && tempdesc!=null)
        {
            //if ascending list node less than or equal to descending list node
            if(tempasc.val <= tempdesc.val)
            {
                //if it first node aschead dummy node point to that first node
                if(count==1)
                aschead = tempasc;
                else
                //otherwise previous node liked with current node
                prevasc.next = tempasc;
                
                //update prevasc and tempasc node for next node
                prevasc = tempasc;
                tempasc=tempasc.next;
            }else
            {
                //if descending list contain value less than ascending list 
                //if it first node aschead dummy node point to that node 
                 if(count==1)
                aschead = tempdesc;
                //otherwise previous node linked with that node
                else
                prevasc.next = tempdesc;
                
                 //update prevasc and tempdesc node for next node
                prevasc = tempdesc;
                tempdesc=tempdesc.next;
            }
            count++;
        }
        
        //if only ascending  list nodes remains add into list 
        while(tempasc!=null)
        {
            //previous node linked with  current node 
            //update previous and move to next node of list
             prevasc.next = tempasc;
            prevasc = tempasc;
            tempasc = tempasc.next;
        }

        //if only descending  list nodes remains add into list
        while(tempdesc!=null)
        {
             //previous node linked with  current node 
            //update previous and move to next node of list

            prevasc.next = tempdesc;
            prevasc = tempdesc;
            tempdesc = tempdesc.next;
        }
        
        //return head of sorted list 
       return aschead;
       
   }

    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);;
        System.out.println("Enter size of list");
        int n = sc.nextInt();

        int val[] = new int[n];
        System.out.println("Enter elements of list in such a way that odd position contains element in an increasing way and even position contains element in a descresing way");
        for(int i=0;i<n;i++)
        val[i] = sc.nextInt();

        sc.close();
   

        //create a list
        Node head = create(val);
       
       head = sort(head);
       System.out.println("List after arranged them in a sorted way");
       printList(head);

    }
}
