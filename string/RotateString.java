/*

Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
A shift on s consists of moving the leftmost character of s to the rightmost position.
For example, if s = "abcde", then it will be "bcdea" after one shift.

Input: s = "abcde", goal = "cdeab"
Output: true

Approach
concate main string with  same string
abcdeabcde
now it contain all possible rotated string

check s2 string contain in main string or not
if not then it is not rotated string
 
 */
import java.util.*;
class RotateString{
    
    public static boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())
       return false;
       
       //if concat string s1 to s1 it will contain all possible rotations
       s+=s;
       
       //if main string contain goal string as a substrinng means it is rotated one
       if(s.contains(goal))
       return true;
       else
       return false;
       
   }
   
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a first string");
        String  str1 = sc.nextLine();
        System.out.println("Enter a second string to check rotation of first string");
        String  str2 = sc.nextLine();

        sc.close();

        boolean ans = rotateString(str1,str2);
        System.out.println(str2+" is rotation of "+ str1  +" ? " + ans);
    }
}