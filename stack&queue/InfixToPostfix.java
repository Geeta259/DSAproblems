/*
Infix to Postfix
*/
import java.util.*;
class InfixToPostfix
{
        // Function to convert an infix expression to a postfix expression.
    public static String inToPost(String exp) {
        // Your code here
        
        //create a postfix string
        String postfix="";
        
        //create a stack to push & pop operand
        Stack<Character> st = new Stack<>();
        
        //traverse through expression
        for(int i=0;i<exp.length();i++)
        {
            char ch = exp.charAt(i);
              
              //if character is opening bracket push into stack
            if(ch=='(')
            st.push(ch);
            
            //if it close bracket and stack not empty
            else if(ch==')' && !st.isEmpty())
            {
                //pop out all operator add into postfix expression until opening bracket not found
                while(st.peek()!='(')
                postfix+=st.pop();
                
                //opening bracket also pop out from stack but not add into expression
                st.pop();
            }
            
            //if it operator
            else if(ch=='^' || ch=='+' || ch=='-'  || ch=='*' || ch=='/')
            {
                //check precedence
            
                if(ch=='^')
                {
                    //check top of stack if it same precedence pop out from stack and add into expression
                    if(!st.isEmpty() && st.peek()=='^')
                    postfix+=st.pop();
                    
                    //push current opeartor into stack
                     st.push(ch);
                }
               
                
                else if(ch=='*' || ch=='/')
                {
                    //if current operator is * or / they have same precedence
                    //pop out opearators from stack until not found low precedence than these operator
                    
                       while(!st.isEmpty() && st.peek()!='+' && st.peek()!='-' && st.peek()!='(')
                        postfix+=st.pop();
                        
                        //push current opeartor into stack
                        st.push(ch);
                }
                
               
                else if(ch=='+' || ch=='-')
                {
                     //if current operator is + or - they have least precedence
                    //pop out opearators from stack until not found opening bracket or stack empty
                    
                   
                     while(!st.isEmpty() && st.peek()!='(')
                        postfix+=st.pop();
                        
                        //push current operator into stack
                        st.push(ch);
                }
            }
            
            //if any operand found add into postfix expression
            else
            postfix+=ch;
        }
        
        //pop out all remaining operators from stack and add into postfix expression
        while(!st.isEmpty())
         postfix+=st.pop();
        
        //return postfix expression
        return postfix;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a infix expression");
        String infix = sc.nextLine();
        sc.close();
        String postfix = inToPost(infix);
        System.out.println("Postfix Expression of given infix is "+postfix);
    }
}