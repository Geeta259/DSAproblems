/*
Merge Without Extra Space
Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order 
without using any extra space. Modify arr1 so that it contains the first N elements
 and modify arr2 so that it contains the last M elements.


 Input: 
n = 4, arr1[] = [1 3 5 7] 
m = 5, arr2[] = [0 2 6 8 9]
Output: 
arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]
Explanation:
After merging the two 
non-decreasing arrays, we get, 
0 1 2 3 5 6 7 8 9.
 *
 */

import java.util.*;

class MergeTwoArrays
{

   //Function to merge the arrays without taking any extra space.
   public static void merge(int arr1[], int arr2[], int n, int m) 
   {
       // code here 
       
       int i=0,j=0,k=n-1;
       
       while(i<=k && j<m)
       {
           if(arr1[i]>arr2[j])
           {
               //it means second array element at index j comes into first array for sure but due to size fixed 
               //so last element of first array which is largest not comes into first array so last array element for sure comes into second array 
               //swap second array element at index j with largest element of first array at index k
               
               int temp =arr1[k];
               arr1[k] = arr2[j];
               arr2[j] = temp;
               
               //decrement k  & increment j to check for next element 
               k--;
               j++;
               
           }else
           //if first array element smaller than second array element at index j no need to do anything just increment i
           i++;
       }

       //at  last sort both arrays so all elements arrange in non decreasing order
       Arrays.sort(arr1);
       Arrays.sort(arr2);
   }

    public static void main(String ar[])
    {
        System.out.println("Enter size of first array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

        int arr1[] = new int[n];
       System.out.println("Enter elements in to first array");
        for(int i=0;i<n;i++)
         arr1[i] = sc.nextInt();
       
        System.out.println("Enter size of second array");
        int m = sc.nextInt();

        int arr2[] = new int[m];

        System.out.println("Enter elements in to second array");
        for(int i=0;i<m;i++)
         arr2[i] = sc.nextInt();
       
        
        sc.close();


        merge(arr1,arr2,n,m);
        System.out.println("After merging elements of first and second array elements is");
        System.out.println("First array elements is");
        for(int i=0;i<n;i++)
       System.out.print(arr1[i]+" ");

        System.out.println("\nSecond array elements is");
        for(int i=0;i<m;i++)
        System.out.print(arr2[i]+" ");
       
        
        
    }
}