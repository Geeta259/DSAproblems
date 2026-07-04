/*
Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it can trap after raining.

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) 
is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped.
*/
import java.util.*;

class TrappingRainWater
{
    public static int trap(int[] height) {
        
        //calculate rightmax from end to till ith index 
        int max = Integer.MIN_VALUE;

        //create array to store max sum from right 
        int[] rightsum = new int[height.length];

        //store rightmax for each index
        for(int i=height.length-1;i>=0;i--)
        {
            max = Math.max(max,height[i]);
            rightsum[i] = max;
        }

        //traverse through height array
        max = Integer.MIN_VALUE;
        int trap=0;
        for(int i=0;i<height.length;i++)
        {
            //find left max height block
            max = Math.max(max,height[i]);

            //leftmmax & rightmax get minimum height block and subtract to current height block to get amount of trapped water
            int boundary = Math.min(max,rightsum[i]);
            trap+=boundary - height[i];
        }

        return trap;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of blocks");
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        System.out.println("Enter height of each block");
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        sc.close();
        int amount = trap(arr);
        System.out.print("Total amount of water trapped is "+amount);
    }
}