/*
Median of 2 Sorted Arrays of Different Sizes
Given two sorted arrays array1 and array2 of size m and n respectively. Find the median of the two sorted arrays.
Input:
m = 3, n = 4
array1[] = {1,5,9}
array2[] = {2,3,6,7}
Output: 5
Explanation: The middle element for
{1,2,3,5,6,7,9} is 5

*/

import java.util.*;

class MedianOf2SortedArr
{
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    { 
    if(a.length>b.length)
    {
        //binary search appiled on minimum size array if second one minimum parameter swap  by again called method
       return  medianOfArrays(m,n,b,a);
    }
    //first array which is a[] always less than b[] second array
    //binary search applied on first array which is minimum length
    
    //left part total elements is m+n+1/2 which consist last element is middle one 
    int lefttotal = (m+n+1)/2;
    
    //binary search apply in first array minimum cut at first element maximum cut at  last element
    int low=0,high=n;
    while(low<=high)
    {
        //for left part we cut virtually both arrays pick any middle part cut1 represent cut in first array 
        //cut 2 represent cut in second array
        int cut1 = (low+high)/2;
        int cut2 = lefttotal-cut1;
         
        int l1 = cut1==0?Integer.MIN_VALUE:a[cut1-1];
        int l2= cut2==0?Integer.MIN_VALUE:b[cut2-1];
        int r1= cut1!=a.length?a[cut1]:Integer.MAX_VALUE;
        int r2= cut2!=b.length?b[cut2]:Integer.MAX_VALUE;
        
        if(l1<=r2 && l2<=r1)
        {
            //splited in a sorted way both arrays left and right part
            if((m+n)%2==0)
            {
                //for even
                return (double)(Math.max(l1,l2) + Math.min(r1,r2))/2;
            }else
             //for odd
                return Math.max(l1,l2);
        }
        else if(l1>r2)
        {
            //minimize l1 by going to left side
            high = cut1-1;
        }else
        {
            //minimize no  of element in l2 by increase no of element in l1
            low=cut1+1;
        }
    }
    
    
  return 0.0;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of first array");
        int n =sc.nextInt();

        int arr1[] = new int[n];
        System.out.println("Enter elements in a first array in a non decreasing order");
        for(int i=0;i<n;i++)
        arr1[i] =sc.nextInt();

        System.out.println("Enter size of second array");
        int m =sc.nextInt();

        int arr2[] = new int[m];
        System.out.println("Enter elements in a second array in a non decreasing order");
        for(int i=0;i<m;i++)
        arr2[i] =sc.nextInt();

        sc.close();
     
        double res = medianOfArrays(n, m, arr1, arr2); 
        System.out.println("Middle Elements after arrange all elements of both array in a non decreasing order is " + res);
        
    }
}