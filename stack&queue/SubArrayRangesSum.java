/*
 Sum of Subarray Ranges
You are given an integer array nums. The range of a subarray of nums is the difference 
between the largest and smallest element in the subarray.
Return the sum of all subarray ranges of nums.
A subarray is a contiguous non-empty sequence of elements within an array.
*/
import java.util.*;

class SubArrayRangesSum
{
    public static void findNSL(int[] nums,int[] nsl)
    {
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<nums.length;i++)
        {
            while(!st.isEmpty()  && nums[st.peek()] >= nums[i])
            st.pop();

            if(st.isEmpty())nsl[i]=-1;
            else  nsl[i]=st.peek();

            st.push(i);
        }
    } 
       public static void findNSR(int[] nums,int[] nsr)
    {
        Stack<Integer> st= new Stack<>();
        for(int i=nums.length-1;i>=0;i--)
        {
            while(!st.isEmpty()  && nums[st.peek()] > nums[i])
            st.pop();

            if(st.isEmpty())nsr[i]=nums.length;
            else  nsr[i]=st.peek();

            st.push(i);
        }
    }
     public static void findNGL(int[] nums,int[] ngl)
    {
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<nums.length;i++)
        {
            while(!st.isEmpty()  && nums[st.peek()] <= nums[i])
            st.pop();

            if(st.isEmpty())ngl[i]=-1;
            else  ngl[i]=st.peek();

            st.push(i);
        }
    } 
       public static  void findNGR(int[] nums,int[] ngr)
    {
        Stack<Integer> st= new Stack<>();
        for(int i=nums.length-1;i>=0;i--)
        {
            while(!st.isEmpty()  && nums[st.peek()] < nums[i])
            st.pop();

            if(st.isEmpty())ngr[i]=nums.length;
            else  ngr[i]=st.peek();

            st.push(i);
        }
    } 
    public static long  findSumSubMin(int[] nums)
    {
            int n = nums.length;
            int[] nsl = new int[n];
            int[]  nsr = new int[n];

            findNSL(nums,nsl);
            findNSR(nums,nsr);

            long sum=0;

            for(int i=0;i<n;i++)
            {
                int left = i-nsl[i];
                int right = nsr[i]-i;

                long total = left*right;
                sum+=(long)(total*nums[i]);
            }
            return sum;
    }

     public static  long  findSumSubMax(int[] nums)
    {
            int n = nums.length;
            int[] ngl = new int[n];
            int[]  ngr = new int[n];

            findNGL(nums,ngl);
            findNGR(nums,ngr);

            long sum=0;

            for(int i=0;i<n;i++)
            {
                int left = i-ngl[i];
                int right = ngr[i]-i;

                long total = left*right;
                sum+=(long)(total*nums[i]);
            }
            return sum;
    }

    public static long subArrayRanges(int[] nums) {
          //in  all  subarray have to find (max-min) + (max-min) + (max-min) +.....
        //sum of subarray max  - (sum of  subarray min)

        long maxsum =findSumSubMax(nums);
        long  minsum= findSumSubMin(nums);

        return maxsum-minsum; 
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
        long ans = subArrayRanges(arr);
        System.out.println("Total sum of subarray ranges is  " + ans);
      
    }
}