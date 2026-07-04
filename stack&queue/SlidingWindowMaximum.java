/*
Sliding Window Maximum
You are given an array of integers nums, there is a sliding window of size k which is moving from the very 
left of the array to the very right. You can only see the k numbers in the window.
 Each time the sliding window moves right by one position.


*/
import java.util.*;

class SlidingWindowMaximum
{
    public static int[] maxSlidingWindow(int[] nums, int k) {

        //used dequeue to check prev element from last and size k bound from peek
        Deque<Integer> de  = new ArrayDeque<>();

        //resultant array which store max of each subarray  
        int[] res = new int[nums.length-k+1];

        int idx=0;

        //traverse through array
        for(int i=0;i<nums.length;i++)
        {
             //check bounds of subarray from left if peek element index less than subarray bound pop that index
             //check if peek value is equal to i-k remove that index
            //check peek index bottom value if it out of bound index of current subarray pop out
            if(!de.isEmpty() && de.peek() == i-k)
            de.poll();

              //current element is greater than last element in deque smallest pop  out from last (top)
            //because no need to store min in size k 
             while(!de.isEmpty() && nums[i]> nums[de.peekLast()])
             de.pollLast();

              //add current index  to queue in last (top)
             de.offer(i);

            //get max value from bottom (queue peek) if i greater than or equal to k-1
             if(i>=k-1)
             res[idx++] = nums[de.peek()];

           
        }

        //return resultant  array
        return res;
    }

     public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a  size of array");
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        System.out.println("Enter elements in to an array");
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        System.out.println("Enter a  size of subarray");
        int k = sc.nextInt();


        sc.close();
        int ans[] = maxSlidingWindow(arr,k);
        for(int i=0;i<ans.length;i++)
        System.out.print(ans[i]+" ");
      
    }
}