/*
Prefix to postfix
*/
import java.util.*;
class PostfixToPrefix
{
    static String postToPre(String post_exp) {
        
        //create a stack which used to store prefix expression
       Stack<String> st = new Stack<>();
       
       //evaluate from left to right
       for(int i=0;i<post_exp.length();i++)
       {
           //get current character
           char ch = post_exp.charAt(i);
           
           //check if it is opeartor
           if(ch=='*' || ch=='/' || ch=='^' || ch=='+' || ch=='-')
           {
               //pop out two operands from stack
               String first = st.pop();
               String second  = st.pop();
               
               //make prefix expression and push into stack
               st.push(ch+second+first);
           }
           //otehrwise just push into stack
           else
           st.push(Character.toString(ch));
       }
       
       //last expression in stack is resultant prefix expression
       return st.pop();
   }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a postfix expression");
        String postfix = sc.nextLine();
        sc.close();
        String prefix = postToPre(postfix);
        System.out.println("Prefix Expression of given postfix is "+prefix);
    }
}