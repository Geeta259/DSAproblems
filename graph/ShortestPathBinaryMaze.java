/*

*/
import java.util.*;
class Pair7
{
    int row,col,dist;
    Pair7(int row,int col,int dist)
    {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
public class ShortestPathBinaryMaze
{    
	public static int shortestPathBinaryMatrix(int[][] grid) {
        
        //to find shortest distance to reach destination cell a queue is required
        //no  need to use priority queue here because from goes to one cell to another cell a 1 unit required constant

        int n = grid.length;

         //if source cell or destination cell contain 1 no way  to move further if 0 in source or can not reached destiantion cell if it conatin 1 
        if(grid[0][0]==1 || grid[n-1][n-1]==1)
        return -1;

        //if it contain only one cell source and destination cell are same
        if(n==1)
        return 1;

        Queue<Pair7> que = new LinkedList<>();
        //add source cell (0,0) into queue with distance 0
        que.offer(new Pair7(0,0,1));

        //distance array required to  check cell already contained min distance or not
        int[][] distance = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            distance[i][j] = (int)1e9;
        }

        //array for 8 directions 
        int x[] = {0,-1,-1,-1,0,1,1,1};
        int y[] = {-1,-1,0,1,1,1,0,-1};
        //traverse until queue is not empty or reach at destination cell
        while(!que.isEmpty())
        {
            //poll out pair from queue one by one
            Pair7 pa = que.poll();
            //move into 8 direction find valid cell if valide update with min distance if required 
            int r = pa.row;
            int c = pa.col;
            int d = pa.dist;

            for(int i=0;i<8;i++)
            {
                int xr = r + x[i];
                int yc = c + y[i];


                       //if it is required destination cell and conntain minimum distance of parent cell increement by 1 to reach destination adjacent cell
                  if(xr==n-1 && yc==n-1)
                  return d+1;

                //check valid or not and current distance is minimum then only updated and push into queue
                if(xr>=0 && xr<n && yc>=0 && yc<n && grid[xr][yc]==0 && distance[xr][yc] > d+1)
                {
                    //it is valid cell and contain max distance then current distance updated with min distance

                    distance[xr][yc] = d+1;
                    que.offer(new Pair7(xr,yc,d+1));
                }
            }
        }

        //if not reach at destiantion cell return -1
        return -1;

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

	   	int shortest = shortestPathBinaryMatrix(grid);

         System.out.println("Shortest distance to reach to destination node is " + shortest);
        
    }
}