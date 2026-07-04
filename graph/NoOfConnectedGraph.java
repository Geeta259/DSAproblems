/*
Number of Provinces 
(connected or unconnected no of graph)

There are n cities. Some of them are connected, while some are not.
 If city a is connected directly with city b, and city b is connected directly with city c,
 then city a is connected indirectly with city c.
 */
import java.util.*;

public class NoOfConnectedGraph
{
    //dfs traversal for connected graph
    public static void dfs(int[][] isConnected , int visited[] ,int nodes)
    {
        //make current node visited
        visited[nodes] = 1;
       
        //go through all connected nodes depth wise     
        for(int j=0;j<isConnected[nodes].length;j++)
        {
            //if it not visited before and it connected  call dfs from that node
            if(visited[j]==0 && isConnected[nodes][j]==1)
            dfs(isConnected,visited,j);
        }
    }

    //function count no of connnected graph 
    public static int findConnected(int[][] isConnected) {
        //length of nodes how many nodes in a graph
        int nodes = isConnected.length;

        //visited  array to tarck of each node visited or not
        int visited[] = new int[nodes];

        //count connected graph
        int count=0;

        //check each node one by one
        for(int i=0;i<nodes;i++)
        {
            //if nodes not visited 
            if(visited[i]==0)
            {
                //call dfs visited all nodes which connected through start ith node
                 dfs(isConnected,visited,i);

                 //increment count by one to visited next connected graph
                 count++;
            }
           
        } 

        //return count of connected graph
        return count;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of vertices");
        int n = sc.nextInt();
      
        int edges[][] = new int[n][n];
        System.out.println("Enter value for each connected node if connected 1 else 0");
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter connected value for "+i+" node if connected 1 otherwise 0");
            for(int j=0;j<n;j++)
            edges[i][j] = sc.nextInt();
        }

       int count = findConnected(edges);
      System.out.println("Total no of connected graph is " + count);
    }
}