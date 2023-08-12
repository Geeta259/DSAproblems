import java.util.*;
class LongestSubString
{
    public static int lengthOfLongestSubstring(String s) {
        //hashmap store characters  to check whether character present in substring or not
        HashMap<Character,Integer> map = new HashMap<>();
 
         int max=0;
 
        //traverse through string using two pointer to get max substring length
        int l=0,r=0;
        while(l<s.length() && r<s.length())
        {
            char ch = s.charAt(r);
            //check current character is present in map or not
            if(map.containsKey(ch))
            {
                //if present in a map 
                //not valid substring 
                //remove characters from starting shrink window
                //remove characters from index l and increment l
                map.remove(s.charAt(l));
                l++;
 
            }else
            {
                //valid substring
                map.put(ch,1);
                 //update max
                 max = Math.max(max,r-l+1);
                 //expand window
                 r++;
            }
        }
 
         //max length of valid substring
        return max;
     }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();

        sc.close();
        
        int max = lengthOfLongestSubstring(str);
        System.out.println("Maximum length of longest substring is "+ max);

    }
}