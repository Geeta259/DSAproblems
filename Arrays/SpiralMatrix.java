/*
spiral matrix
Given an m x n matrix, return all elements of the matrix in spiral order.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

1 2 3
4 5 6
7 8 9

1 2 3 6 9 8 7 4 5
 */
import java.util.*;

class SpiralMatrix
{
  
    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        List<Integer> arr = new ArrayList<Integer>();

        //declare a four pointer left,right,top,bottom
        int left=0,right=col-1,top=0,bottom=row-1;

        while(left<=right && top<=bottom)
        {
            //traverse left to right add top elements in to list then top increment by one
            for(int j=left;j<=right && top<=bottom;j++)
            {
                  arr.add(matrix[top][j]);
                  
            }
              top++;

         //traverse top to bottom add rightmost column elements in to list then right decrement by one
            for(int i=top;i<=bottom && left<=right;i++)
            {
                arr.add(matrix[i][right]);
            }
            right--;
          
           //traverse right to left add bottom elements in to list then bottom decrement by one

            for(int j=right;j>=left && top<=bottom;j--)
            {
                arr.add(matrix[bottom][j]);
            }

            bottom--;
           
         //traverse bottom to top add leftmost column elements in to list then left increment by one

            for(int i=bottom;i>=top && left<=right;i--)
            arr.add(matrix[i][left]);

            left++;
          
          
         }

         return arr;

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
      
        List<Integer> arr = new ArrayList<Integer>();
        arr = spiralOrder(matrix);

        System.out.println(arr);
    }
}