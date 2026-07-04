
/*
 * Rat in a Maze Problem
 * Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
 */
import java.util.*;
class RatInMaze
{
    public static void dfs(int[][] m ,int n,int i,int j,ArrayList<String> ans,StringBuilder temp)
    {
        //base condition if it reach last index
        if(i==n-1 && j==n-1)
        {
            //if it is not blocked then add into list
            if(m[i][j]!=0)
            ans.add(temp.toString());
            
            //return
            return;
        }
        
        //not move further condition 
        //if any one codition satisfied return back 
        if(i<0 || j<0 || i>=n || j>=n || m[i][j]==0 || m[i][j]==-1)
        return;
        
        //defined four directions with character
        int x[] = {-1,1,0,0};
        int y[] = {0,0,-1,1};
        char ch[] ={'U','D','L','R'};
        
        for(int d=0;d<4;d++)
        {
            //append current index character
              temp.append(ch[d]);
              //mark as visited
              m[i][j] = -1;
              
              //check next possible direction from current source
              dfs(m,n,i+x[d],j+y[d],ans,temp);
              
              //after backtracking remove visited mark
              m[i][j] = 1;
              
              //remove last character from temp
              temp.deleteCharAt(temp.length()-1);
        }
    }
    
    public static void main(String args[]) {
        ArrayList<String> ans = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of maze");
        int n = sc.nextInt();

    

        int[][] maze = new int[n][n];

        System.out.println("Enter elements in to 2d maze either 0 or 1");

        //initialize board array with '.'
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            maze[i][j] = sc.nextInt();
        }
    
            sc.close();
        //start from source index (0,0) index and go to the depth
        dfs(maze,n,0,0,ans,new StringBuilder());
        
        System.out.println("All possible path to reach last node is");
        System.out.println(ans);
    }

   
}