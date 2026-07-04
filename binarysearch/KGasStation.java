/*
Minimize Max Distance to Gas Station

You are given a sorted array ‘arr’ of length ‘n’, which contains positive integer positions of ‘n’ gas stations on the X-axis.
You are also given an integer ‘k’.
You have to place 'k' new gas stations on the X-axis.
You can place them anywhere on the non-negative side of the X-axis, even on non-integer positions.
Let 'dist' be the maximum value of the distance between adjacent gas stations after adding 'k' new gas stations.
Find the minimum value of dist.

Example:
Input: ‘n' = 7 , ‘k’=6, ‘arr’ = {1,2,3,4,5,6,7}.

Answer: 0.5

Explanation:
We can place 6 gas stations at 1.5, 2.5, 3.5, 4.5, 5.5, 6.5. 

Approach to get minimum  distance value after  placed k  new  station is placed in between of  max  distance among the stations.
*/

import java.util.*;

class Pair{
    double diff;
    int  idx;
    Pair(double diff,int idx)
    {
        this.diff=diff;
        this.idx=idx;
    }
}

class KGasStation
{
   
    /*
    public static double MinimiseMaxDistance(int []arr, int K){
        // Write your code here.
        //create a section array for given array
        int n = arr.length;
        int[] section = new  int[n-1];

        //create  a priority queue which store  difference of two  adjacent and index
        PriorityQueue<Pair>  pq = new PriorityQueue<>((a,b)->Double.compare(b.diff, a.diff));

        //store all adjacent difference with index
        for(int i=0;i<n-1;i++)
        {
            int diff = arr[i+1]-arr[i];
            pq.offer(new Pair(diff,i));
        }

        //placed k gas station in  between given station
        for(int i=1;i<=K;i++)
        {
           Pair  pa =  pq.poll();
           //get max  difference from priority queue
       
             //increase section  value by 1  at  this index
            section[pa.idx]++;

                //get  actual  difference
            double diff =  arr[pa.idx+1]-arr[pa.idx];

            //get no  of  section and  add 1 for no  of  elements to  get new difference between  numbers
            double  newdiff = diff/(double)(section[pa.idx]+1);

            //push  into  priority queue with new difference
            pq.offer(new Pair(newdiff,pa.idx));

        }

        //maximum  difference
        return pq.peek().diff;

    }
    //using  priority queue
    */
   
    //using binary  search optimal  approach
    public static boolean isPossible(int[] stations,double diff,int k)
    {
        //get no  of station after considered diff as max distance
        int total=0;
        for(int i=1;i<stations.length;i++)
        {
            //if getdifference divide by difference greater than 1 getdiff larger than
            //add into  count to get quotient minus 1  add into  total
            double getdiff = stations[i]-stations[i-1];
            total+=Math.ceil(getdiff/diff)-1;
        }
        //return total  is less than or not  
        return total<=k;
    }
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        int n =  stations.length;
        //create range for binary  search  min differnce can be 0  and  max can be last element - first element
        double low=0,high = stations[n-1]-stations[0],mid=0;
        double ans=-1;
        //traverse stop when difference btw high and low is neglible < 1e-6
        while(high-low >= 1e-6)
        {
            //get mid considering this is max distance
            mid= (low+high)/2;
            //count is it possible to having this max difference after adjacent station
            if(isPossible(stations,mid,k))
            {
                //if possible  stored ans and move to  left side for minimize start frommid not mid-1 
                //because working on double
                ans = mid;
                high = mid;
            }
            else
            {
                //if it not possible go  to right for maximize gas station differeence
                low=mid;
            }
        }
        
        return ans;
        
    }
     public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an station");
        int n =sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter a station number in an array in non decreasing order");
        for(int i=0;i<n;i++)
        arr[i] =sc.nextInt();

        System.out.println("Enter a k value to add new gas station");
        int k =sc.nextInt();
     
        sc.close();

        double res = findSmallestMaxDist(arr,k);
        System.out.println("Minimum distance among  all maximized distance after placed k station one by one is " + res);
        
    }
}