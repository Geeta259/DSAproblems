/*
 * Kth Largest Element in an Array
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

solve it without sorting.

//use min heap  priority queue
 */
import java.util.*;
class KthLargestElem
{
    public static int findKthLargest(int[] nums, int k) {
        //defined min priority queue with capacity k size
        PriorityQueue<Integer> pq  = new PriorityQueue<>(k);

        //first k element push into min-heap
        for(int i=0;i<k;i++)
        pq.offer(nums[i]);

        //iterate over remaining  elements
        for(int i=k;i<nums.length;i++)
        {
            //if current value is greater than peek element value 
            if(nums[i] > pq.peek())
            {
                //remove smallest one add element which has higher value than this
                pq.poll();
                pq.add(nums[i]);
            }
        }

        //return kth element which is peek element  of min-priority queue
        return pq.peek();
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of elements");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter value of " + n + " elements");
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        
        System.out.println("Enter value of k largest element you want to find");
        int k = sc.nextInt();

        int elem = findKthLargest(arr,k);
        System.out.println("Kth largest element in an array  is " + elem);
    }
}