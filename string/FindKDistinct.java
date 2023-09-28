/*

Count number of substrings
Input:
S = "aba", K = 2
Output:
3
Explanation:
The substrings are:
"ab", "ba" and "aba".

only 2 distinct character present in a substring
 */
import java.util.*;
class FindKDistinct
{

    public static long findDistinct(String s,int k)
    {
        //use sliding window to find k distinct element
        int n =s.length();
        //starting of window
        int i=0;
        //ending of window
        int j=0;
        
        long ans=0;
        int dist_char=0;
        
        //to store frequency of  each  character (integer array)
        int countcharfreq[] = new int[26];
        
        while(j<n)
        {
            //get character of index j
          //  int idx = s.charAt(j)-97;
            
            char ch = s.charAt(j);
            
           // System.out.print(idx+" ");
            //frequency update in array
            //index represent character ascii value of lowercase alphabets start from 97
            //0 index represent 'a' 1 index represent 'b' and so on..
            countcharfreq[ch-97]++;
            
            //after increment frequency of current character is 1 means it is distinct character 
            if(countcharfreq[ch-97]==1)
            dist_char++;
            
            //decreasing size of window until distinct character if it greater than k
            while(dist_char > k)
            {
                //remove from start of the beginning
                  //get character of index i
                    char start = s.charAt(i);
                  countcharfreq[start-97]--;
                  
                     //after decrement frequency of current character is 0 means one distinct character removed
                    if(countcharfreq[start-97]==0)
                    dist_char--;
                
                    i++;
            }
           
            //current window of at most k distinct element
            ans+= j-i+1;
            j++;
        }
        
        return ans;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String s = sc.nextLine();

        System.out.println("Enter no of distinct character present in each substring");
        int k = sc.nextInt();
      
        sc.close();

        //approach used to find exactly k distinct element 
        //first calculate at most k distinct element subarry minus at most k-1 distinct element to get eaxctly k distinct element subarray
        long  ans = findDistinct(s,k) - findDistinct(s,k-1);
        System.out.println("No of having K distinct character sub string is  " + ans);
    }
}