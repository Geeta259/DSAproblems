/*
 Word Search
 Given a 2D board of letters and a word. Check if the word exists in the board. 
 The word can be constructed from letters of adjacent cells only. ie - horizontal or vertical neighbors.
  The same letter cell can not be used more than once.

  Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

 */
import java.util.*;


class WordSearch
{
    public static boolean checkWord(char[][] board,int i,int j,int row,int col,String word,int wdidx)
    {
        //terminate condition if all words matched 
        if(wdidx>=word.length())
        return true;

        //edge conditions
        if(i<0 || j<0 || i>=row || j>=col || board[i][j]!=word.charAt(wdidx))
        return false;

        //if it is match replace with other character, so that not match further
        board[i][j] = '.';

        //check all other direction to match remaining character if  all direction fail just return false;

        //create an array for ith & jth index
        int x[] ={-1,1,0,0};
        int y[] = {0,0,-1,1};

        boolean flag = false;
        //check next character in a word in 4 direction if in any one direction it found flag contain true
        for(int d=0;d<4;d++)
        flag = flag ||  checkWord(board,i+x[d],j+y[d],row,col,word,wdidx+1);

        //mandatory to put intial character at i,j position in board
        board[i][j] = word.charAt(wdidx);

        //return flag value
        return flag;
    }

    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
       
        System.out.println("Enter a row size");
        int row = sc.nextInt();

        System.out.println("Enter a column size");
        int col = sc.nextInt();

       char[][] board = new char[row][col];
       System.out.println("Enter elements in to grid");
       for(int i=0;i<row;i++)
       {
            for(int j=0;j<col;j++)
            board[i][j] = sc.next().charAt(0);
       }

       sc.nextLine();
       
       System.out.println("Enter word which you want to match in grid");
       String word = sc.nextLine();

        sc.close();

         //traverse through board
         boolean flag = false;
         for(int i=0;i<row;i++)
         {

             for(int j=0;j<col;j++)
             {
                 //check first character if it match then check for remaining character in depth
                 if(board[i][j]==word.charAt(0))
                 {
                     //call function to go in depth to match word character if all character match it will return true
                     if(checkWord(board,i,j,row,col,word,0))
                     {
                        flag = true;
                        break;
                     }
                 }
                 
             }
         }

         if(flag)
         System.out.println("Word found in a grid");
         else 
         System.out.println("Word not found in a grid");
 
       
    }
}