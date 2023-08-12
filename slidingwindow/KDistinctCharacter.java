/*
 *Longest Substring with At Most K Distinct Characters

2
abbbbbbc
3

7 max length of atmost 3 distinct character
 */
import java.util.*;
class KDistinctCharacter
{
    public static int kDistinctChars(int k, String s) {
		// Write your code here
		       
        int max=-1;
        int i=0,j=0,distinct=0;
        
        //calculate freq of each character in subarray
        int freq[] = new int[26];
        
        while(i<=j && j<s.length())
        {
            char  ch = s.charAt(j);
            
            //if it comes first time in substring increment distinct by 1
            if(freq[ch-'a']==0)
            distinct++;
            
            //update freq of this character
            freq[ch-'a']++;
            
            //if distinct character greater than k  shrink window until distinct element less than or equal to k
            
            while(distinct > k)
            {
                //freq decrement by 1 after remove character from beginning
                freq[s.charAt(i)-'a']--;
                
                //if freq of that character becomes 0 means one distinct character remove decrement distinct variable
                if(freq[s.charAt(i)-'a']==0)
                distinct--;
                
                //increment ith index
                i++;
            }
         
            //all substring of any length is valid if distinct character less than or equal to k it is valid substring get length update max and increment jth index
            max = Math.max(max,j-i+1);
            
            j++;
        }
        
        //return max 
        return max;
	}
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string in lowercase");
        String str = sc.nextLine();
         System.out.println("Enter a maximum no of distinct character in substring");
        int k = sc.nextInt();

        sc.close();
        
        int max = kDistinctChars(k,str);
        System.out.println("Maximum length of longest valid substring is "+ max);

    }
}