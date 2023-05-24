/*
Sort an array of 0s, 1s and 2s
Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.

Approach
1)use 3 pointer low use for 0 element , i used for iteration , high use for 2 element
2)if current element 0 swap with low pointer and increment both pointer i and low because 0 fill always at start
3)  if current element 2 swap with high pointer and decrement high pointer because 2 fill always at last
4) if current element 1 no need to swap just incrment i by one
 */

import java.util.*;

class Sort012
{

    public static void sort(int[] nums,int n) {
        int low=0,i=0,high=n-1;

        while(i<=high)
        {
            if(nums[i]==0)
            {
                //replace with low
                nums[i] = nums[low];
                nums[low] = 0;
                low++;
                i++;
            }
            else if(nums[i]==2)
            {
                nums[i] = nums[high];
                nums[high] = 2;
                high--;
            }
            else
            i++;
        }
    }
   
     public static void main(String ar[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

       System.out.println("Enter 0 ,1 and 2 elements in a array in any order");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        sc.close();

        sort(arr,n);
        System.out.println("Arrays after sort 0 , 1 and 2 is");
        for(int i=0;i<arr.length;i++)
        System.out.print(arr[i]+" ");
        
    }
}