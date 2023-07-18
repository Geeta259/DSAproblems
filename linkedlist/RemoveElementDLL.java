/*
 * Delete all occurrences of a given key in a doubly linked list
 * You are given the head of a doubly Linked List and a Key. Your task is to delete all occurrences of the given key and return the new DLL.
 * Input: 
2<->2<->10<->8<->4<->2<->5<->2
2
Output: 
10<->8<->4<->5
Explanation: 
All Occurences of 2 have been deleted.
 */
import java.util.*;

class RemoveElementDLL{

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


    static DLNode deleteAllOccurOfX(DLNode head, int x) {
        // Write your code here
        DLNode temp = head;
        //iterate until list not empty
        while(temp!=null)
        {
           // System.out.println(temp.data);
           //if current node value match with given value
            if(temp.val==x)
            {
                //if it is beginning node current node next node becomes head node and prev pointer contain null value
                if(temp.prev == null)
                {
                    head=temp.next;
                    if(head!=null)
                    head.prev = null;
                }
                
               
                
                else
                {
                    //otherwise previous node of current node linked with next node of current node
                     temp.prev.next = temp.next;
                     //if it is not last node then next node of current node linked with previous node of current node
                    if(temp.next!=null)
                    temp.next.prev = temp.prev;
                }
                
            }
            //move to next node
            temp=temp.next;
        }
        
        return head;
    }
    
    public static void printList(DLNode head)
    {
        DLNode temp=head;
        System.out.println("Value in a Doubly linked list is ");
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
      
        System.out.println("\nEnter element which you want to delete from  a DLL");
        int dltelem = sc.nextInt();

        sc.close();


        head = deleteAllOccurOfX(head,dltelem);
     
        System.out.println("\nAfter Remove element from a doubly linked list");
          printList(head);

    }
}
