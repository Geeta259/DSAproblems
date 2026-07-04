import java.util.*;

class StackNode
{
    int data;
    StackNode next;

    StackNode(int data){
        this.data = data;
        this.next = null;
    }
}
class StackInLinkedList
{
    static StackNode top;
    
    //Function to push an integer into the stack.
    public static void push(int a) 
    {
        //create a new node  with given value
        StackNode newnode = new StackNode(a);
       
            //placed at beginning
            newnode.next = top;
            
            //update top by new node
            top = newnode;    
        
        
    }
    
    //Function to remove an item from top of the stack.
    public static int pop() 
    {
        //check top is null or not
        
        if(top==null)
        return -1;
        
        //if not store top data and update top to next element 
        //removed node from beginning
        
        int data = top.data;
        //System.out.print(data+" ");
        
        top = top.next;
        return data;
        
    }
   
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice what you want to perform in stack");
      
        int opt=0;
        do
        {
              System.out.println("1 for push\n2 for pop");
             int ch = sc.nextInt();
            switch(ch)
             {
                    case 1:
                    {
                        System.out.println("Enter element which you want to push in linked list");
                        int num = sc.nextInt();
                        push(num);
                        break;
                    }
                    case 2:
                    System.out.println("pop element from linked list " + pop());
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