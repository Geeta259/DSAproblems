/*
Infix to Prefix
*/
import java.util.*;
class InfixToPrefix
{
        // Function to convert an infix expression to a postfix expression.
    public static String inToPre(String exp) {
        // Your code here
        
        //create a prefix string
        String prefix="";
        
        //create a stack to push & pop operand
        Stack<Character> st = new Stack<>();
        
        //traverse through expression from right to left to convert into prefix
        for(int i=exp.length()-1;i>=0;i--)
        {
            char ch = exp.charAt(i);
              
              //if character is closing bracket push into stack
            if(ch==')')
            st.push(ch);
            
            //if it close bracket and stack not empty
            else if(ch=='(' && !st.isEmpty())
            {
                //pop out all operator add into prefix expression till opening bracket not found
                while(st.peek()!=')')
                prefix+=st.pop();
                
                //closing bracket also pop out from stack but not add into expression
                st.pop();
            }
            
            //if it operator
            else if(ch=='^' || ch=='+' || ch=='-'  || ch=='*' || ch=='/')
            {
                //check precedence
            
                if(ch=='^')
                {
                     //push current opeartor into stack
                     st.push(ch);
                }
               
                
                else if(ch=='*' || ch=='/')
                {
                    //if current operator is * or / they have same precedence
                    //pop out opearators from stack until found low precedence than these operator
                    
                       while(!st.isEmpty() && st.peek()!=')' && st.peek()!='+' && st.peek()!='-' &&  st.peek()=='^' && st.peek()!='*' && st.peek()!='/')
                        prefix+=st.pop();
                        
                        //push current opeartor into stack
                        st.push(ch);
                }
                
               
                else if(ch=='+' || ch=='-')
                {
                     //if current operator is + or - they have least precedence
                    //pop out opearators from stack until not found closing bracket or stack empty
                    
                   
                     while(!st.isEmpty() && st.peek()!=')' &&  st.peek()!='+' && st.peek()!='-')
                        prefix+=st.pop();
                        
                        //push current operator into stack
                        st.push(ch);
                }
            }
            
            //if any operand found add into prefix expression
            else
            prefix+=ch;
        }
        
        //pop out all remaining operators from stack and add into prefix expression
        while(!st.isEmpty())
         prefix+=st.pop();
        
        //return postfix expression
        return prefix;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a infix expression");
        String infix = sc.nextLine();
        sc.close();
        String prefix = inToPre(infix);
        String revprefix ="";
        for(int i=prefix.length()-1;i>=0;i--)
        revprefix+=prefix.charAt(i);

        System.out.println("Prefix Expression of given infix is "+revprefix);
    }
}