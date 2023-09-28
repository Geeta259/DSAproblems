/*
Capacity To Ship Packages Within D Days
A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages 
on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight
 capacity of the ship.
Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being 
shipped within days days. 

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and 
splitting the packages
 into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
*/

import java.util.*;

class CapacityToShip
{
    public static boolean canShipAll(int[] arr,int capacity,int days)
    {
        int weight=0,totalday=1;
        for(int i=0;i<arr.length;i++)
        {
            //if weight of ith index greater than capacity we cannt ship that weight return false
            if(arr[i]>capacity)
            return false;

            if(weight+arr[i]<=capacity)
            {
                //if current weight after adding ith index weight not greater than capacity add in to a ship in a day
                weight+=arr[i];
            }else
            {
                //if we cannot ship ith index weight in a day 
                //ship for next day increment total day with weight ith index
                totalday++;
                weight=arr[i];
            }

        }

        if(totalday<=days)
        return true;

        return false;
    }
    public static int shipWithinDays(int[] weights, int days) {
        //minimum weight ship  is 1 and max weight is int max
        int low=1,high=Integer.MAX_VALUE;
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(canShipAll(weights,mid,days))
            {
                //if able to ship all weights with capacity mid in given days
                //check for minimum weight capacity than this
                ans=mid;
                high=mid-1;
            }else
            {
                //if not able to ship all weights with this capacity in given days 
                //increase weight capacity 
                low=mid+1;
            }
        } 

        return ans;  
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n =sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter a weight in a array");
        for(int i=0;i<n;i++)
        arr[i] =sc.nextInt();

        System.out.println("Enter a days to load all weights in to a ship");
        int day =sc.nextInt();

        sc.close();
     
        int res = shipWithinDays(arr,day);
        System.out.println("Minimum capacity to load all weights in a ship in " + day +" days is " + res);
        
    }
}