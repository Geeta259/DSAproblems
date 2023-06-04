/*
3Sum
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
 */

import java.util.*;

class ThreeSumZero
{
    public static List<List<Integer>> threeSum(int[] nums) {

        //hashset used because we need unique triplets whose sum is zero
        Set<List<Integer>> set = new HashSet<>();

        //sort given array so that we can use two pointer approach
        Arrays.sort(nums);

        int start,end,sum=0;

        //iterate over an array
        for(int i=0;i<nums.length;i++)
        {
            start=i+1;
            end=nums.length-1;

            //use two pointer start indicate first number after i and end indicate last number
            while(start<end)
            {
                //get sum of three elements
                sum=nums[i]+nums[start]+nums[end];

                if(sum==0)
                {
                    //if sum zero add three numbers as a list into set if it already present in set it will not add again into set
                    set.add(Arrays.asList(nums[i],nums[start],nums[end]));

                    //update both pointers
                    start++;
                    end--;
                    
                }

                //if sum greater than zero decrement end pointer
                else if(sum>0)
                end--;

                //else increment start pointer
                else
                start++;
             }
        }


        //return array list by convert set into list
        return new ArrayList<>(set);
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

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list = threeSum(arr);
      
        System.out.println(list);
        
      
        
    }
}
   