import java.util.*;

class QueueWith2Stack
{
    
    //create two queue one for input & one for output
    public static Stack<Integer> input = new Stack<>();
    public static Stack<Integer> output = new Stack<>();

 
    public static  void enqueue(int x) {
        //enqueue elements into input queue with 0(1) complexity
       input.push(x);
    }
    
    public static int dequeue() {
        //dequeue elements from output queue but if output empty transfer all elements
        //from input queue to output queue

        //take 0(1) time 
         if(!output.isEmpty())
        return output.pop();
        else if(input.isEmpty())
        return -1;
        else
        {
            //if it is empty tramfer elements from input to  output with 0(n)
            while(!input.isEmpty())
            output.push(input.pop());

            return output.pop();
        }


    }
    
    public static  int peek() {
          //top elements from output queue but if output empty transfer all elements
        //from input queue to output queue

        //take 0(1) time 
         if(!output.isEmpty())
        return output.peek();
        else if(input.isEmpty())
        return -1;
        else
        {
            //if it is empty tramfer elements from input to  output with 0(n)
            while(!input.isEmpty())
            output.push(input.pop());

            return output.peek();
        }
    }
    
    public static boolean empty() {
      return output.isEmpty() && input.isEmpty() ;      
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice what you want to perform in queue");
      
        int opt=0;
        do
        {
              System.out.println("1 for enqueue\n2 for dequeue\n3 for top\n4 for check empty or not");
             int ch = sc.nextInt();
            switch(ch)
             {
                    case 1:
                    {
                        System.out.println("Enter element which you want to  enqueue");
                        int num = sc.nextInt();
                        enqueue(num);
                        break;
                    }
                    case 2:
                    System.out.println("dequeue element is " + dequeue());
                    break;

                    case 3:
                    System.out.println("Top element is " + peek());
                    break;

                    case 4:
                    {
                        if(empty())
                        System.out.println("queue is empty");
                        else 
                        System.out.println("queue is not empty");

                        break;
                    }
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