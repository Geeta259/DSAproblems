//implementation of  max priority queue using array  implementation of binary heap
import java.util.*;

class  MinToMaxHeap
{
    public static void maxHeapify(int[] arr,int i,int n)
    {
        int left=2*i+1; //get left node
        int right=2*i+2;    //get right node
        int max=i;  //current  idx as a max assume
        if(left<n &&  arr[left]  > arr[max])max=left;   //if left  one is max
        if(right < n && arr[right] > arr[max])max=right;    //if right one is max

        if(max!=i)  //if both are not  same
        {
            //swap from parent node
            int temp = arr[max];
            arr[max]=arr[i];
            arr[i] = temp;

            //call  again maxheapify for max index
            maxHeapify(arr, max, n);
        }
    }
    public static int[] MinToMaxHeap(int n, int[] arr){
        // Write your code here
        //get non leaf node which  is n/2-1;
        int  start = n/2-1;

        //traverse fromnon leaf node to  starting node
        for(int i=start;i>=0;i--)
        { maxHeapify(arr,i,n); }    //apply max heapify property to  each node

        return arr; //return max heapify
    }
    public static  void main(String args[])
    {
        Scanner sc = new  Scanner(System.in);

        System.out.println("Enter size of array");
        int n = sc.nextInt();

        int min_heap[] = new int[n];
        System.out.println("Enter min heap data");
        for(int i=0;i<n;i++)
        min_heap[i] = sc.nextInt();

        int max_heap[]= MinToMaxHeap(n,min_heap);
        System.out.println("Max Heap value  is");
        for(int i=0;i<n;i++)
        System.out.print(max_heap[i] + " ");
    }
}