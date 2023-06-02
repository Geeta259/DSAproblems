/*
Subarrays with sum K
Given an unsorted array of integers, find the number of continuous subarrays having sum exactly 
equal to a given number k.

Input:
N = 5
Arr = {10 , 2, -2, -20, 10}
k = -10
Output: 3
Explaination: 
Subarrays: arr[0...3], arr[1...4], arr[3..4]
10,2,-2,-20
2,-2,-20,10
-20,10
have sum exactly equal to -10.
 */

import java.util.*;

class SubArrayWithSumK
{

    public static int findSubArraySum(int Arr[], int N, int k)
    {
        // code here
        //map used to store prefix sum at index i
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        int sum=0,count=0;

        //store default 0 with 1 frequency because a single element of value k also count a subarray
        map.put(0,1);
        for(int i=0;i<N;i++)
        {
            //prefix sum at index i 
            sum+=Arr[i];
            //check sum-k present in a map till i index or not if present get their frequnency which we actually need to get sum k
            if(map.containsKey(sum-k))
            {
                count+=map.get(sum-k);   
            }

            //add current sum till i index into map if already present increase their frequency
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        //return count how many times a subarray with sum  k present
        return count;
    }

     public static void main(String ar[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

       System.out.println("Enter elements in an array");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        System.out.println("Enter sum for subarray");
        int k = sc.nextInt();

        sc.close();

        int res = findSubArraySum(arr,n,k);
        System.out.println("Total Subarray with sum "+k+" is "+res);
      
        
    }
}