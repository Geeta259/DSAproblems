/*
 Generate all binary strings
 Given an integer N , Print all binary strings of size N which do not contain consecutive 1s.

A binary string is that string which contains only 0 and 1.

In this N constraints is small so brute force can be applied solved by recursion

Example 1:

Input:
N = 3
Output:
000 , 001 , 010 , 100 , 101
Explanation:
None of the above strings contain consecutive 1s. "110" is not an answer as it has '1's occuring consecutively. 

 */
import java.util.*;

import javax.print.attribute.SetOfIntegerSyntax;

class BinaryStringNoCons1
{
    public static void findAllBinaryString(int n, List<String> res , int i, String str)
    {
        //if no of digits of string equal to n add string into list and return
        if(i==n)
        {
            res.add(str);
            return;
        }

        //store last digits of string 
        
        char ch = str.charAt(str.length()-1);
    
        //if last digit of string is 0 two possibilities occur either can add 0 or 1
        if(ch=='0')
        {
            //first store current string into temp variable
             String temp = str;
                
             //recursive call by  append 0 into string and increment digit by 1 
           findAllBinaryString(n,res,i+1,str+='0');
            
           //back original string for appned 1 
            str = temp;
            
               //recursive call by  append 1 into string and increment digit by 1 
            findAllBinaryString(n,res,i+1,str+='1');
        }
        else
        //if last digit is 1 only one possibilities 0 will be append into string after 1 because no consecutive 1's allowed
        findAllBinaryString(n,res,i+1,str+='0');
    }

    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of digit of binary string you want to generate");
        int n = sc.nextInt();
       
        sc.close();
        List<String> list = new ArrayList<>();

        //generate all valid binary string start from 0 & add into list
        findAllBinaryString(n,list,1,"0");

         //generate all valid binary string start from 1 & add into list
         findAllBinaryString(n,list,1,"1");

        System.out.println("All possible valid binary string with no consecutive 1's is");
        System.out.println(list);
    }
   

}