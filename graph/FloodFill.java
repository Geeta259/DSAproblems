/*
Flood fill algorithm
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 
start from given cell and change that all cell color
 (which connected to starting cell and contain same color as initial cell) to given modified color

 //can be solved either bfs or dfs
*/
import java.util.*;

class FloodFill{
    public static void dfs(int[][] image,int r,int c,int color,int init,int row,int col)
    {
        //fill current cell with given color
        image[r][c] = color;

        //check for four direction
        int x[] = {0,-1,0,1};
        int y[] = {-1,0,1,0};

        //traverse four direction
        for(int i=0;i<4;i++)
        {
            int drow = r + x[i];
            int dcol = c + y[i];

            //if it is valid cell and cell contain same color as initial cell and it's not already contain same modifed color then call dfs   
            if(drow>=0 && drow<row && dcol>=0 && dcol<col && image[drow][dcol]==init && image[drow][dcol]!=color)
            dfs(image,drow,dcol,color,init,row,col);
        }
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of row & no  of column of grid");
        int row = sc.nextInt();
        int col = sc.nextInt();
      
        int grid[][] = new int[row][col];
        System.out.println("Enter numeric value in a grid");
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                grid[i][j] = sc.nextInt();
            }
       }

       System.out.println("Enter no of row & no  of column of starting cell");
       int srcr = sc.nextInt();
       int srcc = sc.nextInt();

       System.out.println("Enter modifed color value which you want to fill in a grid");
       int color = sc.nextInt();

         //dfs call with starting grid given row and column

        //change all cell which connected to starting cell and contain same color with given color
        dfs(grid,srcr,srcc,color,grid[srcr][srcc],row,col);
        

        //print modified grid image
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            System.out.print(grid[i][j]+" ");

            System.out.println();
        }
    }
}