/*
 * BFS of graph
Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
 */
import java.util.*;

public class BfsTraversal{
  
     // Function to return Breadth First Traversal of given graph.
     public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        //arraylist which store all nodes in breadth wise
        ArrayList<Integer> bfs = new ArrayList<>();
        //queue used to traverse level order
        Queue<Integer> que = new LinkedList<>();
        
        //starting node added into queue
        que.add(0);
        
        //visited array to track of nodes
        int[] visited = new int[V];
        //starting nodes mark it visited 
        visited[0] = 1;
        
        //traverse until queue is not empty
        while(!que.isEmpty())
        {

            //get nodes from queue
            int temp = que.poll();
            //go through all adjacent node of polled nodes
            for(int node : adj.get(temp))
            {
                //if adjacent node of that node not visited 
                if(visited[node]==0)
                {
                    //add into queue and mark it visited 
                    que.add(node);
                    visited[node]=1;
                }
            }
            //polled out node add into bfs list
            bfs.add(temp);
        }
        
        //return bfs list
        return bfs;
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
 
        ArrayList<Integer> bfs =  bfsOfGraph(n,arr);
        System.out.println("BFS traversal of given graph is " + bfs);
    }
}