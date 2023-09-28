/*
Smallest Divisor
You are given an array of integers nums and an integer K, your task is to
 find the smallest positive integer divisor, such that upon dividing all the elements of the given array 
 by it, the sum of the division's result
 is less than or equal to the given integer K.

 Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and 
if the divisor is 5 the sum will be 5 (1+1+1+2) which is less than k lowest divisor is 5. 
*/

import java.util.*;

class SmallestDivisor
{
    public static boolean isLessthanK(int[] nums,int K,int mid)
    {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            //get divisor value add into sum
            sum+=nums[i]/mid;

            //if it not completely divide increment sum by one(becuase divisor increment by one )
            if(nums[i]%mid!=0)
            sum++;
        }
        

        //if sum of division result provide less than or equal k return true else return false
        if(sum<=K)
        return true;
        
        return false;
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        //defined search space lowest divisor is 1 and highes is integer max range
         int low=1,high=Integer.MAX_VALUE;
        int ans=0;
        while(low<=high)
        {
            //check for any random divisor
            int mid=low+(high-low)/2;

            //if it provide sum less than k check for smallest divison than this by going to left side 
            if(isLessthanK(nums,threshold,mid))
            {
                ans=mid;
                high=mid-1;
            }else

            //if it not giving sum less than k than go for right side to get minimum divisor sum 
            low=mid+1;
        }
        
        return ans;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n =sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter a element in a array");
        for(int i=0;i<n;i++)
        arr[i] =sc.nextInt();

        System.out.println("Enter a number for which sum of divisor get less or equal to");
        int m =sc.nextInt();

        sc.close();
     
        int res = smallestDivisor(arr,m);
        System.out.println("Nearest divisor for which sum of divisor less than or equal to is " + res);
        
    }
}