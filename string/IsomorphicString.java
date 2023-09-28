/*
. Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while 
preserving the order of characters. No two characters may map to the same character,
 but a character may map to itself.

 Input: s = "egg", t = "add"
Output: true

e---a
g---d
g---d

pair with same value every time

 */
import java.util.*;
class IsomorphicString{
 
    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
        return false;

        ///first create a map to store key value pair
        HashMap<Character,Character> map = new HashMap<>();

        //this map check pair value if it is pair with different character before than cannot be pair with another character
        HashMap<Character,Integer> pair = new HashMap<>();

        for(int i=0,j=0;i<s.length() && j<t.length();i++,j++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                //if it contain in a map must be pair with same value
                if(!map.get(s.charAt(i)).equals(t.charAt(j)))
                return false;
            }

            
        //check  pair value if it's already paired with another character or not'

            else if(pair.containsKey(t.charAt(j)))
            //if it paired before return false
            return false;

            else
            {
                //different pair
                map.put(s.charAt(i),t.charAt(j));
                pair.put(t.charAt(j),1);
            }
        }
        return true;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a first string");
        String  str1 = sc.nextLine();
        System.out.println("Enter a second string");
        String  str2 = sc.nextLine();

        sc.close();

        boolean ans = isIsomorphic(str1,str2);
        System.out.println("Two string is Isomorphic Strings ? "+ ans);
    }
}