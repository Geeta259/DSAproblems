/*
 *DFS of Graph
You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
 */
import java.util.*;

public class DfsTraversal
{
    //dfs used to traverse a graph
    public static void dfs( ArrayList<ArrayList<Integer>> adj,int start,int[] visited,ArrayList<Integer> ans)
    {
        //traverse  all adjacent nodes of start nodes 
        for(int node : adj.get(start))
        {
            //if that node not visited take it as a starting node go to depth of that node
            if(visited[node]==0)
            {
                //mark  it visited add into ans list
                visited[node]=1;
                ans.add(node);
                //recursive call from that node
                dfs(adj,node,visited,ans);
            }
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of vertices");
        int n = sc.nextInt();
        System.out.println("Enter no of edges");
        int e = sc.nextInt();

        int edges[][] = new int[e][2];
        System.out.println("Enter pair of nodes in which edges are connected");
        for(int i=0;i<e;i++)
        {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

         //arraylist  to store adjacency list of each nodes
         ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

         //initialize 2d arraylist
         for(int i=0;i<n;i++)
         arr.add(i,new ArrayList<>());
 
         //add into list for each edges undirected graph
         for(int i=0;i<edges.length;i++)
         {
             arr.get(edges[i][0]).add(edges[i][1]);
              arr.get(edges[i][1]).add(edges[i][0]);
         }
 
        ArrayList<Integer> ans = new ArrayList<>();
        //visisted array to track of each node
       int visited[] = new int[n];
       visited[0]=1;
       //add starting node into ans list
       ans.add(0);
       //dfs call from starting node 0
       dfs(arr,0,visited,ans);

       //print dfs traversel 
        System.out.println("DFS traversal of given graph is " + ans);
    }
}