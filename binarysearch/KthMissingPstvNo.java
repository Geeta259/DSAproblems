/*
Kth Missing Positive Number

Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
Return the kth positive integer that is missing from this array.

*/

import java.util.*;

class KthMissingPstvNo
{
    public static int findKthPositive(int[] arr, int k) {

        int low=0;
        int high=arr.length-1;
        int closestmid=0;

        while(low<=high)
        {
            int mid = (low+high)/2;
            int missingno = arr[mid]-(mid+1);
          
            if(missingno<k)
            {
                //represent no of element till mid 
                closestmid=mid+1;
                low=mid+1;
            }else
            {
                high=mid-1;
            }
        }

        //find kth missing element
        return k+closestmid;

        
    }
   
     public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an array");
        int n =sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter a element in an array in non decreasing order");
        for(int i=0;i<n;i++)
        arr[i] =sc.nextInt();

        System.out.println("Enter a kth missing number which you want to know");
        int k =sc.nextInt();
     
        sc.close();

        int res = findKthPositive(arr,k);
        System.out.println(k+" Missing Number is " + res);
        
    }
}