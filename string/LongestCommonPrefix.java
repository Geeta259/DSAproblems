/*
Longest Common Prefix in an Array
Given a array of N strings, find the longest common prefix among all strings present in the array.
Input:
N = 4
arr[] = {geeksforgeeks, geeks, geek,
         geezer}
Output: gee
Explanation: "gee" is the longest common
prefix in all the given strings.

 */
import java.util.*;
class LongestCommonPrefix{
 
    public static String getLongestCommon(String find , String max)
    {
        String ans="";
     
        //check find string present in maximum length string or not
        for(int i=0,j=0;i<max.length() && j<find.length();)
        {
            //if first character match store into ans and increment both if not match then break
            if(find.charAt(j)==max.charAt(i))
            {
                ans+=find.charAt(j);
                j++;
                i++;
            }else
            {
                break;
            }
        }

        //return common prefix string
        
        return ans;
    }
    
    public static String longestCommonPrefix(String arr[], int n){
        // code here
       //find maximum length of string in an array
       String ans="";
       
       //find maximum length of string  stored in another string
       for(int i=0;i<n;i++)
       {
           if(ans.length()<arr[i].length())
           ans=arr[i]; 
       }
       

       //find longest prefix string by iterate through string array
       for(int i=0;i<n;i++)
       {  ans = getLongestCommon(arr[i],ans); }
       
       if(ans=="")
       return "-1";
       else
       return ans;
       
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of string array");
         int  n = sc.nextInt();

        String s[] = new String[n];

        System.out.println("Enter a "+ n + "string");
        for(int i=0;i<s.length;i++)
        {
            s[i] = sc.nextLine();
        }
   
        sc.close();

        String ans = longestCommonPrefix(s,n);
        System.out.println("Longest common prefix in an array is "+ ans);
    }
}