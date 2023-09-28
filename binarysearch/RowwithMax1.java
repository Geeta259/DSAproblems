/*
 * 
 * Row with max 1s
 * Given a boolean 2D array of n x m dimensions where each row is sorted.
 *  Find the 0-based index of the first row that has the maximum number of 1's.
 * 
 * 
 * Input: 
N = 4 , M = 4
Arr[][] = {{0, 1, 1, 1},
           {0, 0, 1, 1},
           {1, 1, 1, 1},
           {0, 0, 0, 0}}
Output: 2
Explanation: Row 2 contains 4 1's (0-based
indexing).
 */

import java.util.*;

class RowwithMax1
{
    public static  int binSearch(int arr[], int n) {
        // code here
        int start=0;
        int end=n-1;
        
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(arr[mid]==1 && ( mid==0 || arr[mid-1]==0))
            return n-mid;
            
            else if(arr[mid]==0)
            start=mid+1;
            
            else
            end=mid-1;
        }
        
        return 0;
    }

    public static int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int max1 = 0,maxrow = -1;
        for(int i=0;i<n;i++)
        {
            //for each row use binary search to count 1 because it is sorted 
            int cnt1 = binSearch(arr[i],m);
            //System.out.println(i+" "+cnt1);

            //if current row contain more 1 than max1 update max1 by cnt1 and store current row index 
            if(cnt1>max1)
            {
                max1=cnt1;
                maxrow=i;
            }
            
        }
        
        return maxrow;
    }

    public static void main(String args[])
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter size of row of matrix");
        int row = sc.nextInt();

        System.out.println("Enter size of column of matrix");
        int col = sc.nextInt();
        
        int matrix[][]= new int[row][col];
       System.out.println("Enter elements in a binary matrix contain 0 or 1");
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            matrix[i][j] = sc.nextInt();
        }
        sc.close();

       int rowidx =  rowWithMax1s(matrix,row,col);
        if(rowidx!=-1)
        System.out.println("Max 1's found in row " + rowidx);
        else
        System.out.println("No row found having element at least one '1'");
    }
}