/*
Subarrays with K Different Integers
Given an integer array nums and an integer k, return the number of good subarrays of nums.
A good array is an array where the number of different integers in that array is exactly k.
For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
 */

import java.util.*;

class FindKDistinct 
{
    public static int findDistinct(int[] nums , int k)
    {
        //use sliding window to find at most k distinct integer
        //starting of the sliding window
        int i=0;
        //ending of the sliding window
        int j=0;

        //hashmap to store frequency of each integer
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        int n =nums.length;

        int ans=0,distinct=0;

        while(j<n)
        {
            ///add frequency of this element
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);

            //if after add frequency value is 1 means it is distinct  integer
            if(map.get(nums[j])==1)
            distinct++;

            //check window size of distinct element greater than k
            //if yes resize window size by removing fequency of each element from beginning
            while(distinct>k)
            {
                //frequency of that starting element from starting decrease by one
                 map.put(nums[i],map.get(nums[i])-1);

                 //check if it is distinct element remove 
                 if(map.get(nums[i])==0)
                distinct--;

                //starting pointer increment by one
                i++;
            }

            //store n of element between starting pointer to ending pointer of sliding window
            ans+=j-i+1;
            j++;
        }

        return ans;
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
    
         System.out.println("Enter no of distinct integer present in a subarray");
         int k = sc.nextInt();

        sc.close();

       int res = findDistinct(arr,k) - findDistinct(arr,k-1);

       System.out.print("Number of subarray to having" + k + " distinct integer is " +res);
       
  
    }
}