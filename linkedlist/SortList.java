/*
Given the head of a linked list, return the list after sorting it in ascending order.
Input: head = [4,2,1,3]
Output: [1,2,3,4]

 */

import java.util.*;

class SortList{

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

    //find middle of list to separate into two list
    public static Node findMiddle(Node head)
    {
         Node slow = head;
        Node fast = head.next;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        Node mid = slow.next;
        slow.next = null;

        return mid;
    }

    //merge two list into one spearated list

    public static Node merge(Node list1 , Node list2)
    {
        //create a dummy head with intial value -1
        Node dummyhead = new Node(-1);
        //store dummyhead curr node for traversing
        Node curr = dummyhead;

        //iterate over two list
        while(list1!=null && list2!=null)
        {
            //which one is small add into curr.next  node and move  to next node
           if(list1.val<=list2.val)
           {
                curr.next = list1;
                list1=list1.next;
           }else
           {
               
                curr.next = list2;
                list2=list2.next;
           }

           //update curr for link with next small node
           curr = curr.next;
        }

        //if one element left either in list1 or list2 add into curr next otherwise curr next null
        curr.next = list1 != null ? list1 : list2;

        //return head node which point to dummynode next node
       return dummyhead.next;

    }
    public static Node sortList(Node head) {

            if(head==null || head.next==null)
            return head;

            //find midddle node
            //from head to previous node of middle left list
            //from middlenode to end right list

            Node midnode = findMiddle(head);
            Node leftlist = sortList(head);
            Node rightlist = sortList(midnode);

            //after separate list in two parts merge them in to one inn a sorted way
            return merge(leftlist,rightlist);
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
       
       head = sortList(head);
       System.out.println("List after arranged them in a sorted way");
       printList(head);

    }
}
