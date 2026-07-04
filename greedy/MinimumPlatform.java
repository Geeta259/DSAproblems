/*
Minimum Platforms
Given arrival and departure times of all trains that reach a railway station. 
Find the minimum number of platforms required for the railway station so that no train is kept waiting.
Input: n = 6 
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
Output: 3
Explanation: 
Minimum 3 platforms are required to 
safely arrive and depart all trains.
*/

import java.util.*;

class MinimumPlatform
{
    public static int findPlatform(int arr[], int dep[], int n)
    {
        //sort arrival and departure array 
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        //use two pointer approach to find out arrival of next train and departure of previous train
        int plat = 1;
        int i=0,j=1;
        
        //iterate until all train departure
        while(j<n && i<n)
        {
            //if arrival time less  than previous train departure time
            if(arr[j] <= dep[i])
            {
                //one more platform needed for this train 
                plat++;
                //move to next train
                j++;
            }
            else
            {
                //if arrival time more than previous train departure
                //same platform can used for this train
                j++;
                //move to next train an also  move i to get next greater departure time
                i++;
            }
        }
        
        //return no of platform
        return plat;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of train");
        int n = sc.nextInt();

        int[] arr = new int[n];
         int[] dept = new int[n];

        System.out.println("Enter starting time of each train");
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();
        System.out.println("Enter ending time of each train");
        for(int i=0;i<n;i++)
        dept[i] = sc.nextInt();

       int plat = findPlatform(arr,dept,n);
       System.out.println("Minimum no of platforms required for a all train is " + plat);
    }

}