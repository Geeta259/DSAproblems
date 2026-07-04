/*
 * 
 * Bipartite Graph
Given an adjacency list of a graph adj  of V no. of vertices having 0 based index. 
Check whether the graph is bipartite or not.

bipartite graph which does not contain same adjacent color when two different color used for nodes
 */
import java.util.*;

public class BipartiteGraph
{
   //dfs used for each node to check all connected nodes
    public static boolean dfs(ArrayList<ArrayList<Integer>>adj,int[] color,int node,int clr)
    {
        //fill current node of clr color
        color[node] = clr;
        
        //get all adjacent node of current node
        for(int adjnode : adj.get(node))
        {
            //if adjacent node not color and not not equal to current color
            if(color[adjnode]==-1)
            {
                //call dfs from that adjacent node
                //1-clr always pass adjacent color if current node color 0 adjacent node 1-0=1
                //if current node color 1 adjacent node 1-1 = 0
                if(dfs(adj,color,adjnode,1-clr)==false)return false;
            }
            //if already color check if it match with current node
            //if adjacent node color and source node color matched not bipartite graph return false
            else if(color[adjnode]==clr)return false;
        }
        //otherwise return true
        return true;
    }
    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        //create a color array which identified which node has which color take 0 and 1 color
        int color[] = new int[V];
        //initialize with -1
        Arrays.fill(color,-1);
        
        //if there is different components in a graph each components represent a single graph check for each node
        for(int i=0;i<V;i++)
        {
            //if current node is not color new component start go to depth of that node
            if(color[i]==-1)
            {
                //call dfs to check all connected node color
                //no two adjacent node have same color
                //initial node fill with  0 color
                //if it return false means not a  bipartite graph return false
                if(dfs(adj,color,i,0)==false)
                return false;
            }
        }
        //otherwise return true
        return true;
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
 
        if(isBipartite(n,arr))
        System.out.println("Given graph is Bipartite graph");
        else
        System.out.println("Given graph is not Bipartite graph");
    }
}