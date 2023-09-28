/*
Minimum Number of Days to Make m Bouquets
You are given an integer array bloomDay, an integer m and an integer k.
You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
 
*/

import java.util.*;

class MinDaystoMakeBouquet
{
    public static boolean makeBouquet(int[] bloomDay, int m, int k, int day)
    {
        int cons=0,totalbouquet=0;
        for(int i=0;i<bloomDay.length;i++)
        {
            //if ith day is less than or equal to findind day then check
            if(bloomDay[i]<=day)
            {
                //consecutive flower is equal  to k increament no of bouquet
                cons++;
                if(cons==k)
                {
                         totalbouquet++;
                          cons=0;
                //again count consecutive flower for next bouquet

                }
               
            }else
            cons=0;
        }

        //if total bouquet on given day is greater or equal to m bouquet true we can make m bouquet till this day if less no of bouquet return false
        if(totalbouquet>=m)
        return true;

        return false;
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        //minimum days to make m bouquet
        int low=1,high=Integer.MIN_VALUE;
        //maximum days to make a bouquet
        for(int i=0;i<bloomDay.length;i++)
        {
            if(bloomDay[i]>high)
            high=bloomDay[i];
        }

        int ans=-1;

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(makeBouquet(bloomDay,m,k,mid))
            //if we can make m bouquet in mid day then go to left for minimum days
            {
                    ans = mid;
                    high = mid-1;
            }
        
            else
            //if we cannot make m bouquet in mid day go to right to increase days
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
        System.out.println("Enter a element in a array which indicate no of days for ith flower");
        for(int i=0;i<n;i++)
        arr[i] =sc.nextInt();

        System.out.println("Enter a number how much you want to make bouquet");
        int m =sc.nextInt();

        System.out.println("Enter a number how much consecutive flower you want in a bouquet");
        int k  =sc.nextInt();

        sc.close();
     
        int res = minDays(arr,m,k);
        System.out.println("Minimum no of days to make "+ m + " bouquet is " + res);
        
    }
}