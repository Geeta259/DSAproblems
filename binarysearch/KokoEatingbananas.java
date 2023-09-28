/*
Koko Eating Bananas
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

Input: piles = [3,6,7,11], h = 8
Output: 4

 

*/

import java.util.*;

class KokoEatingbananas
{
    public static boolean shecanEat(int[] piles,int perhour,int totalhour)
    {
        int counthour=0;
        for(int i=0;i<piles.length;i++)
        {
            counthour+=(piles[i]/perhour);
            if(piles[i]%perhour!=0)
            counthour++;
        }

        if(counthour<=totalhour)
        return true;
        else
        return false;
    }
    public static int minEatingSpeed(int[] piles, int h) {
        //minimum she can eat 1 bananas in a hour
        int low=1;
        //maximum she can eat max bananas in a pile in a hour
        int high=-1;
        for(int i=0;i<piles.length;i++)
        {
            if(piles[i]>high)
            high=piles[i];
        }

        //find minimum bananas she can eat in a hour 
        while(low<high)
        {
            int mid = (low+high)>>1;
            //check she can eat all banans or not if she eat mid bananas in a hour
            if(shecanEat(piles,mid,h))
            //greater than mid she can also eat all bananas check to left side for minimum bananas eat in a hour
            high=mid;
            else
            //if she can not eat all bananas for mid so incraese count of bananas in a hour 
            low=mid+1;
        }

        return low;
    }
   
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n =sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter a element in a array which indicate no of bananas in a piles");
        for(int i=0;i<n;i++)
        arr[i] =sc.nextInt();

        System.out.println("Enter a number for hours to complete all banans");
        int h =sc.nextInt();

        sc.close();
     
        int res = minEatingSpeed(arr,h);
        System.out.println("Minimum bananas she can eat in a hour to complete all banans in a given hour is "+ res);
        
    }
}