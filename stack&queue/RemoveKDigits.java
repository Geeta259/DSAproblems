/*
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer
 after removing k digits from num.
*/
import java.util.*;

class RemoveKDigits
{
    public static String removeK(String num, int k) {
        
        //if string length equal to k all character remove return 0
        if(num.length() == k)
        return "0";

        //use stack to track prev maximum number so that we can remove it
        Stack<Character> st = new Stack<>();

        //traverse through array
        for(int i=0;i<num.length();i++)
        {
            //pop out element from stack if current element is less than peek    element
            //get a current character 
            char ch = num.charAt(i);
            while(!st.isEmpty() && ch < st.peek() && k!=0)
            {
                //remove all greatest element than current character
                st.pop();
                //decrement k
                k--;
            }

            //if stack is empty or not
            if(st.isEmpty())
            {
                //stack empty no leading zeros if it not zero push into stack
                if(ch!='0')
                st.push(ch);
            }
            //otherwise stack is not empty  push current character
            else
            st.push(ch);
        }


        //pop out all element from stack until k not 0
        while(!st.isEmpty() && k!=0)
        {st.pop(); k--;}

        //check if after removing all k elements if stack empty no element left return 0
        if(st.isEmpty())
        return "0";

        //resultant string
        StringBuilder res = new StringBuilder();
        //pop out all element from stack and append into stringbuilder
        while(!st.isEmpty())
        res.append(st.pop());

        //reverse resulatnt string
        return res.reverse().toString();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a  string of digits");
        String str = sc.nextLine();
        
        System.out.println("Enter number how many character you want to remove from string");
        int k = sc.nextInt();

        sc.close();
        String res = removeK(str,k);
        System.out.println("After remove k character from string resultant string is " + res);
      
    }
}