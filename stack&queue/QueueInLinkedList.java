import java.util.*;

class QueueNode
{
    int data;
    QueueNode next;

    QueueNode(int data){
        this.data = data;
        this.next = null;
    }
}
class QueueInLinkedList
{
    public static QueueNode front, rear;
    
    //Function to enqueue an element into the queue.
	public static void enqueue(int a)
	{
        //create a new node with value a
        QueueNode newnode = new QueueNode(a);
        
        //if there is no node in list
        if(front==null)
        {
            //make it as  a rear and front node
            rear = newnode;
            front = newnode;
        }
        else
        {
            //otherwise  linked with rear next and update rear node which indicate last node
            rear.next = newnode;
            rear = newnode;
        }
        
	}
	
    //Function to dequeue front element from the queue.
	public static int dequeue()
	{
        // Your code here
        
        //if front null means no node exist in list return -1
        if(front==null)
        return -1;
        
        //get data of front data
        int data = front.data;
        

        //update front to next element in list and return data
        front = front.next;
        
        return data;
	}
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice what you want to perform in queue");
      
        int opt=0;
        do
        {
              System.out.println("1 for enqueue\n2 for deequeue");
             int ch = sc.nextInt();
            switch(ch)
             {
                    case 1:
                    {
                        System.out.println("Enter element which you want to enqueue in linked list");
                        int num = sc.nextInt();
                        enqueue(num);
                        break;
                    }
                    case 2:
                    System.out.println("dequeue element from linked list " + dequeue());
                    break;

                    default:
                    System.out.println("Invalid choice");
                    break;
                }

                System.out.println("Want to continue? if no press -1 else press any");
                opt = sc.nextInt();

        }while(opt!=-1);
      
        sc.close();
    }
}