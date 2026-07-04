/*
 Sum of Subarray Minimums
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. 
Since the answer may be large, return the answer modulo 109 + 7.
*/
import java.util.*;

class SubArrayMinimumSum
{
    public static int sumSubarrayMins(int[] arr) {

        //create a stack to store elements in an increasing order
        Stack<Integer> st = new Stack<>();

        long ans=0;
        long mod = 1000000007;
        //traverse through loop
        //go one more extra index so that all element can pop out in single iteration
        int n = arr.length;

        for(int i=0;i<=n;i++)
        {
            //pop out all element which is greater than current element or reach out of boundary
            while(!st.isEmpty() && (i==n || arr[i] < arr[st.peek()]))
            {
                int idx = st.pop();

                //left element count from current popout idx to prev smaller element
                int left;
                //if after pop out stack empty no left smaller element found
                if(st.isEmpty())
                left=idx - -1;
                else
                left=idx - st.peek();


                //right element count from current idx to current pop out idx
                int right = i  - idx;

                //count freq of subarray in which current pop out idx element
                //is smaller
                int freq = left * right;

                //add sum of minimum current idx element 
                ans+=(freq * (long)arr[idx])%mod;
                ans%=mod;
            }

            //current element idx push into stack
            st.push(i);
        }

        return (int)ans;
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

        sc.close();
        int ans = sumSubarrayMins(arr);
        System.out.println("Total sum of minimum elements in a each subarray is " + ans);
      
    }
}