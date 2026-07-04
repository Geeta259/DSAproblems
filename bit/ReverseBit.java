/*
 *  Reverse Bits
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * 0 index first bit shift into last bit which is 31 index
 * and so on...
 */

import java.util.*;

class ReverseBit
{ 
    public static int reverseBit(int n) {
        //create a mask
        int mask = 1,ans=0;
        //traverse through 32 bit
        for(int i=0;i<32;i++)
        {
            //check current ith bit is set or not
            if((mask & n)!=0)
            {
                //bit is 1 set into 32-i bit from left
                ans = ans | 1<<(31-i);
            }

            //shift mask by 1 to check next bit
            mask = mask<<1;
        }
        return ans;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
       System.out.println("Enter a integer number");
       int n = sc.nextInt();

       int revnum = reverseBit(n);
      
       System.out.println("Reverse number is " + revnum);
    }
}