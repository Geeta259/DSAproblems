/*
 * Two Numbers With Odd OccurrencesProblem statement
You are given an array 'arr' of size 'n'.  It contains an even number of occurrences for all numbers except two numbers.
Find those two numbers which have odd occurrences and return in decreasing order.
Example:
For 'arr' = {2, 4, 1, 3, 2, 4} , 'n' = 6.
Answer is {3, 1}.
Here, numbers 1, 3 have occurrence 1 i.e. odd and numbers 2, 4 have occurrence 2 i.e. even.
 */

import java.util.*;

class CountTwoOccurrence
{ 
    public static int[] twoOddNum(int []arr){
        // Write your code here.
        //first do xor of all elements
        long xor=0;
        for(int i=0;i<arr.length;i++)
        xor^=arr[i];

        //check right most set bit of xor  and get definitely atleast one bit is different because two  unique  distinct  no  are present

        //get a binary in which only  right  most set bit present and restare zero
        xor = (xor & (xor-1)) ^ xor;    //get a only rightmoset bit are set

        int b1=0,b2=0;  //create two  bucket for catgeorized value based on rightmost bit are set or not

        for(int i=0;i<arr.length;i++)
        {
            if((arr[i] & xor )!=0)      //means rightmost  bit  position  are set  of  arr[i] go to  b1 bucket
            b1^=arr[i];
            else
            b2^=arr[i]; //otherwise rightmost bit  position are unset of  arr[i] go  to  b2 bucket
        }

        int[] ans = new int[2];
        ans[0]=b1>b2?b1:b2;
        ans[1]=b1<b2?b1:b2;

            //return in decreasing order
        return ans;

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of array");
        int n  = sc.nextInt();

        System.out.println("Enter a value of an array");
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        sc.close();

       int[]  ans =   twoOddNum(arr);
        System.out.println("Two  single elements are " + ans[0] + " "+ ans[1]);
       

    }
}