/*
 * Find XOR of numbers from L to R.
 * Input: 
L = 4, R = 8 
Output:
8 
Explanation:
4 ^ 5 ^ 6 ^ 7 ^ 8 = 8
 */

import java.util.*;

class FindXORInRange
{ 
    public static int findXOR(int l, int r) {
        //first find xor from  1 to r
        
        //if write xor from1 to r get a repetitive pattern after 4 numbers
        
        //check remainder of 4
        
        int xorr=0;
    
        if(r%4==0)
        xorr=r;
        
        else if(r%4==1)
        xorr=1;
        
        else if(r%4==2)
        xorr=r+1;
        
        else if(r%4==3)
        xorr=0;
       
       
       //find xor of  1  to l-1
       
       int xorl=0;
        
        if((l-1)%4==0)
        xorl=l-1;
        
        
        else if((l-1)%4==1)
        xorl=1;
        
        else if((l-1)%4==2)
        xorl=l;
            
        else if((l-1)%4==3)
        xorl=0;
        
        //get xor of upto r and xor upto l 
        //if xor opt between them get l to r xor  opt
        
        return xorr ^ xorl;  
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a starting value");
        int start = sc.nextInt();

        System.out.println("Enter a ending value");
        int end = sc.nextInt();

        sc.close();

        int ans = findXOR(start,end);
        System.out.println("XOR operation from " + start + " to " + end + " is " + ans );
       

    }
}