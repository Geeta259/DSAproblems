/*
 *  Single Number II
Given an integer array nums where every element appears three times except for one, 
which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Input: nums = [2,2,3,2]
Output: 3
 
 */

import java.util.*;

class SingleNumberAmongThree
{ 
    public static int singleNumber(int[] nums) {
        /*
         first way to  sort given array and compare with adjacent elements to find odd  one out.
         
         Arrays.sort(nums);
 
         for(int i=1;i<nums.length-2;i+=3)
         {
             if(nums[i]!=nums[i-1] && nums[i]!=nums[i+1])
             return nums[i];
             else if(nums[i]!=nums[i-1])
             return nums[i-1];
 
         }
 
         return nums[nums.length-1];
         */
 
         //second way to use bit manipulation
         int ans=0,count1=0;
         //every integer number can represent into 32 bit
         for(int i=0;i<32;i++)
         {
             count1=0;
             //go to ith bit of every number
             for(int j=0;j<nums.length;j++)
             {
                 //check ith bit of jth number
                 if(((nums[j]>>i)&1)==1)
                 count1++;
             }
 
             //pair ith bit into group of 3 because every number is group of 3 except one
             //get remainder
             count1 = count1 % 3;
 
             //current ith bit is set  becuase of odd one among all numbers
             if(count1!=0)
             {
                 //stored into ans 
                 //set ith bit and do or operation with previous stored bit
                 ans = ans | (1<<i);
             }
         }
         return ans;
     }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
       System.out.println("Enter size of array");
       int n = sc.nextInt();

       int arr[] = new int[n];
        System.out.println("Enter elements in to a array");
       for(int i=0;i<n;i++)
       arr[i] = sc.nextInt();

       int single = singleNumber(arr);
       System.out.println("Single number is " + single);
    }
}