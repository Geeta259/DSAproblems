/*
Find All Four Sum Numbers
Given an array of integers and another number. Find all the unique quadruple from the given array 
that sums up to the given number.

Input:
N = 5, K = 3
A[] = {0,0,2,1,1}
Output: 0 0 1 2 
Explanation: Sum of 0, 0, 1, 2 is equal
to K.
 */

import java.util.*;

class FourSum
{
            public static List<List<Integer>> fourSum(int[] nums, int target) {

                //sort array from ascending to descending

                Arrays.sort(nums);
            
            List<List<Integer>> res = new ArrayList<List<Integer>>();
   
            for(int i=0;i<nums.length-3;i++)
            {
                //if i not first index and new value is same as previous iterate into next element
                if(i>0 && nums[i]==nums[i-1])
                continue;


                for(int j=i+1;j<nums.length-2;j++)
                {
                    //if second value is same as previous value skip that one move into next to pick second element
                    if(j>i+1 && nums[j]==nums[j-1])
                    continue;

                    int start=j+1;
                    int end=nums.length-1;
                    
                    while(start<end)
                    {
                        int sum = nums[i]+nums[j]+nums[start]+nums[end];
                    
                        //if sum is equal to target value
                        if(sum==target)
                        {
                        
                            //add into list
                        res.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                    
                            //update both pointer
                            start++;
                            end--;

                            //if start is less than end and new start pointer value is same as before skip that one check for next until find new element
                            while(start<end && nums[start]==nums[start-1])start++;

                              //if start is less than end and new updated end pointer value is same as before (end+1) skip that one check for previous until find new element
                            while(start<end && nums[end]==nums[end+1])end--;
                            
                        }

                        //if sum greater than target decrement end by 1 else increment start  by one
                        else if(sum>target)
                        end--;
                        else
                        start++;
                        
                    }
                }
            }
            
            return res;
            
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

        System.out.println("Enter sum whose you want to get quadruplets");
        int x = sc.nextInt();

        sc.close();

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans = fourSum(arr,x);
      
        System.out.println("All quadruplets of given sum is");
        System.out.println(ans);
        
      
        
    }
}
   