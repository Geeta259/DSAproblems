/*
 * Detect cycle in an undirected graph
Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 

Approach:
considered each node as a source node if it not visited yet bfs traversal from that node
pair wise data stored into queue node with parent
track adjacent node of polled out node it adjacent node is not a parent node from where it comes and already visited 
means it visited from other node 

same node visited twice from different source node means cycle detected return true otherwise return false
 */
import java.util.*;
class Pair1
{
        int node,parent;
        Pair1(int node,int parent)
        {
            this.node = node;
            this.parent = parent;
        }
}
public class DetectCycleBfs
{
  
    static boolean detectCycle(int V, List<List<Integer>> adjlist) {
        // bfs technique used to detect cycle in a graph

        //create a visited array to track which node is visited and which not
        int[] visited = new int[V];

        //traverse through each node and check if not visited check cycle exist or not
        for(int i=0;i<V;i++)
        {
            //not visited current source node
            if(visited[i]==0)
            {
                //if from that node cycle exist return true
                if(cycleExist(adjlist,visited,i))
                return true;
            }
        }
        //if no cycle exist return false
        return false;
    }


    public static boolean cycleExist(List<List<Integer>> adjlist,int[] visited,int src)
    {
        //create a queue to traverse bfs for each source node
        Queue<Pair1> que = new LinkedList<>();
        //add source node into queue with parent -1 because it does not come anywhere
        que.add(new Pair1(src, -1));

        //mark it source node visited
        visited[src] =1;

        //traverse until queue is not empty
        while(!que.isEmpty())
        {
            //get pair value from queue
            Pair1 pa = que.poll();
            int node = pa.node;
            int parent = pa.parent;

            //get all adjacent node from that node
            for(int adjnode : adjlist.get(node))
            {
                //if that node is not source node and already visited means it come from
                //another node from two different node reach same node means cycle exist
                if(adjnode!=parent)
                {
                    //already visited and not come  from current node
                    if(visited[adjnode]==1)
                    return true;

                    //if it not visited add into queue and mark it visited
                    visited[adjnode]=1;
                    que.offer(new Pair1(adjnode,node));
                }
            }
        }

        //if no cycle exist
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
         List<List<Integer>> arr = new ArrayList<>();

         //initialize 2d arraylist
         for(int i=0;i<n;i++)
         arr.add(i,new ArrayList<>());
 
         //add into list for each edges undirected graph
         for(int i=0;i<edges.length;i++)
         {
             arr.get(edges[i][0]).add(edges[i][1]);
              arr.get(edges[i][1]).add(edges[i][0]);
         }
 
        if(detectCycle(n,arr))
        System.out.println("Cycle detected in given graph");
        else
        System.out.println("Cycle not detected in given graph");
    }
}