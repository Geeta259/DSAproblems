/*
 Find a Peak Element II
 A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].        
 
Approach :
1) Use binary search (either row wise or column wise) from first index to last index
here use row  wise  binary search
2) Go to middle row find  maximum element of that row  check top down element from maximum element according to that go top row or bottom row
-> if middle row is first row (0  index) have to check only bottom row element from maximum element because there is not any row above 
-> if middle row is last row have to  check only previous row element  because there is not any below row;

if maximum element of middle row is greater from top and below element  then it is pivot element because it is obvious greater from left and right element that's why we find maximum element of that row. 

*/
import java.util.*;

class FindPeak2DMatrix
{
    
    public static int[] findPeakGrid(int[][] mat) {
        //binary search row wise 
        int l=0,h=mat.length-1;

        while(l<=h)
        {
            int midrow = h-((h-l)/2);
            //maximum element find of that row
            int rowmaxidx = findMaxElement(mat[midrow]);
            //check left right top and bottom of rowmax element

            //if midrow is first row no top check
            if(midrow==0)
            {
                //left and right check not needed in a row because we find max element of that row at this posiiton only bottom value check

                 if(mat[midrow][rowmaxidx]>mat[midrow+1][rowmaxidx])
                 return new int[]{midrow,rowmaxidx};
            }

              //if midrow is last row no bottom check top value will be check
            else  if(midrow==(mat.length-1))
            {
                 if(mat[midrow][rowmaxidx]>mat[midrow-1][rowmaxidx])
                 return new int[]{midrow,rowmaxidx};
            }

            //if midrow is in between check top and bottom value if it greater than both it is a peak element
            else
            {
                    if(mat[midrow][rowmaxidx]>mat[midrow+1][rowmaxidx] && mat[midrow][rowmaxidx]>mat[midrow-1][rowmaxidx])
                 return new int[]{midrow,rowmaxidx};
            }


            //if not any one case above is true go either top or bottom

           if(mat[midrow][rowmaxidx]<mat[midrow-1][rowmaxidx])
            h=midrow-1;
            else
            l=midrow+1;

        }
        return new int[]{-1,-1};
    }

    public static int findMaxElement(int arr[])
    {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int idx=-1;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
                idx=i;
            }
            
        }

        return idx;

    }

    public static void main(String ar[])
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter size of row of matrix");
        int row = sc.nextInt();

        System.out.println("Enter size of column of matrix");
        int col = sc.nextInt();
        
        int matrix[][]= new int[row][col];
       System.out.println("Enter elements in a matrix");
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            matrix[i][j] = sc.nextInt();
        }
       
        sc.close();
      
        int res[] = new int[2];
        res = findPeakGrid(matrix); 
        if(res[0]!=-1 && res[1]!=-1)
        System.out.println(res[0] + " " + res[1]);
        else
        System.out.println("Not any peak element found in matrix");

    }
}