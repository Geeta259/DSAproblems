/*
Rotation
Given an ascending sorted rotated array Arr of distinct integers of size N. 
The array is right rotated K times. Find the value of K.


Input:
N = 5
Arr[] = {5, 1, 2, 3, 4}
Output: 1
Explanation: The given array is 5 1 2 3 4. 
The original sorted array is 1 2 3 4 5. 
We can see that the array was rotated 
1 times to the right.

  */

import java.util.*;

class FindKRotation
{
     
    public static int KRotation(int arr[], int n) {
        // code here
        int s=0,e=n-1;
        while(s<=e)
        {
                int mid = e-((e-s)/2);
                if((mid==0 || arr[mid]<arr[mid-1]) && (mid==n-1 || arr[mid]<arr[mid+1]))
                return mid;
                         
                 if(arr[mid]<=arr[e])
                e=mid-1;
                
                else
                s=mid+1;
        }
        
        return 0;
        
    }

    public static void main(String args[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter elements in to a rotated array");
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        sc.close();
     
        int res = KRotation(arr,n);
        System.out.println("No of rotation need for sorted is "+ res);
        
    }
}