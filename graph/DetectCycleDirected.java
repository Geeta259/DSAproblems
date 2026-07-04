/*
 * 
 * detect cycle in a directed graph
 * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, 
 * check whether it contains any cycle or not.
 */
import java.util.*;

public class DetectCycleDirected
{    
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj,int[] visited,int[] path,int node)
    {
        //mark it current node visited
        visited[node]=1;
        
        //mark it path visited
        path[node]=1;
        
        //go to all adjacent node of current node
        for(int adjnode : adj.get(node))
        {
            //check it is not visited
            if(visited[adjnode]==0)
            {
                //dfs check from that node
                if(dfs(adj,visited,path,adjnode))return true;
                
                //while return back remove current node from path
                path[adjnode]=0;
            }
            //if it already visited 
            else if(path[adjnode]==1)
            //is it in same path cycle detected return true
              return true;
              
                
            //if visited and not in same path no further call dfs from that node check for another adjacent node
            //from that path already checked before
        
        }
        
        //remove current node from path before return back
         path[node]=0;
        //otherwise return false no cycle detected
        return false;
    }
     // Function to detect cycle in a directed graph.
     public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        //create a visited and path visited array becuase it is directed graph so path should be track
        int visited[] = new int[V];
        int path[] = new int[V];
        
        //traverse through each node becuase graph can contain different components
        for(int i=0;i<V;i++)
        {
            //if it is not visited yet go to depth of that node to check cycle contain or not
            if(visited[i]==0)
            {
                //check dfs return true or false if it return true means cycle detected 
                if(dfs(adj,visited,path,i))return true;
            }
        }
        
        //otherwise return false;
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
              
         }
 
        if(isCyclic(n,arr))
        System.out.println("Given graph is contained cycle");
        else
        System.out.println("Given graph is not contained cycle");
    }
}