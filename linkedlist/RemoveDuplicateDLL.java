/*
Remove duplicates from a sorted doubly linked list
Input:
n = 6
1<->1<->1<->2<->3<->4
Output:
1<->2<->3<->4
Explanation:
Only the first occurance of node with value 1 is 
retained, rest nodes with value = 1 are deleted.
 * 
 */
import java.util.*;

class RemoveDuplicateDLL{

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


    public static DLNode removeDuplicates(DLNode head){
        // Code Here.
        
        DLNode temp = head.next;
        while(temp!=null)
        {
            if(temp.val == temp.prev.val)
            {
                temp.prev.next = temp.next;
                
                if(temp.next!=null)
                temp.next.prev = temp.prev;
            }
            temp = temp.next;
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
        System.out.println("Enter elements of list in a sorted manner");
        for(int i=0;i<n;i++)
        val[i] = sc.nextInt();

      
        //create a list
        DLNode head = constructDLL(val);
      
       
        sc.close();

        head =  removeDuplicates(head);
        
        System.out.println("After remove duplicates from sorted doubly linked list is");
        printList(head);
     
    }
}
