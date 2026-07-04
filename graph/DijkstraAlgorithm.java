/*
implement Dijkstra's shortest path
Find the shortest distance of all the vertex's from the source vertex S. 
You have to return a list of integers denoting shortest distance between each node and Source vertex S.
 
*/
import java.util.*;

class Pair6
{
    //pair stored node with minimum distance
    int node,dist;
    Pair6(int node,int dist)
    {
        this.node = node;
        this.dist = dist;
    }
}
public class DijkstraAlgorithm
{    
     //from the source vertex S.
	 static int[] dijkstra(int V, ArrayList<ArrayList<Pair6>> adj, int S)
	 {
		 //implement dijkstra algorithm to find shortest distance array
		 //this graph is undirected and cyclic not able to traverse in topo sort
		 
		 //that's why here use min heap to implement dijkstra algorithm
		 //according to distance sort the pair
		 PriorityQueue<Pair6> pq = new PriorityQueue<Pair6>((x,y)->x.dist-y.dist);
		 
		 //create a distance array
		 int distance[] = new int[V];
		 
		 //stored with some largest value initially
		 Arrays.fill(distance,(int)1e9);
		 
		 //intial source node with distance 0 stored into min heap and update distance array
		 distance[S] = 0;
		 pq.offer(new Pair6(S,0));
		 
		 //traverse until queue is not becomes empty
		 while(!pq.isEmpty())
		 {
			 //get a node with min distance from minheap
			 Pair6 pa = pq.poll();   
			 
			 //check all adjacent nodes 
			 for(int i=0;i<adj.get(pa.node).size();i++)
			 {
				 int adjnode = adj.get(pa.node).get(i).node;
				 int dist = adj.get(pa.node).get(i).dist;
				 
				 //if from go to current node to adjacent node take min distance than previous distance
				 //update current distance value in an array and add into queue
				 if(pa.dist + dist < distance[adjnode])
				 {
					 //updated with min distance and add into queue
					 distance[adjnode] = pa.dist + dist;
					 pq.offer(new Pair6(adjnode,pa.dist+dist));
				 }
			 }
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

        int edges[][] = new int[e][3];
        System.out.println("Enter pair of nodes in which edges are connected with weight");
        for(int i=0;i<e;i++)
        {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

		ArrayList<ArrayList<Pair6>> adj = new ArrayList();
		for(int i=0;i<n;i++)
		{
			adj.add(i,new ArrayList<Pair6>());
		}

		for(int i=0;i<e;i++)
		{
			adj.get(edges[i][0]).add(new Pair6(edges[i][1],edges[i][2]));
			adj.get(edges[i][1]).add(new Pair6(edges[i][0],edges[i][2]));
		}

		System.out.println("Enter source vertex");
        int s = sc.nextInt();

     
        int distance[] = new int[n];
        distance = dijkstra(n,adj,s);


         System.out.println("Shortest distance to reach all nodes from source node is");
         for(int i=0;i<n;i++)
         System.out.print(distance[i]+" ");
       
    }
}