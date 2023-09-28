/*
Largest odd number in string

Input: s = "504"
Output: "5"
Explanation: The only subtring "5" is odd number.
 */
import java.util.*;
class LargestOddString{
 

    public static String maxOdd(String s) {
        // code here

        //start from the ending of the string
        int n = s.length()-1;
        int i=n;

        //iterate through the string
        while(i>=0)
        {
            //if we get first odd no from the ending list return that substring which is maximum odd string 
           if(s.charAt(i)%2!=0)
           return s.substring(0,i+1);
           
            i--;
        }
        
        //if not found any odd no return null 
        return "";
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s = new String();
        System.out.println("Enter a any number");
        s = sc.nextLine();

       // System.out.println(s);

        sc.close();

        String ans = maxOdd(s);
        System.out.println("Maximum odd sub string  in a given string is "+ ans);
    }
}