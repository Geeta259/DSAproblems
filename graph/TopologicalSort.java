/*
 * 
 * Topological sort
Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.


 */
import java.util.*;

public class TopologicalSort
{    
    public static void dfs(ArrayList<ArrayList<Integer>> adj,int node,int[] visited,Stack<Integer> st)
    {
        //mark it visited
        visited[node] = 1;
        
        //get adjacent node of given node
        for(int adjnode : adj.get(node))
        {
            //if it is not visited call dfs from that node
            if(visited[adjnode]==0)
            {
                dfs(adj,adjnode,visited,st);
            }
        }
        
        //while return back source node push into stack
        st.push(node);
    }
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
       //use dfs to get one of the linear ordering of graph
       //stack is used to get topological sort
       Stack<Integer> st = new Stack<>();
       //create visited array
       int[] visited = new int[V];
       
       //traverse through each node
       for(int i=0;i<V;i++)
       {
           //check if it visited or not
           if(visited[i]==0)
           {
               //if not visited call dfs from that node
               dfs(adj,i,visited,st);
           }
       }
       
       
       //create array which store linear ordering
        int[] ans = new int[V];
        int idx=0;
        while(!st.isEmpty())
        {
            ans[idx++] = st.pop();
        }
        
        //return ans array
        return ans;
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
 
         System.out.println("One of the linear ordering of given graph is ");
        int ans[] = topoSort(n,arr);
        for(int i=0;i<ans.length;i++)
        System.out.print(ans[i] + " ");
    }
}