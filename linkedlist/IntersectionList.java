/*
 Intersection of Two Linked Lists
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 If the two linked lists have no intersection at all, return null.


 Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Intersected at '2' node value
 */

import java.util.*;

class IntersectionList{

    //this function is used to create  a list
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

    public static Node getIntersectionNode(Node headA, Node headB) {
        
        //first find size of both list
        Node temp1 = headA;
        Node temp2 = headB;

        int count1=0,count2=0;
        while(temp1!=null)
        {
                count1++;
                temp1=temp1.next;
        }

        while(temp2!=null)
        {
                count2++;
                temp2=temp2.next;
        }

       //check which list is larger and how much
        temp1=headA;
        temp2=headB;
        while(count1>count2)
        {
            // System.out.println(temp1.val +" " + count);
            //if first list is larger than second list move to next node until size of both list becomes equal
            temp1=temp1.next;
            count1--;
        }
        
        while(count2>count1)
        {
              //if second list is larger than first list move to next node until size of both list becomes equal
            temp2=temp2.next;
            count2--;
        }

        //System.out.println(temp1.val +" " + temp2.val);
        //simultaneously move in bith list and compare node if they equal return node 
        while(temp1!=null && temp2!=null)
        {
            if(temp1==temp2)
            return temp1;

            temp1=temp1.next;
            temp2=temp2.next;
        }

        //if not find any node which is equal return null
        return null;

    }

    //linked two list 
    public static Node linkedList(Node head1,Node head2,int skip1,int skip2)
    {
        int count1=0,count2=0;
        Node temp1 = head1,temp2=head2;

        //move to next node of list 1 until we skip (skip1) node from beginning
        while(count1!=skip1 && temp1!=null)
        {
            temp1=temp1.next;
            count1++;
        }

        // move to next node of list 2 until we skip (skip2) node from beginning
        while(count2!=skip2 && temp2!=null)
        {
            temp2=temp2.next;
            count2++;
        }

        //if second list not empty just linked that node with first list
        if(temp2!=null)
        temp2.next = temp1;

        //return second list 
        return head2;
    }

    //this function is used to print the list
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

        System.out.println("Enter no of node to skip of first list to get intersection node");
        int skip1 = sc.nextInt();


        System.out.println("Enter no of node to skip of second list to get intersection node");
        int skip2 = sc.nextInt();

        sc.close();
   

        //create a list
        Node head1 = create(val1);
        Node head2 = create(val2);

        head2 = linkedList(head1,head2,skip1,skip2);
       
        Node head = getIntersectionNode(head1,head2);
        if(head!=null)
        {
            System.out.println("Intersection list of two linked list is");
            printList(head);     
        }else
        {
            System.out.println("No Intersection list of two linked list is");
        }
    
    }
}
