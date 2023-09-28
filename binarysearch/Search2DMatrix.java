/*
Search a 2D Matrix
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

here all elements in a matrix in a sorted order

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true


//if previous row last element not necessary less than starting element of current row
in this case use two pointer approach start from last column and first row

 
 */
/*
 *   for(int i=0,j=M-1;i<N && j>=0;)
        {
            if(X==mat[i][j])
            return 1;
            
            else if(X>mat[i][j])
            {
                i++;
            }else
            j--;
        }
        
        
 */
import java.util.*;

class Search2DMatrix
{
    public static boolean searchMatrix(int[][] matrix, int target) {

        //if whole matrix elements is sorted it treat a sorted array
        //use binary search from 0 to row*col-1 index

        int row = matrix.length;
        int col = matrix[0].length;

        int low = 0,high=(row*col)-1;

        //for get row index element%columnlength 
        //for get col index element/columnlength


        while(low<=high)
        {
            int mid= high-((high-low)/2);
            
            if(matrix[mid/col][mid%col]==target)
            return true;

            else if(matrix[mid/col][mid%col]>target)
            high=mid-1;

            else
            low=mid+1;
        }

        return false;

    }
   

    public static void main(String ar[])
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter size of row of matrix");
        int row = sc.nextInt();

        System.out.println("Enter size of column of matrix");
        int col = sc.nextInt();
        
        int matrix[][]= new int[row][col];
       System.out.println("Enter elements in an matrix");
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            matrix[i][j] = sc.nextInt();
        }
       
        System.out.println("Enter target value which you want to find");
        int k = sc.nextInt();

        sc.close();
      
        if(searchMatrix(matrix,k))
        System.out.println("Target value found!!");
        else
        System.out.println("Target value not found!!");

    }
}