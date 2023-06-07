/*Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 
has three inversions (2, 1), (4, 1), (4, 3).

Approach using merge sort
divide into two part sort and compare 

 */

import java.util.*;

class CountInversion
{

    static int mergeSort(int arr[],int start ,int end)
    {
       int mid = start + (end-start)/2 ;
           int count=0;
            
        if(end>start)
        {
           count+= mergeSort(arr,start,mid);
            count+= mergeSort(arr,mid+1,end);
            count+= merge(arr,start,mid,end);     
        }
        
       return count;
    }
    
    public static int merge(int arr[],int s,int m ,int e)
    {
       int n =e-s+1;
       int count=0;
        
       int temp[] = new int[n];
        
       int left = s,right = m+1,idx=0;
        
        while(left<=m && right<=e && idx<n)
        {
            if(arr[left]<=arr[right])
            {
                temp[idx++] = arr[left++];
                
            }else
            {
                //if left element of array is greater than right element of array  count this pair and after that left element all pair also count inversion because it arranged in sorted way if it greater after that element rest are also greater than right element
                count+= m-left+1;
                temp[idx++] = arr[right++];
            }
        }
        
        while(left<=m && idx<n)
        temp[idx++] = arr[left++];
        
         while(right<=e && idx<n)
        temp[idx++] = arr[right++];
        
        for(int i=s;i<=e;i++)
        arr[i] = temp[(i-s)];
        
        return count;
    }
    static int inversionCount(int arr[], int N)
    {
        // Your Code Here
       int count=0;
         count= mergeSort(arr,0,N-1);
          return count;
    }



    public static void main(String ar[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
       System.out.println("Enter elements in an array");
        for(int i=0;i<n;i++)
         arr[i] = sc.nextInt();
    
        
        sc.close();

       int res = inversionCount(arr,n);

       System.out.print("Total Count Inversion is"+res);
       
  
    }
}