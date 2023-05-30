/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.
 
 */
import java.util.*;

class MatrixSetZero
{

    public static void setZeroes(int[][] matrix) {

        int row=matrix.length;
        int col=matrix[0].length;

        //for check first column make it zero or not by taking col1 variable
        int col1=1;

        for(int i=0;i<row;i++)
        {
             if(matrix[i][0]==0)
                //if in any one row first element is zero make whole column zero by update col1=0
                col1=0;

            //start from second column to last column
            for(int j=1;j<col;j++)
            {
                //if in any index 0 found for identification first element of that row and that column make it zero
                if(matrix[i][j]==0)
                {
                    //entire row and entire column make zero identify by making first element of this row and column make zero
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                   
                }
            }
        }


            //now traverse from last row
            for(int i=row-1;i>=0;i--)
            {
                //traverse last column to second column because for first column col1 variable for identification
                for(int j=col-1;j>=1;j--)
                {
                    //if for any index if their first element of that row or that column is zero update its value by zero
                    if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j]=0;

                }

                //if column col1=0 update first element of that row is zero
                if(col1==0)
                matrix[i][0]=0;
            }
        
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
       
        sc.close();
      
        setZeroes(matrix);

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            System.out.print(matrix[i][j]+" ");

            System.out.println();
        }
       
       
      
        
    }
}