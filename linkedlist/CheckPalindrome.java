/*
Check if Linked List is Palindrome
Given a singly linked list of size N of integers. The task is to check 
if the given linked list is palindrome or not.
 *
 */
import java.util.*;

class CheckPalindrome{

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
    public static boolean isPalindrome(Node head) 
    {
        //Your code here
        //find mid node 
        Node slow=head;
        Node fast=head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
      
        fast = reverse(slow.next);
        slow = head;
        
        while(fast!=null)
        {
            if(slow.val!=fast.val)
            return false;
            
            slow=slow.next;
            fast=fast.next;
        }
        
        return true;
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
       // printList(head);

        if(isPalindrome(head))
        System.out.println("Given list is palindrome");
        else
        System.out.println("Given list is not palindrome");
    
    }
}
