import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

class AddOne
{
    public static Node reverseList(Node head)
    {
        Node prev = null, next = null;
        Node temp = head;
        while(temp!=null)
        {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
    public static Node add1(Node head)
    {
        head = reverseList(head);
        int carry=1;
        Node temp = head,prev = null;
        while(temp!=null)
        {
            int val = temp.data + carry;
            temp.data = val%10;
            carry = val/10;
            prev = temp;
            temp = temp.next;
        }

        if(carry > 0)
        {
            Node newnode = new Node(carry);
            prev.next = newnode;
        }
        head = reverseList(head);
        return head;
    }
   public static void printList(Node head)
   {
       Node temp = head;
       while(temp!=null)
       {
           System.out.print(temp.data + " ");
           temp = temp.next;
       }
       System.out.println();
   }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Node head=null,prev=null;

        for(int i=0;i<n;i++)
        {
            int val = sc.nextInt();
            Node newnode = new Node(val);
            if(prev!=null)
            prev.next = newnode;
            else
            head = newnode;

            prev = newnode;
        }

        head = add1(head);
        printList(head);
    }
}