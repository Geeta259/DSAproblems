/*
 * 
 * . Find Eventual Safe States
A node is a terminal node if there are no outgoing edges. A node is a safe node
if every possible path starting from that node
 leads to a terminal node (or another safe node).
 Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

 use kahn's algorithm (topological sort using bfs)
 via reverrse links all outgoing links convert into incoming links find indegree 
 if a node indegree becomes zero at any point it is safe node from that node we can reach terminal node
*/
import java.util.*;

public class EventuallySafeStates
{    
    public static List<Integer> eventualSafeNodes(int n,ArrayList<ArrayList<Integer>> adj) {
        //create a list which stored all safe nodes
        List<Integer> list = new ArrayList<>();


        //create adjacency list to store reverse links
        ArrayList<ArrayList<Integer>> revadj = new ArrayList<>();
        //initialize 2d arraylist
        for(int i=0;i<n;i++)
        revadj.add(i,new ArrayList<>());

           //use topo sort with BFS implememtation to find safe nodes
        //safe nodes are those node whose indegree is zero means from that node can reach terminal nodes safe nodes

        int indegree[] = new int[n];

        //reverse links store convert outgoing edges to incoming edges
        for(int i=0;i<n;i++)
        {
            for(int adjnode : adj.get(i))
            {
                     revadj.get(adjnode).add(i);
                     indegree[i]++;
            }
        }
      
         //queue used to store all safe nodes
         Queue<Integer> que = new LinkedList<>();

         //first store nodes whose indegree is zero that is safe node(terminalnode)
         for(int i=0;i<n;i++)
         {
             if(indegree[i]==0)
             que.offer(i);
         }

         //traverse until queue is not empty
         while(!que.isEmpty())
         {
             int node = que.poll();
             //add into resultant list it is safe node
             list.add(node);

             //get all adjacent node and decrease indegree by one 
             for(int adjnode : revadj.get(node))
             {
                 //if after decrement by 1 it becomes zero it is also a safe node
                 indegree[adjnode]--;
                 if(indegree[adjnode]==0)que.offer(adjnode);
             }
         }

         //return list of safe nodes in increasing order
         Collections.sort(list);
         return list;
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
 
        List<Integer> list = new ArrayList<>();
      
         list = eventualSafeNodes(n,arr);
         System.out.println("All safe nodes from that can reach into terminal node");
        System.out.println(list);
    }
}