/*
Distance of nearest cell having 1
Given a binary grid of n*m. Find the distance of the nearest 1 in the grid for each cell.
The distance is calculated as |i1  - i2| + |j1 - j2|, where i1, j1 are the row number 
and column number of the current cell, and i2, j2 are the row number and column number of the nearest cell 
having value 1. There should be atleast one 1 in the grid.

Approach:
use bfs to find nearest distance from each cell
inital all 1 placed into queue with distance 0

check in all four direction if near 0 and not visited present add into queue with distance increment by 1

*/
import java.util.*;
class Pair3
{
    int r,c,dist;
    Pair3(int r,int c,int dist)
    {
        this.r=r;
        this.c=c;
        this.dist=dist;
    }
}

class Matrix01{
    //Function to find distance of nearest 1 in the grid for each cell.
    public static int[][] nearest1(int[][] grid)
    {
        //queue used to store pair data
        Queue<Pair3> que = new LinkedList<>();
        
        int row = grid.length;
        int col = grid[0].length;
        
        //create visited array to track which node is visited and which not
        int[][] visited = new int[row][col];
        
        //create distance matrix which store nearest distance of each cell
        int distance[][] = new int[row][col];
        
        //put all initial 1 in queue with distance 0 
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]==1)
                {
                    //mark it visited and placed distance 0 in matrix because it itself nearest cell 
                    //which contain 1's
                    visited[i][j]=1;
                    distance[i][j]=0;
                    que.offer(new Pair3(i,j,0));
                }
            }
        }
        
        
        //direction array to move in 4 direction
        int x[]= {0,-1,0,1};
        int y[] = {-1,0,1,0};
        
        //traverse until queue is not empty
        while(!que.isEmpty())
        {
            //get pair from queue
            Pair3 pa = que.poll();
            int r = pa.r;
            int c = pa.c;
            int dist = pa.dist;
            
            //check in four direction 
            for(int i=0;i<4;i++)
            {
                int srx = r + x[i];
                int sry = c+ y[i];
                
                //check it is valid cell and contain 0 and not visited
                if(srx>=0 && srx<row && sry>=0 && sry<col && visited[srx][sry]==0 && grid[srx][sry]==0)
                {
                    //mark it visited and distance add into cell of distance matrix & add into queue with increment distance by 1
                    visited[srx][sry]=1;
                    distance[srx][sry]=dist+1;
                    que.offer(new Pair3(srx,sry,dist+1));
                }
            }
        }
        
        //return distance matrix
        return distance;
        
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

       int[][] distance = nearest1(grid);
       for(int i=0;i<row;i++)
       {
        for(int j=0;j<col;j++)
        System.out.print(distance[i][j] + " ");

          System.out.println();
       }
     
    }
}