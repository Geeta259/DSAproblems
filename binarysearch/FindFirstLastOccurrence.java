/*
 First and last occurrences of x
 Given a sorted array arr containing n elements with possibly duplicate elements, the task is to 
 find indexes of first and last occurrences of an element x
  in the given array.
 
 Input:
n=9, x=5
arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
Output:  2 5
Explanation: First occurrence of 5 is at index 2 and last
             occurrence of 5 is at index 5. 
  */

import java.util.*;

class FindFirstLastOccurrence
{
    static ArrayList<Integer> binSearch(int arr[], int n, int x)
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        //find first occurrence of x
        
       int start=0,end=n-1;
       int res=-1;
        while(start<=end)
        {
            int mid = end-((end-start)/2);

            //if current element equal to x check previous element if it less than x first occurrence found store index 
            if(arr[mid]==x && (mid==0 || arr[mid-1]<x))
            {
                res = mid;
                break;
            }
             //if current element less than target element check right side else left side
            else if(arr[mid]<x)
            start=mid+1;
            
            else
            end=mid-1;
            
        }
        
       ans.add(res);
       
       
        //find last occurrence
        
        start=0 ; end=n-1 ; res=-1;
        while(start<=end)
        {
            int mid = end-((end-start)/2);

           //if it equalto x and next element is greater than x it is last occurrence of x store index and break
            if(arr[mid]==x && (mid==n-1 || arr[mid+1]>x))
            {
                res = mid;
                break;
            }
             //if current element less than or equal to target element check right side else left side
            else if(arr[mid]<=x)
            start=mid+1;
            
            else
            end=mid-1;
            
        }
        
       ans.add(res);
       
       return ans;
       
    }

    public static void main(String args[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter elements in to array in a ascending order");
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        System.out.println("Enter element whom first and last occurrence index you want to find");
        int k = sc.nextInt();
        sc.close();

        ArrayList<Integer> res = new ArrayList<Integer>();
        res = binSearch(arr,n,k);
        System.out.println("First occurrence of target element is "+res.get(0)+"\nLast occurrence of target element is "+res.get(1));
        
    }
}