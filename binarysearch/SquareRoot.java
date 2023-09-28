/*
Square root of a number
Given an integer x, find the square root of x. If x is not a perfect square, then return floor(√x).

Input:
x = 5
Output: 2
Explanation: Since, 5 is not a perfect 
square, floor of square_root of 5 is 2.

  */

import java.util.*;

class SquareRoot
{
     
    static long floorSqrt(long x)
    {
       // Your code here
       if(x==1)
       return 1;
       
       //defined search space to get square root which lies from 0 to x/2
       long low=0,high=x/2;

       while(low<=high)
       {
           long mid = (low+high)/2;
           //if square of current element greater than x minimimize element by going to left side
           if((mid*mid)<=x)
           low=mid+1;
           else

           //otherwise going to right side 
           high=mid-1;
           
       }
       
       return high;
    }

    public static void main(String args[])
    {
        System.out.println("Enter any number whom want to find sqrt function");
        Scanner sc =new Scanner(System.in);
        long n = sc.nextInt();

        sc.close();
     
        long res = floorSqrt(n);
        System.out.println("Nearest square root of given number "+ res);
        
    }
}