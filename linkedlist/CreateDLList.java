/*
 * IIntroduction to Doubly Linked List
 * Given an integer array arr of size n. Construct the doubly linked list from arr and return the head of it.
 */
import java.util.*;

class CreateDLList{

    public static DLNode constructDLL(int arr[]) {
        // Code here
        DLNode head = null;
        DLNode pre = null;
        
        for(int i=0;i<arr.length;i++)
        {
            //create a new DLNode with value at ith index
            DLNode temp = new DLNode(arr[i]);
            //it contain null in next because at current it's last DLNode
             temp.next = null;
             
            if(i==0)
            {
                //if it is first DLNode prev pointer also contain null no  previous DLNode exist
                head=temp;
                //intialize this as a head DLNode
                head.prev=null;
            }
            else
            {
                //otherwise previous DLNode linked with current DLNode
                pre.next = temp;
                //and current DLNode linked with previous DLNode via prev pointer
                temp.prev = pre;
            }

            //update previous DLNode for next DLNode
         pre = temp;
            
        }

        //return head DLNode
        
        return head;
    }

    //Function to insert a new node at just after given position in doubly linked list.
    public static DLNode addNode(DLNode head, int pos, int data)
	{
		// Your code here
		int count=0;
		DLNode temp = head;
		int flag=0;
		
		while(temp.next!=null)
		{
            //if cuurrent index is position value just after new node is inserted
		    if(count==pos)
		    {
                //store current next node value 
		        DLNode nextnode = temp.next;

                //create a new node with given value
		        DLNode newnode = new DLNode(data);
                //link that node to nextnode
		        temp.next = newnode;
                //new node link with previous node which is temp
		        newnode.prev = temp;

                //new node next pointer link with nextnode 
		        newnode.next = nextnode;

                //nextnode linked with new node by previous node
		        nextnode.prev = newnode;

                //flag value indicate that new node added
		        flag=1;
		        
		        break;
		    }
		    
		    count++;
		    temp=temp.next;
		}
		
		//if flag=0 means no new node inserted till now it will add into after last node
		if(flag==0)
		{
		     DLNode newnode = new DLNode(data);
		      temp.next = newnode; 
		      newnode.next = null;
		      newnode.prev = temp;
		}
		
        return head;
		
	}

    //delete a node from a given position
        // function returns the head of the linkedlist
        public static DLNode deleteNode(DLNode head,int x)
        {
        // Your code here
            if(x==1)
            {
                //if first node is deleted
                head.next.prev = null;
                return head.next;
            }
            
            int count=2;
            DLNode temp = head.next;
           
           
              while(temp.next!=null)
            {
                //if any node deleted between the start and end node
                if(count==x)
                {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    return head;
                }
                
                count++;
                temp=temp.next;
                
            }
            
            //if last node is deleted
            
            temp.prev.next = null;
            return head;
        }

  
        public static DLNode reverseDLL(DLNode  head)
        {
            //Your code here
           DLNode temp = head;
            DLNode previous = null;
            
            //link reverse 
            
           while(temp!=null)
           {
                //current node next node becomes previous node
               temp.prev = temp.next;
               //current node previous node becomes next node
               temp.next = previous;
               
               //updtae previous node for next node
               previous = temp;
               //go to the next node which linked by current node prev
                temp = temp.prev;
           }
           
           //update head node which is last node
           head = previous;
           //return head node
           return head;
            
        }

        public static void printList(DLNode head)
    {
        DLNode temp=head;
        System.out.println("Value in a doubly linked list is ");
        while(temp!=null)
        {
            System.out.print(temp.val + " ");
            temp = temp.next;
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

        
       

        //create a list
        DLNode head = constructDLL(val);
        printList(head);

      
        System.out.println("\nEnter position of elements where you want  to  add  just after (0 based indexing)");
        int pos = sc.nextInt();

        System.out.println("\nEnter value of element which you want to add");
        int x = sc.nextInt();

     
        head = addNode(head,pos,x);
        printList(head);

        System.out.println("\nEnter position of element which you want to delete starting from 1");
        int dltpos = sc.nextInt();

        sc.close();


        head = deleteNode(head, dltpos);
        printList(head);

        System.out.println("\nAfter Reverse doubly linked list is");

        head = reverseDLL(head);
        printList(head);

    }
}
