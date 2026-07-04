/*
Rotting Oranges
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

to find total min time use bfs  simulatneously rotten all fresh orange 
 */
import java.util.*;
//create a pair class to store pair in queue
class Pair
{
    int row,col,time;
    Pair(int r,int c,int t)
    {
        row=r;
        col=c;
        time=t;
    }
}
class RottenOrange{
    public static int orangesRotting(int[][] grid) {
        //craete a queue to store rotten oranges with time

        //n*m space 
        Queue<Pair> que = new LinkedList<>();
        //traverse and store  initial rotten oranges in a queue with time 0
        int row = grid.length;
        int col = grid[0].length;

        //create a visited matrix  which indicate which cell already visited or rottated
        //n*m space
        int visited[][] = new int[row][col];

        //count total no of fresh cell
        int cntfresh=0;

        //all initial rotten orange store into queue with time 0
        //n*m time
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                //if it is rotten cell
                if(grid[i][j]==2)
                {
                    //add into queue with time 0 and mark it visited
                    que.add(new Pair(i,j,0));
                    visited[i][j]=2;
                }
                if(grid[i][j]==1)
                cntfresh++;
            }
        }

        //create four directional array
        int x[] = {0,-1,0,1};
        int y[] = {-1,0,1,0};

        //time store to rotten all fresh orange
        int time = 0;

        //count all fresh orange which becomes rotten
        int count=0;

        //traverse until queue is not empty
        //que store at max n*m cell 
        while(!que.isEmpty())
        {
           Pair pa = que.poll();
           int r = pa.row;
           int c = pa.col;
           int t = pa.time;

            
            time = Math.max(time,t);


            //go to all 4 direction 
            //total time 4*n*m
           for(int i=0;i<4;i++)
           {
               int drow = r + x[i];
               int dcol = c + y[i];

               if(drow>=0 && drow<row && dcol>=0 && dcol<col && visited[drow][dcol]==0 && grid[drow][dcol]==1)
               {
                   //if cell contain fresh orange in a direction and not visited yet 
                   //mark it visited and store into queue with increment time
                   visited[drow][dcol]=2;
                   que.add(new Pair(drow,dcol,t+1));
                   //increment count one fresh orange becomes rotted
                   count++;
               }
           }
        }


        //check all fresh orange becomes rotten or not
        if(cntfresh!=count)
        return -1;
        else
        return time;

        //overall time complexity n*m
        //overall space complex n*m
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

       int time = orangesRotting(grid);
       if(time!=-1)
      System.out.println("Total no of minimum time to rotten all fresh oranges is " + time);
      else
      System.out.println("Cannot rotten all fresh oranges");
    }
}