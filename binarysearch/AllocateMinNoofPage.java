/*
Allocate minimum number of pages
You have N books, each with Ai number of pages. M students need to be allocated contiguous books, 

with each student getting at least one book. Out of all the permutations, the goal is to find the permutation 
where the student with the most pages allocated to him gets the minimum number of pages, out of all possible permutations.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order 
(see the explanation for better understanding).

 
*/

import java.util.*;

class AllocateMinNoofPage
{
 
    public static boolean CanBookAllocatedAll(int A[],int m,int maxpage)
    {
        int countpages=0,countstudent=1;
        //beacuse maximum barrier is defined if in any book greater pages than barried
         for(int i=0;i<A.length;i++)
        {
            //if any book have page greater than maxpage return false can not allocate this book to any student
              if(A[i]>maxpage)
               return false;
        
            //if by adding a new book exceed maxpage can not allocated to a current student 
             if(countpages+A[i]>maxpage)
            {
                //allocated to a new student
                countstudent++;
                countpages=A[i];
            }else
            countpages+=A[i];
        }
        
        //if total student greater than m children 
        
       // System.out.println(m+" "+countstudent+" "+maxpage);
        if(countstudent>m)
        return false;
        
        return true;
    }
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        //minimum pages allocated to a student is min element of array
        //maximum pages allocated to a student is all books (sum of all books pages)
        //searched space lies between minimum to maximum
        
        //atleast one book allot to a student
        //if no of student greater than no of books return false
        if(M>N)
        return -1;
        
        int low=Integer.MAX_VALUE;
        int high=0;
        for(int i=0;i<N;i++)
        {
            if(A[i]<low)
            low=A[i];
            
            high+=A[i];
        }
        
        int ans=-1;
        while(low<=high)
        {
            //maximum (mid) pages allocated to a student
            //check can we allocated a book to all M student
            int mid = (low+high)/2;
            if(CanBookAllocatedAll(A,M,mid))
            {
               // System.out.println(mid);
                ans=mid;
                //if able to allocated a book to all student check for minimum pages than this
                high=mid-1;
                
            }else
            low = mid+1;
        }
        
        return ans;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of books");
        int n =sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter a element in a array which indicate no of pages in each books");
        for(int i=0;i<n;i++)
        arr[i] =sc.nextInt();

        System.out.println("Enter a no of student whom you want to allocate a books");
        int k =sc.nextInt();

         sc.close();
     
        int res = findPages(arr,n,k);
        System.out.println("Minimum no of pages of book allocated to a student which is maximum among all possibilites is " + res);
        
    }
}