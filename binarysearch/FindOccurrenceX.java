/*
 Number of occurrence
Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.
 
Input:
N = 7, X = 2
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 4
Explanation: 2 occurs 4 times in the
given array.
  */

import java.util.*;

class FindOccurrenceX
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

        System.out.println("Enter element whom no of occurrence you want to find");
        int k = sc.nextInt();
        sc.close();

        ArrayList<Integer> res = new ArrayList<Integer>();
        res = binSearch(arr,n,k);
        int ans = res.get(1)-res.get(0)+1;
        System.out.println("No of occurrence of "+ k +" in array is "+ ans);
        
    }
}