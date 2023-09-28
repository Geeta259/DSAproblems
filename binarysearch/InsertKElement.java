/*
 * Search insert position of K in a sorted array
 * Given a sorted array Arr[](0-index based) consisting of N distinct integers and an integer k,
 *  the task is to find the index of k, if its present in the array Arr[]. Otherwise, 
 * find the index where k must be inserted to keep the array sorted.


 Input:
N = 4
Arr = {1, 3, 5, 6}
k = 5
Output: 2
Explaination: Since 5 is found at index 2 
as Arr[2] = 5, the output is 2.
 */

import java.util.*;

class InsertKElement
{
    public static int binSearch(int arr[], int n, int k) {
        // code here
        if(k>arr[n-1])
        return n;
        
        if(k<arr[0])
        return 0;
        

        int start=0,end=n-1,res=-1;
        while(start<=end)
        {
            int mid = end-((end-start)/2);

            //if current element less than target element check right side
            if(arr[mid]<k)
            start=mid+1;
            else
            {
                //if it greater or equal check previous value if previous less or current element is first element return mid which indicate current index of target element
                if(mid==0 || arr[mid-1]<k)
                return mid;
                
                //if it not true check left side to find current index
                else
                end=mid-1;
            }
        }
        
        return res;
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

        System.out.println("Enter element whom you want to find index");
        int k = sc.nextInt();
        sc.close();

        int res = binSearch(arr,n,k);
        System.out.println("Target Element should be placed at index " + res);
        
    }
}