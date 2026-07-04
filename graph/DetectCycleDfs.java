/*
 * Detect cycle in an undirected graph
Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 

Approach:
considered each node as a source node if it not visited yet dfs traversal from that node
track adjacent node of polled out node it adjacent node is not a parent node from where it comes and already visited 
means it visited from other node 

same node visited twice from different source node means cycle detected return true otherwise return false
 */
import java.util.*;

public class DetectCycleDfs
{
    public static boolean dfs(int[] visited,ArrayList<ArrayList<Integer>> adj,int src,int parent)
    {
        visited[src]=1;
        for(int adjnode : adj.get(src))
        {
            //if adjacent node is visited
            if(visited[adjnode]==1)
            {
                //if it is not parent
                if(adjnode!=parent)return true;
            }
            else
            {
                if(dfs(visited,adj,adjnode,src))return true;
            }
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        //dfs is used to detect cycle in a graph
        
        //visited array to detect which node is visited and which not
        int visited[] = new int[V];
        
        //it necessary if graph contained different components if it is connected with single components no need this  loop
        for(int i=0;i<V;i++)
        {
            //if it is not visited check dfs call for that node to detect cycle
            if(visited[i]==0)
            {
                //if dfs call return true means cycle exist in a graph return true
                if(dfs(visited,adj,i,-1))
                return true;
            }
        }
        
        //otherwise cycle does not exist return false
        return false;
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
 
        if(isCycle(n,arr))
        System.out.println("Cycle detected in given graph");
        else
        System.out.println("Cycle not detected in given graph");
    }
}