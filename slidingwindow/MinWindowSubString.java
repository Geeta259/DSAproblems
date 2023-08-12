/*
 *   Minimum Window Substring
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 */
import java.util.*;
class MinWindowSubString
{
    public static String minWindow(String s, String t) {

        //map create to store t string characters
        HashMap<Character,Integer> tmap = new HashMap<>();

        //store characters of tmap with frequency
        for(int i=0;i<t.length();i++)
        { tmap.put(t.charAt(i),tmap.getOrDefault(t.charAt(i),0)+1);}
      
        //length of t string
        int validchars = t.length();
        

        int i=0,j=0,min=Integer.MAX_VALUE,mini=-1,minj=-1,getvalid=0;

         //another map create to store s string character till index j
        HashMap<Character,Integer> smap = new HashMap<>();

        while(i<=j && j<s.length())
        {
            //get current character
            char  ch = s.charAt(j);

           //increment frequency of current character in smap
            smap.put(ch,smap.getOrDefault(ch,0)+1);

            //if current character present in tmap and it's freq does not exceed than actual freq it is valid character increment by 1
            if(tmap.containsKey(ch) && smap.get(ch) <= tmap.get(ch))
            getvalid++;

            //if all valid character found
            while(i<=j && getvalid == validchars)
            {
                //get length of substring and compare with minimum length
                if(j-i+1 < min)
                {
                    min = j-i+1;
                    mini=i;
                    minj=j;
                }

                //remove characters from head until all valid characters present in smap
                 smap.put(s.charAt(i),smap.get(s.charAt(i))-1);

                //if remove character is present in tmap and after remove its' freq less than actual freq a valid character remove getvalid decrement by 1
                if(tmap.containsKey(s.charAt(i)) && smap.get(s.charAt(i)) < tmap.get(s.charAt(i)))
                getvalid--;

               //increment i by 1
                i++;
            }

            //increment j by 1
            j++;
        }

        //if no substring found in which all valid char present return blank     
        if(mini==-1 && minj==-1)
        return "";
        //if minimum substring j index reach out of bound return from mini to last 
        else if(minj == s.length())
        return s.substring(mini);
        //else return substring from mini to minj
        else
        return s.substring(mini,minj+1);
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a first string");
        String s1 = sc.nextLine();

        System.out.println("Enter a second string which contain all required characters in substring");
        String s2 = sc.nextLine();

        sc.close();
        
        String ans = minWindow(s1,s2);
        System.out.println("Minimum substring which includes all required characters is " + ans);

    }
}