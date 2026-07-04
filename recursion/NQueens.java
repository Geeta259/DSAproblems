
import java.util.*;


class NQueens
{
    public static void dfs(int col,char[][] board,List<List<String>> ans,int[] left,int[]upper,int[] lower,int n)
    {
        //break condition
        if(col==board.length)
        {
            List<String> list = new ArrayList<>();
            for(int i=0;i<board.length;i++)
            {   
                //value of ith row of board get as a string
                String s = new String(board[i]);
                list.add(s);
            }

           ans.add(list);
            return;
        }

        for(int row = 0;row<board.length;row++)
        {
            if(left[row]==0 && upper[n-1+col-row]==0 && lower[row+col]==0)
            {
                board[row][col]='Q';
                
                //queen placed at this row
                left[row]=1;
                
                //upper diagonal index queen placed
                upper[n-1+col-row] = 1;

                 //lower diagonal index queen placed
                lower[row+col] = 1;

                //then call for next column
                dfs(col+1,board,ans,left,upper,lower,n);
                //after return back backtracking remove previous placed queen
                //update directions array after remove queen from it
                board[row][col]= '.';
                 left[row]=0;
                 upper[n-1+col-row] = 0;
                lower[row+col] = 0;
            }
        }
    }
    
    public static void main(String args[]) {
        List<List<String>> ans = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of board");
        int n = sc.nextInt();

        sc.close();

        //create a board array of size n*n
        char[][] board = new char[n][n]; 

        //initialize board array with '.'
        for(int i=0;i<n;i++)
        Arrays.fill(board[i],'.');

        //create three array for left position,upperdiagonal , and for lower diagonal
        //n row is present to check row position left array
        int left[] = new int[n];;
        //upper & lower diagonals value consist max 2*n-1
        int upper[] = new int[2*n-1];
        int lower[] = new int[2*n-1];

        //start from 0 index and go to the depth
        dfs(0,board,ans,left,upper,lower,n);
        
        System.out.println("All possible path to placed N queens");
        System.out.println(ans);
    }

   
}