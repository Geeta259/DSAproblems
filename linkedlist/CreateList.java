/*
 * Introduction to Linked List
 * Geek loves linked list data structure. Given an array of integer arr of size n, Geek wants to construct the linked list from arr.
Construct the linked list from arr and return the head of the linked list.
 */
import java.util.*;

class CreateList{

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
    public static Node insertAtEnd(Node head, int x)
    {
        // code here
        Node temp = new Node(x);
        temp.next = null;
        
        if(head==null)
        return temp;    
        
        Node curr = head;
         while(curr.next!=null)
        {
            curr=curr.next;
        }
        
        curr.next = temp;
        
        return head;
        
    }
    public static Node insertAtBeginning(Node head, int x)
    {
        // code here
        Node temp = new Node(x);
        temp.next = head;
        
        head = temp;
        return head;
    }
    
    public static Node deleteNode(Node head, int x)
    {
	// Your code here	
	    Node temp = head.next;
	    Node prev = head;
	    
	    if(x==1)
	    return temp;
	    
	    int count=2;
	    
	    while(temp!=null)
	    {
	        if(count==x)
	        {
	            prev.next=temp.next;
	            break;
	        }
	        count++;
	        prev = temp;
	        temp=temp.next;
	    }
	    
	    return head;
    }
    public static int countNode(Node head)
    {
        
        //Code here
        Node temp = head;
        int count=0;
        
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        
        return count;
    }

    public static boolean searchKey(Node head, int key) {
        // Code here
        Node temp = head;
        while(temp!=null)
        {
            if(temp.val == key)
            return true;
            
            temp = temp.next;
        }
        
        return false;
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
        Node head = create(val);
        printList(head);

        System.out.println("\nEnter element to insert at end");
        int start = sc.nextInt();
        head = insertAtEnd(head,start);
        printList(head);


        System.out.println("\nEnter element to insert at beginning");
        int end = sc.nextInt();
        head = insertAtBeginning(head,end);
        printList(head);

        System.out.println("\nEnter position of element which you want to delete");
        int pos = sc.nextInt();
        head = deleteNode(head,pos);
        printList(head);

        int count = countNode(head);
        System.out.println("\n Count of nodes in a linked list is " + count);
        
        System.out.println("Enter element which you want to check if it present or not");
        int key = sc.nextInt();

        if(searchKey(head,key))
        System.out.println("Node is present in a list \n");
        else 
        System.out.println("Node is not present in a list \n");

        sc.close();
   
    }
}
