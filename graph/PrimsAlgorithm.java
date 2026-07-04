/*
Minimum Spanning Tree
Given a weighted, undirected and connected graph of V vertices and E edges. 
The task is to find the sum of weights of the edges of the Minimum Spanning Tree.
 Given adjacency list adj as input parameters . Here adj[i] contains vectors of size 2, 
 where the first integer in that 
vector denotes the end of the edge and the second integer denotes the edge weight.

using prims algorithm 
*/
import java.util.*;

public class PrimsAlgorithm
{    
    static int spanningTree(int V, int E, int edges[][]){
	   
        //create  adjacency list
        ArrayList<ArrayList<Pair6>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        adj.add(i,new ArrayList<>());
        
        for(int i=0;i<E;i++)
        {
            adj.get(edges[i][0]).add(new Pair6(edges[i][1],edges[i][2]));
             adj.get(edges[i][1]).add(new Pair6(edges[i][0],edges[i][2]));
        }
        
        //priorityqueue used to first find shortest  distance edges
        PriorityQueue<Pair6> pq = new PriorityQueue<>((x,y)->x.dist-y.dist);
        
        //visited array to check node is already visited or not
        int visited[] = new int[V];
        
        int sum = 0;
        //starting from 0 node add into pq with distance  0 
        pq.offer(new Pair6(0,0));
        
        //traverse until priorityQueue is not empty
        while(!pq.isEmpty())
        {
            //get nodes which contain minimum distance
            Pair6 pa = pq.poll();
            int node = pa.node;
            int dist = pa.dist;
            ///check  it already part of mst or not previously visited or not
            if(visited[node]==0)
            {
                //if not already visited add distance in sum
                sum+=dist;
                //mark it visited that node
                visited[node]=1;
                //go through all adjacent nodes and if it not visited 
                for(Pair6 p : adj.get(node))
                {
                    //check  visited or not
                    if(visited[p.node]==0)
                    {
                        //if it not visited add into priorityqueue
                        pq.offer(new Pair6(p.node,p.dist));
                    }
                }
            }
        }
        
        //return minimum sum
        return sum;
     }
     
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
	 System.out.println("Enter no of vertices");
        int n = sc.nextInt();
        System.out.println("Enter no of edges");
        int e = sc.nextInt();

        int edges[][] = new int[e][3];
        System.out.println("Enter pair of nodes in which edges are connected with distance");
        for(int i=0;i<e;i++)
        {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        int mindist = spanningTree(n,e,edges);
        System.out.println("Minimum sum of spanning tree is " + mindist);
       
    }
}