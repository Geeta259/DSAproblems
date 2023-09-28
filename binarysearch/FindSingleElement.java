/*
Find the element that appears once in sorted array
Given a sorted array arr[] of size N. Find the element that appears only once in the array. 

All other elements appear exactly twice. 
Input:
N = 11
arr[] = {1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65}
Output: 4
Explanation: 4 is the only element that 
appears exactly once.


REmember point 
If all element in a twice only one element is single means size of array is always odd


  */

import java.util.*;

class FindSingleElement
{
    public static int findOnce(int arr[], int n)
    {
        // Complete this function
        int start = 0 ,end = n-1;
        while(start<=end)
        {
            int mid = end-((end-start)/2);   

            //if current element neither equal to previous element nor next element means it is single element return
            if((mid==0 || arr[mid]!=arr[mid-1]) && (mid==n-1 || arr[mid]!=arr[mid+1]))
            return arr[mid];

            //if mid index is even means no of previous element is even 
            
            if(mid%2==0)
            {
                //if all previous element in a pair current element should be equal to next element if yes left part in a pair go to right side
                 if(arr[mid]==arr[mid+1])
                 start=mid+1;
                 else
                 //if not means single element in a left part 
                 end=mid-1;
            }
            else
            {
               //if mid index is odd means no of previous element is odd 
               //if all previous element in a pair current element should be equal to previous element if yes left part in a pair go to right side
                if(arr[mid]==arr[mid-1])
                 start=mid+1;
                 else
                 //if not means single element in a left part
                 end=mid-1;
            }
            
            
        }
        
        return -1;
    }
    public static void main(String args[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter elements in to array in a sorted pair only one element remains single");
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        sc.close();
     
        int res = findOnce(arr,n);
        System.out.println("Single Element in an array is "+ res);
        
    }
}