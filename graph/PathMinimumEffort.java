/*
Path With Minimum Effort
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, 
where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0),
 and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed).
  You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.


first find maximum absolute difference of two consecutive cells and stored minimum out of it
*/
import java.util.*;
class Pair8
{
    int row,col,effort;
    Pair8(int row,int col,int effort)
    {
        this.row = row;
        this.col = col;
        this.effort= effort;
    }
}
public class PathMinimumEffort
{    
    public static int minimumEffort(int heights[][]) {
        //to find minimum effort to react at destination Dijkstra is used becuase here efforts vary from one cell to another cell

       int n = heights.length;
       int m = heights[0].length;
       //priority queue used to store Pair8 
       PriorityQueue<Pair8> pq = new PriorityQueue<>((x,y)->x.effort-y.effort);

       //effort matrix used to store minimum efforts to reach at cell
       int efforts[][] = new int[n][m];

       //filled with maximum efforts
       for(int i=0;i<n;i++)
       {
           for(int j=0;j<m;j++)
           efforts[i][j] = (int)1e9;
       }

       //add source  cell into  pq with efforts 0 and update effort matrix
       pq.offer(new Pair8(0,0,0));
       efforts[0][0] = 0;

       //direction array to traverse into 4 direction
       int x[] = {0,-1,0,1};
       int y[] = {-1,0,1,0};
       //traverse until queue is not empty
       while(!pq.isEmpty())
       {
           //polled out Pair8 from queue
           Pair8 pa = pq.poll();
           int r = pa.row;
           int c = pa.col;
           int e = pa.effort;

           //check  it is destination cell return efforts of that cell
           if(r==n-1 && c==m-1)
           return e;

           //traverse into 4 direction
           for(int i=0;i<4;i++)
           {
               int xr = r + x[i];
               int yc = c + y[i];

               //check valid cell
               if(xr>=0 && xr<n && yc>=0 && yc<m)
               {
                   //get efforts to reach this cell
                   int geteffort = Math.max(e , Math.abs(heights[xr][yc] - heights[r][c]));
                   if(geteffort < efforts[xr][yc])
                   {
                       //update with minimum efforts  in cell and push into pq
                       efforts[xr][yc] = geteffort;
                       pq.offer(new Pair8(xr,yc,geteffort));
                   }

               }
           }

       }
       //for sure we reached at end cell default value it will return 0 
       return 0;
   }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of row & no  of column of grid");
        int row = sc.nextInt();
        int col = sc.nextInt();
      
        int grid[][] = new int[row][col];
        System.out.println("Enter value for grid for empty 0  for fresh 1 for rotten 2");
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                grid[i][j] = sc.nextInt();
            }
       }

	   	int effort = minimumEffort(grid);
         System.out.println("Minimum efforts to reach to destination cell is " + effort);
        
    }
}