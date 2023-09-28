/*
K-th element of two sorted Arrays
Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K. 
The task is to find the element that would be at the kth position of the final sorted array.
 
Input:
arr1[] = {2, 3, 6, 7, 9}
arr2[] = {1, 4, 8, 10}
k = 5
Output:
6
Explanation:
The final sorted array would be -
1, 2, 3, 4, 6, 7, 8, 9, 10
The 5th element of this array is 6.


Approach
1)one way to use two pointer approach to find kth element it takes 0(n+m) time
2) second way to use binary search (Optimal Approach)

-> Considering first array is smaller than second array if not swap parameter by calling again kthelement function
--> define range which is considered as a left part low and high
  */

import java.util.*;

class FindKElement
{
    public  static long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        
        //use binary search to solve this question
        if(n>m)
        {
            //if first array is larger than second array
            //swap first array with second array  by calling kthelement again so that arr1 always smaller than arr2
            return kthElement(arr2,arr1,m,n,k);
        }
        
        //range set for left part of first array  
        //left part must conatain k elements
        //if second array size less than k must be k-m element taken from first array 
        int low = Math.max(0,k-m);
        
        //if first array less than k high range n elements
        int high = Math.min(n,k);
        
        while(low<=high)
        {
            int cut1 = (low+high)/2;
            int cut2 = k-cut1;
            
            //if cut1 value 0 -1 index l1 minimium value so that condition satisfied else 
            //l1 contain cut1-1 index element of first array
            int l1 = cut1==0?Integer.MIN_VALUE: arr1[cut1-1];
            int l2 = cut2==0?Integer.MIN_VALUE: arr2[cut2-1];
            
            //for right part of arrays
            int r1 = cut1==n?Integer.MAX_VALUE:arr1[cut1];
            int r2 = cut2==m?Integer.MAX_VALUE:arr2[cut2];
            
            //left part of both arrays must be less or equal to right part of both arrays
            //l1 must less r1 because first array  is sorted 
            //l2 must less r2 becuase second array is sorted
            
            //this condition require to check left part elements of both array must be smaller than
            //right part elements 
            if(l1<=r2 && l2<=r1)
            {
                //if condition satisfied 
                //either l1 or l2 contain kth element which is largest one because left part contain\
                //k elements
                return Math.max(l1,l2);
            }
            else if(l1>r2)
            {
                //minimize l1 by going to left 
                high = cut1-1;
            }else
            {
                //l2>r1 minimize l2 so we have to maximize l1 by going to right
                low=cut1+1;
            }
         }
         
         return 1;
    }

    public static void main(String args[])
    {
        System.out.println("Enter size of first array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

        int arr1[] = new int[n];
        System.out.println("Enter elements in to array in an ascending order");
        for(int i=0;i<n;i++)
        arr1[i] = sc.nextInt();

        System.out.println("Enter size of second array");
        int m = sc.nextInt();

        int arr2[] = new int[m];
        System.out.println("Enter elements in to array in an ascending order");
        for(int i=0;i<m;i++)
        arr2[i] = sc.nextInt();

        System.out.println("Enter position to find the element from array");
        int k = sc.nextInt();

        sc.close();
     
       long res = kthElement(arr1,arr2,n,m,k);
        System.out.println(k+" position element after merging is "+ res);
        
    }
}