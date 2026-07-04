/*
 * Implement Atoi
 * Your task  is to implement the function atoi. The function takes a string(str) as argument 
 * and converts it to an integer and returns it.
    using recursion solve this problem
 */
import java.util.*;

class FindATOI
{
   public static int findatoi(String str,int idx,int ans)
    {
        //terminate condition
        if(idx==str.length())
        return ans;
        
            //if it satisfy any one condition return -1 not coverted to integer
            if(str.charAt(idx)<'0' || str.charAt(idx)>'9' || (str.charAt(idx)=='-' && idx!=0))
            return -1;
            
            //convert current char to number
            int digit = str.charAt(idx)-'0';
            //append into answer
            ans=ans*10+digit;
            
            //call recursively for next index
            return findatoi(str,idx+1,ans);            
    }
    
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();
        
        int ans=0;

        //if first digit is '-' start from 1 index
        if(str.charAt(0)=='-')
        ans = findatoi(str,1,ans);
        //otherwise start  from 0 index
        else
        ans = findatoi(str,0,ans);
        
        //if string contains only digits and first char is '-' multiply given answer by -1
        if(ans!=-1 && str.charAt(0)=='-')
        ans*=-1;
        
        //print the ans
        System.out.println("Converted String to Integer "+ans);
    }
   

}