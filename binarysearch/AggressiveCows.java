/*
Aggressive Cows
You are given an array consisting of n integers which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. You are given the task of assigning stalls to k cows such that the minimum distance between any two of them is the maximum possible.
The first line of input contains two space-separated integers n and k.
The second line contains n space-separated integers denoting the position of the stalls.

Input:
n=5 
k=3
stalls = [1 2 4 8 9]
Output:
3
Explanation:
The first cow can be placed at stalls[0], 
the second cow can be placed at stalls[2] and 
the third cow can be placed at stalls[3]. 
The minimum distance between cows, in this case, is 3, 
which also is the largest among all possible ways.

Approach:
Sort given array so that we can track minimum distance between all the cows 
by sorting we will only check distance , previous placed cows position and current cow placed no need to check all previous
cows position becuause it is sorted way.

1) we know that minimum distance between the cows  is 1 and in worst case minimum distance (maxelement-minelement)
2)pick any middle distance check for minimum distance if for this able to placed all cows then check for higher minimum distance
because we want maximize minimum distance
3) if not able to placed all cows with considering minimum distance go for lowest than this 
*/

import java.util.*;

class AggressiveCows
{
 
    public static boolean canPlaceCow(int stalls[],int k,int mindistance)
    {
        //placed a first cow is first index 
        int countcow=1,idx=0;
        for(int i=1;i<stalls.length;i++)
        {
            //check for every whether we have to place at ith index or not if first cow place index and 
            //current cow index not less than minimum distance can be able to placed it 
            if(Math.abs(stalls[i]-stalls[idx])>=mindistance)
            {
                countcow++;
                
                //update idx value by current placed cow index so that track distance for next cow
                idx=i;
            }
            
        }
        
        if(countcow>=k)
        return true;
        
        return false;
    }
    public static int findMaxMin(int n, int k, int[] stalls) {
        ///defined search space to get minimum distance to place k cows  
        int low=1;
        //for maximum difference between cow is
        //so that calculate whether is minimum distance between all the cows or not
        Arrays.sort(stalls);
        
        //maximum difference between the cows
         int high=stalls[n-1]-stalls[0];
        
        int ans=-1;
        while(low<=high)
        {
            //defined mid minimum distance place between cows 
            int mid = (low+high)/2;
            if(canPlaceCow(stalls,k,mid))
            {
                //if it is possible to place k cows by having mid distance between them
                //check for right side becuase we want maxmimum possible
                ans=mid;
                low=mid+1;
            }else
            {
                high=mid-1;
            }
        }
        return ans;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of stalls");
        int n =sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter a element in a array which indicate position of each stalls");
        for(int i=0;i<n;i++)
        arr[i] =sc.nextInt();

        System.out.println("Enter a number how many cows you want to placed");
        int k =sc.nextInt();

         sc.close();
     
        int res = findMaxMin(n,k,arr);
        System.out.println("Maximum possible minimum distance between the cows is " + res);
        
    }
}