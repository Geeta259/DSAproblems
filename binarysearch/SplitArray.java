/*
Split Array Largest Sum

Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.
 
*/

import java.util.*;

class SplitArray
{
 
    public static  int isPossible(int[] arr,int maxsum)
    {
        int count=1,total=0;
        for(int i=0;i<arr.length;i++)
        {
            //if  current element  is greater  than  maxsum have to  increase  maxsum -->right  side-->for  this return  max  value of  k  partition
            if(arr[i]>maxsum)
            return 51;

            //if it  can not  be accomodate in  a  current  split
            if(total+arr[i] >  maxsum)
            {
                ///increase  count  for  next  split
                count++;
                //update total by current element
                total=arr[i];
            }
            else
            total+=arr[i];
            //otherwise  increase  total in  current split
        }

        //return total no  of  split
       return count;
    }

    //Function to find minimum number of pages.
    public static int splitArray(int[] nums, int k) {
        //min-max problem can think  of  binary search
        //min sum  is min  number in  array and max  sum of  all  numbers
        int low=nums[0],high=0;
        for(int i=0;i<nums.length;i++)
        {
            //lowest  sum is  minimum value
            low=Math.min(low,nums[i]);
            //highest sum  is sum of  all  numbers
             high+=nums[i];
        }
       

        
        while(low<=high)
        {
            //get mid sum considered as  maximum

            int  mid=(low+high)>>1;
           // System.out.println(low+" "+mid+" "+high);

           //get  no  of partition
            int  part = isPossible(nums,mid);
           // System.out.println(mid+" "+part);
            //check is  it  possible to  do  k  partition  when mid  is  largest  sum
            if(part<=k)
            {
                //we want  minimized  largest sum  go  to  left and 
                //if  part  less  than k  to  increase no  of  partition minimize sum
                high=mid-1;
            }
            else
            {
                //if no  of  partition larger  than  k  means it is not maximum sum not  able  to k  partition
                //go  to  right to  get  k partition and increase sum
                //low indicate mid+1  which  may  be  minimum of maximum sum 
                //before it  not getting any  maximum sum  of  k  -  partition
                low=mid+1;
            }
        }

        //low pointer  contain  minimmum  of  maximum sum
        return  low;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size  of  array");
        int n =sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter a element in a array");
        for(int i=0;i<n;i++)
        arr[i] =sc.nextInt();

        System.out.println("Enter a no of splits");
        int k =sc.nextInt();

         sc.close();
     
        int res = splitArray(arr,k);
        System.out.println("Minimum no of sum of array to get k-splits  is " + res);
        
    }
}