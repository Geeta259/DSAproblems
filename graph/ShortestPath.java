/*
 Shortest path in Undirected Graph having unit distance
 You are given an Undirected Graph having unit weight, Find the shortest path from src to all the vertex 
 and if it is unreachable to reach any vertex, then return -1 for that vertex.
*/
import java.util.*;

public class ShortestPath
{    
    public static int[] shortestPath(int[][] edges,int n,int m ,int src) {
         
        //create a distance array to store minimum distane from src node to each node
        //initialize with max value
        int distance[] = new int[n];
        int max = (int)1e9;
        Arrays.fill(distance,max);
        
        //create 2d arraylist which store adjacency list 
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0;i<n;i++)
        arr.add(i,new ArrayList<>());
        
        
        for(int i=0;i<m;i++)
        {
            //because it is undirected graph
                  arr.get(edges[i][0]).add(edges[i][1]);
                  arr.get(edges[i][1]).add(edges[i][0]);
        }
  
        //use bfs to travel distance wise from source node
        Queue<Integer> que = new LinkedList<>();
        
        //source node add into queue 
        que.offer(src);
        distance[src] = 0;
        
        //traverse until queue is not empty
        while(!que.isEmpty())
        {
            int node = que.poll();
            //check all adjacent node and update distance array with min distance
            for(int adjnode : arr.get(node))
            {
                //if it previous distance to reach that node greater than current distance
                //update distance and add into queue with updated value
                if(distance[adjnode] > distance[node]+1)
                {
                           //update distance for adjacent node and add into queue
                           distance[adjnode] = distance[node]+1;
                           que.offer(adjnode);
                }
            }
            
        }
        
        //track all unreachable node and update with -1
        for(int i=0;i<n;i++)
        {
            if(distance[i]==max)
            distance[i]=-1;
        }
        
        //return distance array
        return distance;
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
 
         System.out.println("Enter source node");
         int src = sc.nextInt();

        int distance[] = new int[n];
        distance = shortestPath(edges,n,e,src);


         System.out.println("Shortest distannce to reach all nodes from source node is");
         for(int i=0;i<n;i++)
         System.out.print(distance[i]+" ");
       
    }
}