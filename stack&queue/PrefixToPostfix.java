/*
Prefix to postfix
*/
import java.util.*;
class PrefixToPostfix
{
    static String preToPost(String pre_exp) {
        
        //create a postfix expression
        Stack<String> st = new Stack<>();
        
        for(int i=pre_exp.length()-1;i>=0;i--)
        {
            //get current character
            char ch = pre_exp.charAt(i);
            
            //check if it is opeartor
            if(ch=='*' || ch=='/' || ch=='^' || ch=='+' || ch=='-')
            {
                //pop out two operands from stack
                String first = st.pop();
                String second  = st.pop();
                
                //make postfix expression and push into stack
                st.push(first+second+ch);
            }
            //otehrwise just push into stack
            else
            st.push(Character.toString(ch));
        }
        
        //last expression in stack is resultant postfix expression
        return st.pop();
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a prefix expression");
        String prefix = sc.nextLine();
        sc.close();
        String postfix = preToPost(prefix);
        System.out.println("Postfix Expression of given prefix is "+postfix);
    }
}