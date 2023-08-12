/*
 * Longest Repeating Character Replacement
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

 */
import java.util.*;
class LongestRepeatingCharacter
{
    public static int maxFreq(int freq[])
    {
        int max = 0;

        for(int i=0;i<26;i++)
        max = Math.max(max,freq[i]);

        return max;
    }

    public  static int characterReplacement(String s, int k) {
        //to replace at most k character in substring to get longest substring need maximum frequency till index 

        int freq[] = new int[26];

         //use two pointer to get max size of longest substring
        int i=0,j=0,ans=0;
        while(i<=j && j<s.length())
        {
            //get currentc character
            char ch = s.charAt(j);
            //update freq of that character in map
            freq[ch-'A']++;

            //find minimum characters have to replaced to get same letter substring
            //total length of substring minus max freq character
            int replace = j-i+1 - maxFreq(freq);
            if(replace > k)
            {
                //window shrink by one 
                freq[s.charAt(i)-'A']--;
                i++;
            }

            //get length of valid substring
            ans = Math.max(ans,j-i+1);
            //increment j by one
            j++;
        }

        //return max length of valid substring
        return ans;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string in uppercase");
        String str = sc.nextLine();
         System.out.println("Enter a maximum replacement no in substring");
        int k = sc.nextInt();

        sc.close();
        
        int max = characterReplacement(str,k);
        System.out.println("Maximum length of longest valid substring is "+ max);

    }
}