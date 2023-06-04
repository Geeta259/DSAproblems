/*
3Sum Closest
Given an array A[] of N integers and an integer X. The task is to find the sum of three integers
 in A[] such that it is closest to X.

 Input:
N = 4
A[] = {-1 , 2, 1, -4}
X = 1
Output: 2
Explaination: 
Sums of triplets:
(-1) + 2 + 1 = 2
(-1) + 2 + (-4) = -3
2 + 1 + (-4) = -1
2 is closest to 1.
 */

import java.util.*;

class ThreeSumClosest
{
    static int closest3Sum(int A[], int N, int X)
    {
        // code here
        //sort given array from ascending to descending
        Arrays.sort(A);
        int mindiff=Integer.MAX_VALUE;
        int maxsum=0;
        
        for(int i=0;i<N-2;i++)
        {
            int j=i+1;
            int k=N-1;
            
            int sum=0;
            
            //use two pointer approach for each element in array
            while(j<k)
            {
                //get sum  of three integer
                sum=A[i]+A[j]+A[k];

                //if difference from x to sum is minimum than mindiff value means till now it is closest to x update mindiff value and max sum
                if((Math.abs(X-sum))<mindiff)
                {
                    mindiff=Math.abs(X-sum);
                    maxsum=sum;
                }
                
                
                //if sum greater than x decrement k pointer by one
                if(sum>X)
                k--;

                //if sum less than x increment j pointer by one 
                else
                j++;
                
               
            }
        }
        
        //return maxsum which is closest to x
        return maxsum;
    }

     public static void main(String ar[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

       System.out.println("Enter elements in an array");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        System.out.println("Enter number from which you want to get closest sum");
        int x = sc.nextInt();

        sc.close();

       
        int ans = closest3Sum(arr,n,x);
      
        System.out.println("The closest sum of three integers in a array is "+ans);
        
      
        
    }
}
   