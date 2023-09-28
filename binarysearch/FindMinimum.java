/*
Minimum element in a sorted and rotated array
A sorted(in ascending order) array A[ ] with distinct elements is rotated at some unknown point,
 the task is to find the minimum element in it.

 Input:
N = 5
arr[] = {4 ,5 ,1 ,2 ,3}
Output: 1
Explanation: 1 is the minimum element inthe array.


Rotated Array minimum always breaking point
  */

import java.util.*;

class FindMinimum
{
    public static int findMin(int arr[], int n)
    {
        //complete the function here
       //find rotated point
        int i=0,j=n-1,breakpoint=0;
        
        while(i<=j)
        {
            int m = j-((j-i)/2);
            //System.out.println(arr[m]);

            //condition for find breaking point 
            if((m==0 || arr[m]<arr[m-1]) && (m==n-1 || arr[m]<arr[m+1]))
            {
                 breakpoint =m;
                break;
                
            }

            //if mid value greater than end value move to right part to find minimum value 
            else if(arr[m]>arr[j])
            {
                i=m+1;
            }else
            {
                //otherwise move left part to find minimum value
                j=m-1;
            }
        }
        
        //System.out.println(arr[breakpoint]);
        return arr[breakpoint];
    }

    public static void main(String args[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter elements in to array");
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        sc.close();
     
        int res = findMin(arr,n);
        System.out.println("Minimum Element in an array is "+ res);
        
    }
}