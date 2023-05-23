/*
 * Longest Sub-Array with Sum K
 * Given an array containing N integers and an integer K., Your task is to find the length of the
 *  longest Sub-Array with the 
 * sum of the elements equal to the given value K.
 * 
 * 
 * here elements can be positive or negative both
 * 
 * optimal approach to use hashmap
 */

import java.util.*;

class LongestSubArr
{

    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int sum=0,maxlen=0;
        
        for(int i=0;i<N;i++)
        {
            sum+=A[i];  //prefix sum

            if(sum==K)          //if sum equal to k at any index longest subarray i+1 i start from 0
             maxlen = i+1;
            
            int rem = sum-K;        //if it is not equal to k find sum-k present or not in map
            if(map.containsKey(rem))        //if remaining number to get k is present in map
            {
                int len = i-map.get(rem);       //get index of remaining number by map substract from current index to get length  
                maxlen = Math.max(maxlen,len);  //store maxlen if current subarray length is maximum
            }
            
            if(!map.containsKey(sum))   //if sum not contains in a map store in to map with index value if sum already present no updataion required
            map.put(sum,i);
        }
        
        return maxlen;  //return maxlength of longest subarray
        
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

        System.out.println("Enter sum of longest subarray");
        int k = sc.nextInt();

       
        sc.close();

        int res = lenOfLongSubarr(arr,n,k);
        System.out.println("The length of longest subarray with sum  "+k+" is " + res);
        
    }
}