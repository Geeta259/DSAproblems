import java.util.*;

import javax.xml.stream.events.StartDocument;
class StackWith2Queue
{
    public static Queue<Integer> q1 = new LinkedList<>();
     public static Queue<Integer> q2 = new LinkedList<>();
    
    public static void push(int x) {
        q2.add(x);

        //if q1 has elements
        while(!q1.isEmpty())
        q2.add(q1.poll());
        

        //pop out all elements from q2 to q1
        while(!q2.isEmpty())
        q1.add(q2.poll());


        /*
         * for use single queue
         * //add new element into queue
         *  que.add(x);

            //all elemnets before the new element placed after that element 
            int size = que.size()-1;
            while(size!=0)
            {
                //remove element from first add again back to last
            int elm =  que.poll();
            size--;
            que.add(elm);
            }  
         */
    }
    
    public static int pop() {
        return q1.poll();
    }
    
    public static int top() {
      return q1.peek();   
    }
    
    public static boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice what you want to perform in stack");
      
        int opt=0;
        do
        {
              System.out.println("1 for push\n2 for pop\n3 for top\n4 for check empty or not");
             int ch = sc.nextInt();
            switch(ch)
             {
                    case 1:
                    {
                        System.out.println("Enter element which you want to  push in stack");
                        int num = sc.nextInt();
                        push(num);
                        break;
                    }
                    case 2:
                    System.out.println("Popped element is " + pop());
                    break;

                    case 3:
                    System.out.println("Top element is " + top());
                    break;

                    case 4:
                    {
                        if(empty())
                        System.out.println("Stack is empty");
                        else 
                        System.out.println("Stack is not empty");

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