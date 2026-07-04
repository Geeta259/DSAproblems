/*
 Number Of Enclaves
You are given an n x m binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
A move consists of walking from one land cell to another adjacent (4-directionally) land cell 
or walking off the boundary of the grid.


can be solved either bfs or dfs

dfs approach

traverse all boundary top,left,right,bottom if find 1's cell go to depth of it into four direction and mark all visited cell
then check if any 1's cell present in grid which is not visited means there is no way to reach boundary of grid from that cell count that one.


bfs approach
traverse all boundary top,left,right,bottom if find 1's cell add into queue and mark all visited cell
traverse until queue is not empty get 1's cell check into four direction if 1's cell find add into queue
then check if any 1's cell present in grid which is not visited means there is no way to reach boundary of grid from that cell count that one.


*/

import java.util.*;

class Pair4
{
    int r,c;
    Pair4(int r,int c)
    {
        this.r=r;
        this.c=c;
    }
}

class NumberOfEnclaves{
  
    static int numberOfEnclaves(int[][] grid) {
        //can solved either bfs or dfs
        //solving through bfs
        
        int row = grid.length;
        int col = grid[0].length;
        //queue used to store boundary 1's
        Queue<Pair4> que = new LinkedList<>();
        
        //n*m space complexity
        int  visited[][] = new int[row][col];
        
        //all boundary cell which contain 1's add into queue
        for(int j=0;j<col;j++)
         {
             //if top row contain 1 and not visited mark it visited
             if(grid[0][j]==1 && visited[0][j]==0)
             {
                 visited[0][j]=1;
                 que.offer(new Pair4(0,j));
             }
 
              //if bottom row contain 1 and not visited  mark it visited
              if(grid[row-1][j]==1 && visited[row-1][j]==0)
             {
                 
                 visited[row-1][j]=1;
                 que.offer(new Pair4(row-1,j));
             }
         }
 
         for(int i=0;i<row;i++)
         {
             //if first column contain 1 and not visited  mark it visited
             if(grid[i][0]==1 && visited[i][0]==0)
            {
                visited[i][0]=1;
                 que.offer(new Pair4(i,0));
            }
 
              //if bottom row contain 1 and not visited mark it visited
              if(grid[i][col-1]==1 && visited[i][col-1]==0)
             {
                 visited[i][col-1]=1;
                 que.offer(new Pair4(i,col-1));
             }
         }
         
         //create a direction array
         int x[] = {0,-1,0,1};
         int y[] = {-1,0,1,0};
         
         //pop out from queue until queue is not empty
         //4*n*m time complexity
         while(!que.isEmpty())
         {
             Pair4 pa = que.poll();
             int r = pa.r;
             int c = pa.c;
             
             //check into four direction
             for(int i=0;i<4;i++)
             {
                 int srx = r+x[i];
                 int sry = c+y[i];
                 
               
                if(srx>=0 && srx<row && sry>=0 && sry<col && visited[srx][sry]==0 && grid[srx][sry]==1)
                {
                    visited[srx][sry]=1;
                    que.offer(new Pair4(srx,sry));
                }
             }
         }
 
 
         //count how many 1's in grid which is not viisted through boundary means there is no way to walk off the boundary from that cell
         int count=0;
         for(int i=0;i<row;i++)
         {
             for(int j=0;j<col;j++)
             {
                 //it contain 1 and not visited count that cell
                 if(grid[i][j]==1 && visited[i][j]==0)
                 count++;
             }
         }
         return count;
     }
    

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of row & no  of column of grid");
        int row = sc.nextInt();
        int col = sc.nextInt();
      
        int grid[][] = new int[row][col];
        System.out.println("Enter 0 or 1 value in a grid");
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                grid[i][j] = sc.nextInt();
            }
       }

        int count = numberOfEnclaves(grid);

       System.out.println("Total  no of enclaves is " + count);
    }
}