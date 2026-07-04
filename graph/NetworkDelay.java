/*
Network Delay Time
We will send a signal from a given node k. Return the minimum time it takes for 
all the n nodes to receive the signal. 
If it is impossible for all the n nodes to receive the signal, return -1.

You are given a network of n nodes, labeled from 1 to n. You are also given times,
 a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, 
and wi is the time it takes for a signal to travel from source to target.
*/
import java.util.*;
//pair class used to store pair in list with time
class Pair10
{
    int node,time;
    Pair10(int node,int time)
    {
        this.node = node;
        this.time = time;
    }
}
public class NetworkDelay
{    
    public static int delayTime(int[][] edges, int n, int k) {
       
        //dijkstra used here because to go from one node to another node time vary 
        //use min heap  to  store time in ascending order
        PriorityQueue<Pair10> pq = new PriorityQueue<>((x,y)->x.time - y.time);
       
       //mintime array used to track min time taken to reach each node from k node
        int mintime[] = new int[n+1];
        Arrays.fill(mintime,(int)1e9);

        //create adjacency list and store edges with time
        ArrayList<ArrayList<Pair10>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(i,new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(new Pair10(edges[i][1],edges[i][2]));
        }

        //source node add into queue with time taken by 0
        pq.add(new Pair10(k,0));
        //to reach k node time taken 0 update array
        mintime[k] = 0;

        //traverse until queue is not empty
        while(!pq.isEmpty())
        {
            Pair10 pa  = pq.poll();
            int node = pa.node;
            int time = pa.time;

            //traverse all adjacent node
            for(Pair10 adjnode : adj.get(node))
            {
                //if to reach a node taken min time than previous time 
                if(time + adjnode.time < mintime[adjnode.node])
                {       
                        //update time for that node and stored into priority queue
                         mintime[adjnode.node] = time + adjnode.time;
                          pq.add(new Pair10(adjnode.node,time + adjnode.time));
                    
                }
            }
        }

        //the minimum time taken to reach all ndoe from k node 
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++)
        {
            //if did not reach a single node from k node return -1
            if(mintime[i] == (int)1e9)
            return -1;

            //otherwise get min time in which we can reach each node from k node
            //get max time from all min time
            max = Math.max(max,mintime[i]);
        }
        return max;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
	 System.out.println("Enter no of vertices");
        int n = sc.nextInt();
        System.out.println("Enter no of edges");
        int e = sc.nextInt();

        int edges[][] = new int[e][3];
        System.out.println("Enter pair of nodes in which edges are connected with time");
        for(int i=0;i<e;i++)
        {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        System.out.println("Enter source node value");
        int src = sc.nextInt();
      

	   	int time = delayTime(edges,n,src);
         System.out.println("Minimum time in which all nodes visited from source node " + time);
        
    }
}