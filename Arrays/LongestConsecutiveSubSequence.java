/*
 Longest consecutive subsequence
 Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the
  subsequence are consecutive integers,
  the consecutive numbers can be in any order.

  Input:
N = 7
a[] = {2,6,1,9,4,5,3}
Output:
6
Explanation:
The consecutive numbers here
are 1, 2, 3, 4, 5, 6. These 6 
numbers form the longest consecutive
subsquence.
 
 */
import java.util.*;

class LongestConsecutiveSubSequence
{


    static int findLongConsecutiveElem(int arr[], int N)
	{
	   // add your code here
	   //find max value in array element
	   int max=Integer.MIN_VALUE;
	   for(int i=0;i<N;i++)
	   {
	       if(arr[i]>max)
	       max=arr[i];
	   }
	   
	   //declare a frquency array from 0 to max+1
 	   int freq[] = new int[max+1];
	   for(int i=0;i<N;i++)
        freq[arr[i]]+=1;
        
        int count=0,maxconsec=0;
        
        for(int i=1;i<freq.length;i++)
        {
            //traverse to frequency array count consecutive numbers present into array
            if(freq[i]>=1)
            count++;
            else
            {
                //if any no not present consecutive break compare with maxconsecutive no if it greater than max update max and count next consecutive numbers
                if(count>maxconsec)
                maxconsec=count;
                
                count=0;
            }
        }
        
        //after exit from loop also compare last consecutive count with maxconsec if it greater than update
        
        if(count>maxconsec)
        maxconsec=count;
        
        //return maxconsecutive  numbers 
        return maxconsec;
	}


    public static void main(String ar[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

       System.out.println("Enter elements in an array");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

       
        sc.close();
      
        int res = findLongConsecutiveElem(arr,n);

        System.out.println("The length of the longest sub-sequence is "+res);
      
        
    }
}