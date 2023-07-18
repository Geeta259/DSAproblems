/*Find pairs with given sum in doubly linked list
Input:  
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
target = 7
Output: (1, 6), (2,5)
Explanation: We can see that there are two pairs 
(1, 6) and (2,5) with sum 7.
 * 
 */
import java.util.*;

class findPairsSumDLL{

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


    public static ArrayList<ArrayList<Integer>> findPairsSum(int target, DLNode head) {
        // code here
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        
        //go to the last node
        DLNode temp = head;
        while(temp.next!=null)
        {
            temp = temp.next;
        }
        
        DLNode lastnode = temp;
        
        //temp point to the starting node and lastnode point to the last node
        //because list is sorted we can use two pointer approach here
        temp = head;
        
        while(temp.val<lastnode.val)
        {
            //if first and last node value sum less than target to increase the num starting node move to the next node
            if((temp.val + lastnode.val) < target)
            {
                temp=temp.next;
            }
            //if first and last node value sum more than target to decrease the num last node move to the previous node
            else if(temp.val + lastnode.val > target)
            {
                lastnode = lastnode.prev;
            }
            else
            {
                //if their sum equal add  into list and starting node move to the next node and lastnode move to the previous node
                arr.add(new ArrayList<Integer>(Arrays.asList(temp.val,lastnode.val)));
                temp=temp.next;
                lastnode=lastnode.prev;
            }
        }
        
        return arr;
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
      
        System.out.println("\nEnter target sum");
        int target = sc.nextInt();

        sc.close();


        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr = findPairsSum(target,head);
     
        System.out.println("All pair in a double linked list with target sum ");
        System.out.println(arr);
     
    }
}
