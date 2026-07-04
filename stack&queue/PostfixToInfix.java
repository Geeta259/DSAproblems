/*
Postfix to Infix
*/
import java.util.*;
class PostfixToInfix
{
    public static String poToIn(String exp) {
     
        //create infix string
        String infix="";
        
        //create stack to push operand
        Stack<String> st = new Stack<>();
        
        //traverse from left to right
        for(int i=0;i<exp.length();i++)
        {
            //get current character from prefix expression
            char ch = exp.charAt(i);
            
            //if current character is operator
            if(ch=='+' || ch=='-' || ch=='/' || ch=='*' || ch=='^')
            {
                //take two operand from stack
                String first = st.pop();
                String second = st.pop();
                
                //make infix expression of two operand with current operator
                infix = "("+second+ch+first+")";
                
                //then push infix expression into stack
                st.push(infix);
            }
            else
            {
                //if it opearand push into stack
                st.push(Character.toString(ch));
            }
        }
        
        
        //infix expression pop out from stack
      
        return st.pop();
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a postfix expression");
        String postfix = sc.nextLine();
        sc.close();
        String infix = poToIn(postfix);
        System.out.println("Infix Expression of given postfix is "+infix);
    }
}