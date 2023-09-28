/*
Search in a Rotated Array
Given a sorted and rotated array A of N elements which is rotated at some point, and may contain 
duplicates and given an element key.
 Check whether the key exist in the array A or not.

 Input:
N = 19
1 1 1 1 1 1 1 1 1 1 1 1 1 2 1 1 1 1 1
key = 2
Output:
true


duplicate element exist

  */

import java.util.*;

class SearchRotatedArray
{
    
    public static boolean Search(int N, int[] nums, int target) {
        // code here
         int start =0 ;
         int end = nums.length-1;
         
         while(start<=end)
         {
             int mid = end-((end-start)/2);
             if(nums[mid]==target)
             return true;
             
             //find starting index which is not equal to mid 
             while(nums[start]==nums[mid] && start<mid)
             start++;
             
             //find ending index which is not equal to mid
             while(nums[end]==nums[mid] && end>mid)
             end--;
             
             if(nums[start]<=nums[mid])
             {
                 //check left part is sorted or not if yes check target value lies in left part if yes go to  left part
                 if(target>=nums[start] && target<nums[mid])
                 end=mid-1;
                 else
                 //if not go to right part
                 start=mid+1;
                 
             }else
             {
                 //if right part sorted check target value lies on right part if yes go to right else go to left part
                 if(target>nums[mid] && target<=nums[end])
                 start=mid+1;
                 else
                 end=mid-1;
             }
             
         }
         
         return false;
    }

    public static void main(String args[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter elements in to a rotated array");
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        System.out.println("Enter target value which you want to find in array");
        int k = sc.nextInt();

        sc.close();
     
        boolean res = Search(n,arr,k);
        if(res)
        System.out.println("Target value found");
        else
        System.out.println("Target value not found");
        
    }
}