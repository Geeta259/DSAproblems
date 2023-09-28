/*
 * Floor in a Sorted Array
 * Given a sorted array arr[] of size N without duplicates, and given a value x. 
 * Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x.
 *  Find the index of K(0-based indexing).
 * 
 * Input:
N = 7, x = 0 
arr[] = {1,2,8,10,11,12,19}
Output: -1
Explanation: No element less 
than 0 is found. So output 
is "-1".

Input:
N = 7, x = 5 
arr[] = {1,2,8,10,11,12,19}
Output: 1
Explanation: Largest Number less than 5 is
2 (i.e K = 2), whose index is 1(0-based 
indexing).
 */

import java.util.*;

class FindLowerBound
{
    public  static int findFloor(int arr[], int n, int x)
    {
        int start=0;
        int end =n-1;
        
        int maxelem=-1;
        int rowidx=-1;
        
        //use binary search because given array is sorted
        while(start<=end)
        {
            int mid = end - (end-start)/2;

            //if mid value less than or equal to check check right side for find maximum value which is less than x
            if(arr[mid]<=x)
            {
                //if this value greater than previous maximum value than update maxvalue and store mid index
                if(arr[mid]>maxelem)
                {
                         maxelem = arr[mid];   
                        rowidx = mid;    
                }
                
             start=mid+1;
            }else
            {
                //if current value greater than x check left side for find less or equal to x
                end=mid-1;
            }
           
            
        }
        
        //return index which contain maximum value less than or equal to x
        return rowidx;
    }

    public static void main(String args[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter elements in to array");
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        System.out.println("Enter lower bound number");
        int k = sc.nextInt();
        sc.close();

        int idx = findFloor(arr,n,k);
        if(idx!=-1)
        System.out.println("Max Element found less than " + k + " at index " + idx);
        else
        System.out.println("No such element found less than "+k);
    }
}