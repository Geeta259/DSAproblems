/*
Search in a Rotated Array
Given a sorted and rotated array A of N distinct elements which is rotated at some point,
 and given an element key. The task is to find the index of the given element key in the array A.
 The whole array A is given as the range to search.

 Input:
N = 9
A[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}
key = 10
l = 0 , h = 8
Output:
5
Explanation: 10 is found at index 5.

  */

import java.util.*;

class FindKeyRotatedArr
{
    

    public static int search(int A[], int l, int h, int key)
    {
        // l: The starting index
        // h: The ending index, you have to search the key in this range
        // Complete this function
        while(l<=h)
        {
            int mid = h-((h-l)/2);
            if(A[mid]==key)
            return mid;
            
            //means left part is sorted 
            else if(A[l]<A[mid])
            {
                //check  key lies between l to mid if yes then go to left side
                if(key>=A[l] && key<A[mid])
                h=mid-1;
                
                //if it not lies left side then move right side
                else
                l=mid+1;
            }
            
            else 
            {
               //means right part sorted if left part not sorted
               
               //check  key lies between mid to high if yes then go to right side
                if(key>A[mid] && key<=A[h])
                l=mid+1;
                
                //if it not lies right side then move left side
                else
                h=mid-1;
               
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
        System.out.println("Enter elements in to a rotated array");
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        System.out.println("Enter target value which you want to find in array");
        int k = sc.nextInt();

        sc.close();
     
        int res = search(arr,0,n-1,k);
        if(res!=-1)
        System.out.println("Target value found at index "+ res);
        else
        System.out.println("Target value not found");
        
    }
}