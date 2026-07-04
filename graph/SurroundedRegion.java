/*
 Surrounded Regions
Given an m x n matrix board containing 'X' and 'O', capture all regions 
that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

boundary O not will be replaced by x
and all O which connected wiith boundary it also not  replaced by x


for this dfs will use
first find O in boundary top left bottom right
go to depth of that O conatining cell in four direction
mark it visited so that identified it will not be replaced by X

remaining O replaced by X

*/
import java.util.*;

class SurroundedRegion{
  
    public static void dfs(int r,int c,int[][] visited,char[][] board,int row,int col,int x[],int y[])
    {
        visited[r][c]=1;
        for(int i=0;i<4;i++)
        {
            int srx = r + x[i];
            int sry = c + y[i];

            if(srx>=0 && srx<row && sry>=0 && sry<col && visited[srx][sry]==0 && board[srx][sry]=='O')
            {
                dfs(srx,sry,visited,board,row,col,x,y);
            }
        }
    }
    public static void ReplaceO(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        //create a visited matrix to indicate cell is visited or not
        int[][] visited = new int[row][col];

        //traverse into boundaries and mark it visited all 0  connected with boundaries in depth also cannot be converted into X

          //check into four direction
        int x[] = {0,-1,0,1};
        int y[] = {-1,0,1,0};

      
        //top row and bottom row check
        for(int j=0;j<col;j++)
        {
             if(visited[0][j]==0 && board[0][j]=='O')
            {
                //call dfs from that cell
                dfs(0,j,visited,board,row,col,x,y);
            }

              if(visited[row-1][j]==0 && board[row-1][j]=='O')
            {
                //call dfs from that cell
                dfs(row-1,j,visited,board,row,col,x,y);
            }
        }

         //left col and right col check
        for(int i=0;i<row;i++)
        {
            if(visited[i][0]==0 && board[i][0]=='O')
            {
                //call dfs from that cell
                dfs(i,0,visited,board,row,col,x,y);
            }
             if(visited[i][col-1]==0 && board[i][col-1]=='O')
            {
                //call dfs from that cell
                dfs(i,col-1,visited,board,row,col,x,y);
            }
        }

        //traverse into board except boundary check if any O present which is not visited can convert into X 
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(board[i][j]=='O' && visited[i][j]==0)
                {
                      board[i][j] = 'X';
                      visited[i][j] = 1;
                }            
            }
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of row & no  of column of grid");
        int row = sc.nextInt();
        int col = sc.nextInt();
      
        char grid[][] = new char[row][col];
        System.out.println("Enter 'X' or 'O' value in a grid");
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                grid[i][j] = sc.next().charAt(0);
            }
       }

        ReplaceO(grid);
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
              System.out.print(grid[i][j]+" ");
            }
            System.out.println();
       }
    }
}