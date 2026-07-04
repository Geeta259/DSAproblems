/*
 * Given a stack, the task is to sort it such that the top of the stack has the greatest element.
 * Input:
Stack: 11 2 32 3 41
Output: 41 32 11 3 2
 */
import java.util.*;

class SortStack
{
    public static void  insertElement(Stack<Integer> s , int element)
    {
        //if stack is empty or top element of stack less than insert element push element in to stack
        if(s.isEmpty() || s.peek()<element)
        s.push(element);
        else 
        {
            //pop element from top one by  one recursively until smaller element found than insert element
            int temp = s.pop();
            insertElement(s,element);
            //after element push into stack in correct position remove element from stack in each recursively call push back into stack
            s.push(temp);
        } 
    }
    public static Stack<Integer> sort (Stack<Integer> s)
    {
        //if stack is not empty
        if(!s.isEmpty())
        {
            
            //first pop out top element from stack one by one recursively
            int temp  = s.pop();
            sort(s);
            //push pop out element from stack in correct position
            insertElement(s,temp);

        }
        return s;
    }
    
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a no of element you want to push in a stack");
        int n = sc.nextInt();

        Stack<Integer> st = new Stack<Integer>();

        System.out.println("Enter " + n + " elements for push into a stack");
        for(int i=0;i<n;i++)
        {
            st.push(sc.nextInt());
        }

        sc.close();

        st = sort(st);

        System.out.println("Sort stack elements in a order");
        while(!st.isEmpty())
        System.out.print(st.pop()+" ");
        
    }
   

}