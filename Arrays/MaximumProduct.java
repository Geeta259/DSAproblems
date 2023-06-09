/*
Maximum Product Subarray
Given an integer array nums, find a subarray that has the largest product, and return the product.

Approach
1) find maximum product subarray from left to right
2) find maximum product subarray from right to left
3) check if 0 comes in an arary or not
4) find maximum product either left product or right product (or zero if zero exist)
 */

import java.util.*;

class MaximumProduct
{
    public static int maxProduct(int[] nums) {
        int leftmax=Integer.MIN_VALUE;
        int rightmax=Integer.MIN_VALUE;

        int leftpro=1,rightpro=1;
        //find maximum product from left to right
        //check zero exist or not in array
        boolean flag0 = false;
        for(int i=0;i<nums.length;i++)
        {
                if(nums[i]==0)
                {
                    //0 exist in a arrray after 0 product always get 0
                    flag0 = true ;

                    //new subarray product check 
                    leftpro=1;
                    continue;
                }

                leftpro*= nums[i];

                if(leftpro > leftmax)
                leftmax=leftpro;
        }

         //find maximum product from right to left
        for(int i=nums.length-1;i>=0;i--)
        {
                if(nums[i]==0)
                {
                    //0 exist in a arrray after 0 product always get 0 again start new subarray find their product
                    flag0 = true ;

                    //new subarray product check 
                    rightpro=1;
                    continue;
                }

                rightpro*= nums[i];

                if(rightpro > rightmax)
                rightmax=rightpro;
        }

        if(flag0)
        return Math.max(Math.max(leftmax,rightmax),0);
        else
        return Math.max(leftmax,rightmax);
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

       int res = maxProduct(arr);

       System.out.print("Maximum Product Subarray is "+res);
       
  
    }
}