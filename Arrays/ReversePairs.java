/*Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

0 <= i < j < nums.length and
nums[i] > 2 * nums[j].

Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1

Approach 
using merge sort

first count pair by split into left and right part
then merge into ascending order

 */

import java.util.*;

class ReversePairs
{
    
    public static int mergeSort(int nums[],int s, int e)
    {
        int count=0;
        int m = (s+e)/2; 
        if(e>s)
        {
            count+= mergeSort(nums,s,m);
            count+= mergeSort(nums,m+1,e);
            count+= merge(nums,s,m,e);
        }
        return count;
    }

    public static int merge(int nums[],int s,int m,int e)
    {
        int n = e-s+1;
        int temp[] = new int[n];
        int left = s;
        int right = m+1;
        //count reverse pair
        int j=right;
        int count=0;
        for(int i=s;i<=m;i++)
        {
            //for each i not checking from starting j value because if left part of array at index i element greater than 2*nums[j] than after i+1 all are satisfied this condition because it is sorted way 
            while(j<=e && nums[i]> ((long)2 * nums[j]))
            j++;

            //how many elements in a right part of array before index j they all are satisfied given condition for each index i
            count+= (j-(m+1));
        }

        //merge into another temp array in sorted way
        int idx=0;
        while(left<=m && right<=e && idx<n)
        {
            if(nums[left]<=nums[right])
            temp[idx++]=nums[left++];
            else
            temp[idx++]=nums[right++];
        }

        while(left<=m && idx<n)
         temp[idx++]=nums[left++];

         while(right<=e && idx<n)
          temp[idx++]=nums[right++];

          //temp array element store into original array
          for(int i=s;i<=e;i++)
          nums[i] = temp[i-s];

          return count;

    }
    public static int rvrsPair(int[] nums) {
        int count=0;
        count = mergeSort(nums,0,nums.length-1);
        return count;
    }

    public static void main(String ar[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
       System.out.println("Enter elements in an array");
        for(int i=0;i<n;i++)
         arr[i] = sc.nextInt();
    
        
        sc.close();

       int res = rvrsPair(arr);

       System.out.print("Total Reverse Pair is "+res);
       
  
    }
}