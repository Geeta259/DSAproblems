/*
 * Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number)
 *  which has the maximum sum and return its sum.
 * 
 * optimal approach is used kadane's algorithm
 * 1) first declare a max variable which store maximum sum till current index
 * 2) sum store total sum till current index
 * 3) if at any point sum < 0 update sum  equal 0 because we want maximize sum negative sum further give less sum than single element sum

 */

import java.util.*;

class findContiguousMaxSum
{

    public static long maxSubarraySum(int arr[], int n){
        
        // Your code here
        //used kadane's algorithm
        long sum=0;
        long max = Long.MIN_VALUE;
         
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
          
            if(sum>max)
           max=sum;
           
            //if sum at any point negative doesn't make any sense to forward because it will decrease the sum 
            if(sum<0)
            sum=0;
        }
       
      
        return max;
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

       
        sc.close();

        long res = maxSubarraySum(arr,n);
        System.out.println("Maximum subarray sum is " + res);
        
    }
}