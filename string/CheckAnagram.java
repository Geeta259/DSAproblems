/*
Anagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase
, typically using all the original letters exactly once.

Input: s = "anagram", t = "nagaram"
Output: true

frequency of each character in both string is same

Input: s = "rat", t = "car"
Output: false

frequency of each character in both string not same

 */
import java.util.*;
class CheckAnagram{
 
    public static boolean isAnagram(String s, String t) {

        //if both string length not equal means frequency not equal not anagram
         if(s.length()!=t.length())
         return false;
         
         HashMap<Character,Integer> map = new HashMap<Character,Integer>();
         
         //store frequency of each character in a map
         for(int i=0;i<s.length();i++)
         map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
         
         //traverse through second string
         for(int i=0;i<t.length();i++)
         {
             //if any character found which is not present in a map
             //means not anagram return false
             if(!map.containsKey(t.charAt(i)))
             return false;
             //if character found which value in map zero not equal frequency of  that character in both string
             else if(map.get(t.charAt(i))==0)
             return false;

             //otherwise deecrement frequency by one 
             else
             map.put(t.charAt(i),map.get(t.charAt(i))-1);
         }
        
        //if all character frequency same in both arrays return true
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

       boolean ans = isAnagram(str1,str2);
        System.out.println("Both string is Anagram ? "+ ans);
    }
}