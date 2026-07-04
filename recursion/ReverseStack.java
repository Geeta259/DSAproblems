/*
 * Reverse a Stack
 * Input:
St = {3,2,1,7,6}
Output:
{6,7,1,2,3}


 */
import java.util.*;

class ReverseStack
{
    static void insertBottom(Stack<Integer> s,int elem)
    {
        //if stack is empty push element into stack
        if(s.isEmpty())
        s.push(elem);
        
        else
        {
            //pop out element from stack and call for remaining element 
            int temp = s.pop();
            insertBottom(s,elem);
            //if element inserted at bottom of stack pop out elements from stack in each recursive call push back into stack
            s.push(temp);
        }
    }
    static void reverse(Stack<Integer> s)
    {
          //pop all element from stack recursively one by one until stack not empty
        if(!s.isEmpty())
        {
            //store pop element into temp variable in each recursive call
            int temp = s.pop();

            //call for remaining element in to stack
            reverse(s);

            //insert pop out element from stack in each recursive call add  to bottom of stack
            insertBottom(s,temp);
        }
        
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

        reverse(st);

        System.out.println("Stack elements in a reverse order is");

        System.out.print(st);
        
    }
   

}