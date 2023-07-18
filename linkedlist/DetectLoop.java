/*
Detect Loop in linked list
 */
import java.util.*;

class DetectLoop{

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

   
    public static boolean loopExist(Node head){
        // Add code here
        //by using two pointer slow and fast pointer
        Node slow=head;
        Node fast=head;
        
        while(fast!=null && fast.next!=null)
        {
            
            slow=slow.next;
            fast=fast.next.next;
            
            //if at any point slow and fast node met means loop exist
            if(slow==fast)
            return true;
            
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

       System.out.println("Enter position in which last node is linked if not linked with any node enter 0");
       int loop = sc.nextInt();
       sc.close();
   

       Node head = create(val,loop);
      // printList(head);



        if(loopExist(head))
        System.out.println("\nLoop  exist in a linked list ");
        else 
        System.out.println("\nLoop does not exist in a linked list ");
        

    }
}
