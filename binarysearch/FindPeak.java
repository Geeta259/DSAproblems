/*
Peak element
An element is called a peak element if its value is not smaller than the value of its adjacent elements(if they exists).
Given an array arr[] of size N, Return the index of any one of its peak elements.

Input: 
N = 3
arr[] = {1,2,3}
Possible Answer: 2
Explanation: index 2 is 3.
It is the peak element as it is 
greater than its neighbour 2.
If 2 is returned then the generated output will be 1 else 0.

  */

import java.util.*;

class FindPeak
{
    public static int peakElement(int[] arr,int n)
    {
       //add code here.
       int start=0,end=n-1,res=-1;
       while(start<=end)
       {
           int mid = end - ((end-start)/2);

           //if current element is greater than previous element (if exist) and greater than next element(if exist) it is piovt element store and break
           if((mid==0 || arr[mid]>=arr[mid-1]) && (mid==n-1 || arr[mid]>=arr[mid+1]))
           {
                res = mid;
                break;
           }
           
                //if previous element greater than current element check left side for pivot
                else if(mid>0 && arr[mid-1]>arr[mid])
                end=mid-1;

                //else if none case find check right side
                else
                start=mid+1;
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

        sc.close();
     
        int res = peakElement(arr,n);
        System.out.println("Peak Element found at index "+ res);
        
    }
}