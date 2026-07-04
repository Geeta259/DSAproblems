/*
Prefix to Infix
*/
import java.util.*;
class PrefixToInfix
{
    static String preToIn(String pre_exp) {
        // code here
        
        //create infix string
        String infix="";
        
        //create stack to push operand
        Stack<String> st = new Stack<>();
        
        //traverse from right to left
        for(int i=pre_exp.length()-1;i>=0;i--)
        {
            //get current character from prefix expression
            char ch = pre_exp.charAt(i);
            
            //if current character is operator
            if(ch=='+' || ch=='-' || ch=='/' || ch=='*' || ch=='^')
            {
                //take two operand from stack
                String first = st.pop();
                String second = st.pop();
                
                //make infix expression of two operand with current operator
                infix = "("+first+ch+second+")";
                
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
        System.out.println("Enter a prefix expression");
        String prefix = sc.nextLine();
        sc.close();
        String infix = preToIn(prefix);
        System.out.println("Infix Expression of given prefix is "+infix);
    }
}