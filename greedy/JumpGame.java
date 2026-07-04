/*
Jump Game
You are given an integer array nums. You are initially positioned at the 
array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
*/

import java.util.*;
class JumpGame
{
    public static boolean canJump(int[] nums) {
        
        //start from index 0 we have to reached last index

        //declared  max variable which store index of maximum jump 
        //initial no jump initialize with 0
        int max = 0;

        int n = nums.length;

        //base condiiton
        if(n==1)return true;
        //traverse through nums 0 to n-1 because before this we have to reached n-1 
        for(int i=0;i<n-1;i++) 
        {
           //max index always must be greater or equal to i if it is not  means can not able to reach at current index no further jump possible return false
           if(max < i)return false;
           else
           {
               //update max index to max jump from current index
               if(max < i+nums[i])
               max = i+nums[i];


               //check we reached at last index if at any point reached or greater than n return true
               if(max>=n-1) return true;
           }
        }

        //if not able to reach last index return false
        return false;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();

        int[] jump = new int[n];
        System.out.println("Enter max jump for each index");
        for(int i=0;i<n;i++)
        jump[i] = sc.nextInt();

        boolean ans = canJump(jump);
        if(ans)
        System.out.println("Can reach to the last index");
        else
        System.out.println("Can not reach to the last index");

    }

}