/*
 * Division without using multiplication, division and mod operator
 * Given two integers dividend and divisor. Find the quotient after dividing dividend by divisor
 *  without using multiplication, division and mod operator.
 * 
 * Input:
a = 10, b= 3
Output: 3
Exaplanation:
10/3 gives quotient as 3 
and remainder as 1.


Approach : 

1) store sign of resultant quotient
2) make both dividend & divisor positive
3) traverse through 32 bit find where vallue smaller than dividend
4) store current value of multiplication and quotient
 */

import java.util.*;

class DivisionUsingBit
{ 
    public static long divide(long a, long b)
    {
        //code here
        //use bit wise opeartor
        
        //check sign of both if any one is negative resultant ans must  be negative
        int sign = ((a<0) ^ (b<0))?-1:1;

        //after store sign make it positive both
        a = Math.abs(a);
        b = Math.abs(b);
        
        //temp store result of multiply value
        long temp = 0;
        long quotient =0;
        //to represent number from -10^9 to 10^9 need 32 bits
        
        //get highest number when we mutliply (power of 2) with divisor give smallest value then dividend
        
        for(int i=31;i>=0;i--)
        {
            //check previous added value till now and add b*2^i if it give value less than dividend can add 
            //into temp value and store 2^i into quotient
            
            if(temp + (b<<i) <= a)
            {
                temp+=(b<<i);
                quotient+=(1<<i);
            }
        }
        
        //return quotient with sign
        return sign*quotient;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a dividend");
        long dividend = sc.nextLong();

        System.out.println("Enter a divisor");
        long divisor = sc.nextLong();

        sc.close();

        long quotient  = divide(dividend,divisor);
        System.out.println("Quotient of given divide numbers is " + quotient);
       

    }
}