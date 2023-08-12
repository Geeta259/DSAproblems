/*
 *  Binary subarray with sum
 * 
 * get all subarray having target sum
 * Approach used:
 * Get all subarray having at most target sum minus
 * All subarray having at most target-1 to get exactly those subarray having exactly target sum
 */
import java.util.*;
class BinarySubArraySum
{
    public static int countSubArray(int arr[],int N,int target)
    {
        //count total no of subarray having atmost target sum
        int i=0,j=0,count=0,sum=0;
        while(i<=j && j<N)
        {
            //add current element into sum
            sum+=arr[j];
            
            //check sum is greater than target
            while(sum > target)
            {
                //shrink window remove element from head until sum greater than target
                sum-=arr[i];
                i++;
            }
            
            //get number of subarray and expand window
            count+=(j-i+1);
            j++;
        }
        
        return count;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of array");
        int n = sc.nextInt();

        System.out.println("Enter binary number in an array");
        int arr[] = new int[n];

        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        System.out.println("Enter target sum of each subarray");
        int target = sc.nextInt();

        sc.close();
        
          //count total  no of subarray having at most target value
          int totalK = countSubArray(arr,n,target);   
          //count total no of subarray having at most target-1 value
          int count = countSubArray(arr,n,target-1);
          
          //total subarray having  at most k - total subarray having at most k-1
        int res =  totalK - count;
        System.out.println("Total no of subarray having target value is " + res);

    }
}