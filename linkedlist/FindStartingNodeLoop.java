/*
Find the first node of loop in linked list
Given a singly linked list of N nodes. Find the first node of the loop if the linked list has a loop. 
If a loop is present 
return the node data of the first node of the loop else return -1.
 */
import java.util.*;

class FindStartingNodeLoop{

    public static Node create(int ar[], int loop)
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

        //if loop value not 0 means last node linked  with any other node linked last node with given position node
        if(loop!=0)
        {
            Node lastnode = temp;
          
            temp = head;
            int count=1;
            //go to that position and linked with last node
            while(temp!=null)
            {
                if(count==loop)
                {
                    lastnode.next = temp;
                    break;
                }
                count++;
                temp=temp.next;
            }
            

        }

        return head;
    }

   
    public static int findfirstnodeloop(Node head){
        // Add code here
        //if only single node present or blank list no loop exist return
        if(head==null || head.next==null)
        return -1;
        
        //by using two pointer slow and fast pointer
        Node slow=head;
        Node fast=head;
        
        while(fast!=null && fast.next!=null)
        {
            
            slow=slow.next;
            fast=fast.next.next;
            
            //if at any point slow and fast node met means loop exist
            if(slow==fast)
            break;
        }

          //if loop exist
        //distance  from first node to loop first node is equal to distance from collide point to
        //  loop first node
        //make any one node slow or fast intilaize with head node or new node intialize

        if(slow!=fast)
        return -1;
        
        Node temp = head;         
        while(slow!=temp)
        {
            //both nodes traverse by one 
            slow=slow.next;
            temp=temp.next;
        }
        
        //slow and temp node met with first node of loop
        
        return slow.val;

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

       System.out.println("Enter position in which last node is linked if not linked with any node enter 0");
       int loop = sc.nextInt();
       sc.close();
   
       Node head = create(val,loop);

      int begnode = findfirstnodeloop(head);
      if(begnode==-1)
      System.out.println("No loop exist");
      else
      System.out.println("\nBeginning value of loop in a list is "+ begnode);

    }
}
