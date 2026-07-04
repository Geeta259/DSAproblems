/*
Shortest path in Directed Acyclic Graph
Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M, 
where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.

Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, 
then return -1 for that vertex.


Approach:

it is directed acyclic graph for sure not contained any cycle can use topological sort 
in which we get node and update distance to reach all adjacent node

from u-->v in topological sort must u comes before v in a order we traverse to find shortest path in directed graph

*/
import java.util.*;
class Pair5
{
    int node,weight;
    public Pair5(int node,int weight)
    {
        this.node = node;
        this.weight = weight;
    }
}
public class ShortestPathDirected
{    
    public static void dfs(int node,int[] visited,ArrayList<ArrayList<Pair5>> adj,Stack<Integer> st)
    {
        //mark it visited
        visited[node]=1;
        
        //traverse all adjacent node first of current node
        for(int i=0;i<adj.get(node).size();i++)
        {
            //get adjacent node of current node
            int adjnode = adj.get(node).get(i).node;
            //if it is not visited go to depth of that node
            if(visited[adjnode]==0)
            dfs(adjnode,visited,adj,st);
        }
        
        st.push(node);
    }
	public static int[] shortestPath(int N,int M, int[][] edges) {
		//create adjacency list which store adjacency nodes with weight
		ArrayList<ArrayList<Pair5>> adj = new ArrayList<>();
		
		for(int i=0;i<N;i++)
		adj.add(i,new ArrayList<>());
		
		for(int i=0;i<M;i++)
		{
		    adj.get(edges[i][0]).add(new Pair5(edges[i][1],edges[i][2]));
		}
		
		//do a topo sort 
		//here using dfs
		Stack<Integer> st = new Stack<>();
		
		//create a visited array
		int visited[] = new int[N];
		
		//start from 0 to N-1 nodes
		for(int i=0;i<N;i++)
		{
		    if(visited[i]==0)
		    dfs(i,visited,adj,st);
		}
		
		//create a distance array initialize with maximum value
		int distance[] = new int[N];
		Arrays.fill(distance,(int)1e9);
		
		//source node distance is 0
		distance[0] = 0;
		
		//traverse until stack is not empty
		while(!st.isEmpty())
		{
		    int node = st.pop();
		    for(int i=0;i<adj.get(node).size();i++)
		    {
		        int adjnode = adj.get(node).get(i).node;
		        int weight = adj.get(node).get(i).weight;
		        
		        if(distance[node] + weight < distance[adjnode])
		        {
		            //release the link
		            distance[adjnode] = distance[node] + weight;
		        }
		    }
		}
		
		for(int i=0;i<N;i++)
		{
		    if(distance[i]==(int)1e9)
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

        int edges[][] = new int[e][3];
        System.out.println("Enter pair of nodes in which edges are connected with weight");
        for(int i=0;i<e;i++)
        {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

     
        int distance[] = new int[n];
        distance = shortestPath(n,e,edges);


         System.out.println("Shortest distance to reach all nodes from source node is");
         for(int i=0;i<n;i++)
         System.out.print(distance[i]+" ");
       
    }
}