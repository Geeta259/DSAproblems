import java.util.*;

class BalancedParanthesis
{
    public static boolean isBalanced(String x)
    {
        // add your code here
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<x.length();i++)
        {
            if(x.charAt(i)=='(' || x.charAt(i)=='{' || x.charAt(i)=='[')
            st.push(x.charAt(i));
            else
            {
                if(st.isEmpty())
                return false;
                
                if(x.charAt(i)==')' && st.peek()!='(')
                return false;
                else if(x.charAt(i)=='}' && st.peek()!='{')
                return false;
                else if(x.charAt(i)==']' && st.peek()!='[')
                return false;
                else
                st.pop();
            }
            
        }
        
        if(st.isEmpty())
        return true;
        else
        return false;
        
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a parenthesis String");
        String str = sc.nextLine();


      
        boolean check = isBalanced(str);
        if(check)
        System.out.println("Given string is balanced");
        else
        System.out.println("Given string is not balanced");
        
        sc.close();
    }
}