/*
Maximum Nesting Depth of the Parentheses

Input: s = "(1+(2*3)+((8)/4))+1"
Output: 3
Explanation: Digit 8 is inside of 3 nested parentheses in the string.

 */
import java.util.*;
class MaxNestingDepth
{
  
    public static int maxDepth(String s) {

        //stack used to store {} braces
        Stack<Character> st = new Stack<>();
        int count=0,maxcount=0;
        
        for(int i=0;i<s.length();i++)
        {
            //if open braces found count incremment
            if(s.charAt(i)=='(')
            {
                st.push('(');
                count++;
                
                //if count at any point greater than maxcount open braces update maxcount
                if(count>maxcount)
                maxcount=count;
            }

            //if close braces found decrement count by one    
            else if(s.charAt(i)==')')
            {
                count--;
            }
            else
            continue;
            
        }
        
        //return maxdepth 
        return maxcount;
        
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String  str = sc.nextLine();
      
        sc.close();

        int maxdepth = maxDepth(str);
        System.out.println("Maximum nesting depth of parenthesis is  " + maxdepth);
    }
}