/*
Heap Sort
Given an array of size N. The task is to sort the array elements by completing functions
 heapify() and buildHeap() which are used to implement Heap Sort.
*/
import java.util.*;
class HeapSort
{
    //Function to build a Heap from array.
    public static void buildHeap(int arr[], int n)
    {
       //first step to build heap  which satisfy heapify properties
       //start from n/2-1 index becuase after that index all are leaf nodes
       for(int i=n/2-1;i>=0;i--)
       {
           //check it satisfy heapify properties or not
           heapify(arr,n,i);
       }
    }
 
   public static void swap(int[] arr,int idx1,int idx2)
    {
        int temp  = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    //Heapify function to maintain heap property.
    public static void heapify(int arr[], int n, int i)
    {
        // Your code here
        //assuming i index is max index
        int max = i;
        //get  left and right child index of ith
        int left = 2*i+1;
        int right = 2*i+2;
        
        //compare values to get max value index
        if(left<n && arr[left]  > arr[i])
        max = left;
        
        if(right<n && arr[right] > arr[max])
        max = right;
        
        //check max index if it is not equal to i it means either left or right child greater than parent node
        if(max!=i)
        {
            //swap max index value with ith index
            swap(arr,max,i);
            //after swap  again verify heapify properties for max index
            heapify(arr,n,max);
        }
     
    }
    
    //Function to sort an array using Heap Sort.
    public static void heapSort(int arr[], int n)
    {
        //build heap function called
        buildHeap(arr,n);
        
        //heap is created which satisfy heapify properties
        //start from last index 
        //first index is always greater among all of them
        for(int i=n-1;i>=0;i--)
        {
            //first swap last index value with first index value
            swap(arr,i,0);
            //after swap check heapify properties from starting to ith index
            //exclude last one in each itertaion
            heapify(arr,i,0);
        }
    }

      public static void main(String ar[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

       System.out.println("Enter elements in an array");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        sc.close();

      
       heapSort(arr,n);
        
        System.out.println("After sorting elements in an array is");
        for(int i=0;i<n;i++)
        System.out.print(arr[i]+" ");
    }
 }