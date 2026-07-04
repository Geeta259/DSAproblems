/*
 * 
 * Topological sort using bfs 
 * (kahn's algorithm)
Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.

Approach 
indegree of each node maintained
u----> v indegree v is 1 it indicate that one node comes before than v 


if at any node indegree is 0  means now this node can be placed because no one node is left for placed before than that node
then placed into queue

after polled out from queue and placed in resulatnt make sure indegree decrease by 1 of all adjacent node becuase one dependent node is placed
*/
import java.util.*;

public class TopologicalSortBfs
{    
     //Function to return list containing vertices in Topological order. 
     static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
     {
         // add your code here
         //kahn's algorithm used to get topological sort(bfs)
         
         //queue used to store nodes in a topolocal  order
         Queue<Integer> que = new LinkedList<>();
         
         //indegree array is used to maintain indegree of each node
         int indegree[] = new int[V];
         
         //indegree stored of each node
         for(int i=0;i<V;i++)
         {
              for(int adjnode : adj.get(i))
             indegree[adjnode]++;     
         }
        
         
         
         //all nodes which indegree 0 placed in queue it can be placed at starting
         for(int i=0;i<V;i++)
         {
             if(indegree[i]==0)
             que.offer(i);
         }
         
         //resultant array
         int topo[] = new  int[V];
         int idx=0;
         //traverse into queue until que is not empty
         while(!que.isEmpty())
         {
             int node = que.poll();
             topo[idx++] = node;
             
             //get all adjacent node of polled out node and decrease indegree by 1 because one dependent
             //node removed linked remove
             for(int adjnode : adj.get(node))
             {
                 //linked remove from polled out node
                 indegree[adjnode]--;
                 //if a node indegree becomes zero add into queue now it can be placed in topo sort
                 //all dependent node placed before .
                 if(indegree[adjnode]==0)
                 que.offer(adjnode);
             }
         }
         
         return topo;
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