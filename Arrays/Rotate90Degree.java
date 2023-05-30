/*
Rotate by 90 degree

 Given a square matrix of size N x N. The task is to rotate it by 90 degrees in anti-clockwise direction 
 without using any extra space. 

 Input:
N = 3 
matrix[][] = {{1, 2, 3},
              {4, 5, 6}
              {7, 8, 9}}
Output: 
Rotated Matrix:
3 6 9
2 5 8
1 4 7


Approach
1) As we can clearly see rows of original matrix becomes column of resulatant matrix and column of original matrix becomes rows of resultant matrix
2)Transpose of original matrix
3)REverse the matrxi by rows wise

 */
import java.util.*;

class Rotate90Degree
{
    public static void rotateby90(int matrix[][], int n) 
    { 
        // code here
        //transpose matrix
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        //reverse matrxix by rows wise
        for(int start=0,end=n-1;start<end;start++,end--)
        {
            for(int j=0;j<n;j++)
            {
                int temp = matrix[start][j];
                matrix[start][j] = matrix[end][j];
                matrix[end][j] = temp;
            }
        }
    }

    public static void main(String ar[])
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter size of n*n square matrix");
        int size = sc.nextInt();

        
        int matrix[][]= new int[size][size];
       System.out.println("Enter elements in an matrix");
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            matrix[i][j] = sc.nextInt();
        }
       
        sc.close();
      
        rotateby90(matrix,size);

        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            System.out.print(matrix[i][j]+" ");

            System.out.println();
        }
       
       
      
        
    }
}