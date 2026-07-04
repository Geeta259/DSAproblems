/*
 * You are given two numbers A and B. The task is to count the number of bits needed to be flipped to convert A to B.
Input: A = 10, B = 20
Output: 4
Explanation:
A  = 01010
B  = 10100
As we can see, the bits of A that need 
to be flipped are 01010. If we flip 
these bits, we get 10100, which is B.
 */

import java.util.*;

class CountNoOfFlip
{ 
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a first number");
        int a = sc.nextInt();

        System.out.println("Enter a second number");
        int b = sc.nextInt();

        sc.close();

        int count=0;
        
        for(int i=0;i<32;i++)
        {
            //check ith bit in both a & b
            //if both same no need to flip
            //if not flip a bits
            if(((a & (1<<i))==0 && (b & (1<<i))!=0)  || ((a & (1<<i))!=0 && (b & (1<<i))==0))
            {
                //count no of flip
               count++;
            }
            
        }
        System.out.println("No of flip in bits to convert A to B is " + count );
       

    }
}