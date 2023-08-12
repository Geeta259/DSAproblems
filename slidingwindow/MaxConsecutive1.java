import java.util.*;
class MaxConsecutive1
{
    public static int longestOnes(int[] nums, int k) {
        //two pointer variable used to check starting and ending position of sub 
        int i=0,j=0;
        //variable use to count no of zero in a subarray
        int count0=0,max=0;
        while(i<nums.length && j<nums.length)
        {
            //if current number is 1 expand window size
            if(nums[j]==1)
            j++;
            else
            {
                //if it is not 1 it is 0 increment couny0
                count0++;

                //check if it greater than k means can not include in current window size
                if(count0 > k)
                {
                    //get size of current window
                    max = Math.max(max,j-i);
                    //check starting index value of current window if it is 0 
                    if(nums[i]==0)
                    {
                        //decrement count0 now current 0 can add into next window
                        count0--;
                        //expand window size
                        j++;
                    }
                    //increment i 
                    i++;

                }
                //if able to convert 0 to 1 expand window size 
                else
                j++;
            }
        }
        //get maximum of last window size
        max = Math.max(max,j-i);
        //return max subarray
        return max;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of array");
        int n = sc.nextInt();

        System.out.println("Enter no of elements either 0 or 1 in an array");
        int arr[] = new int[n];

        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        System.out.println("No of at most 0 flip in substring");
        int k = sc.nextInt();

        sc.close();
        
        int max = longestOnes(arr,k);
        System.out.println("Length of longest subarray of 1's is after flip at most "+ k + "zeros " + max);

    }
}