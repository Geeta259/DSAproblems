/*
 * Remove Outermost Parentheses

 Input: s = "(()())(())"
Output: "()()()"

(()()) one valid string (()) another valid string after remove outer parenthesis is
()()()  that is ans 
 */
import java.util.*;
class RmvOuterParen{
    public static String removeOuterParentheses(String s) {

        //create a new object of string builder class to append a string
        StringBuilder sb = new StringBuilder();

        int start=0,count=0;

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            count++;
            else
            count--;

            if(count==0)
            {
                //valid string found add into sb but not include outer parenthesis 
                sb.append(s.substring(start+1,i));

                //start update for next valid substring
                start=i+1;
            }
        }

        return sb.toString();
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s = new String();
        System.out.println("Enter a multiple valid parenthesis together");
        s = sc.nextLine();

       // System.out.println(s);

        sc.close();

        String ans = removeOuterParentheses(s);
        System.out.println("Valid parenthesis after remove outer parenthesis of each valid string is "+ ans);
    }
}