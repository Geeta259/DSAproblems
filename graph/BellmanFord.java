/*
Distance from the Source (Bellman-Ford Algorithm)Given a weighted, directed and connected graph of 
V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S.
 If a vertices can't be reach from the S then mark the distance as 10^8.
 Note: If the Graph contains a negative cycle then return an array consisting of only -1.


 Also used for calculate shortest distance from given source when negative weight exist , where dijkstra algorithm fails.
*/
import java.util.*;

public class BellmanFord
{    
    public static int[] bellmanFord(int V, int edges[][], int S) {
        //given graph conntain negative weight so here bellman-ford algorithm used to find shortest path
        //from given source node
        
        //distance array required to store min distance to reach all nodes from source node
        int dist[] = new int[V];
        //initialize with max value
        Arrays.fill(dist,(int)1e8);
        
        //update distance of source node
        dist[S] = 0;
        
        //in each graph at max n-1 edges so iterate n-1 times
        for(int i=0;i<V;i++)
        {
            //in each iteration check edges
            for(int j=0;j<edges.length;j++)
            {
                //get source , detsination node with weight
                int s = edges[j][0];
                int d = edges[j][1];
                int w = edges[j][2];
                
                //relaxation distance
                if(dist[s]!=1e8 && dist[s] + w < dist[d])
                {
                    //if source node distance updated and current distance to reach d node is minimum than previous 
                    //update distance
                    dist[d] = dist[s] + w;
                }
            }
        }
        
        //check for negative cycle if  after V-1 iteration
        //still  relaxation done and distance array gets updated means negative cycle exist because in normal graph 
        //at max v-1 edges 
        
         //one more iteration check edges
            for(int j=0;j<edges.length;j++)
            {
                  //get source , detsination node with weight
                  int s = edges[j][0];
                  int d = edges[j][1];
                  int w = edges[j][2];
                  
                //relaxation distance
                if(dist[s]!=1e8 && dist[s] + w < dist[d])
                {
                    //if still relaxation done means negative cycle exist return array which contain -1
                    int temp[] = new int[1];
                    temp[0] = -1;
                    return temp;
                }
            }
            
            //return distance array if negative cycle does not exist
            return dist;
     }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
	 System.out.println("Enter no of vertices");
        int n = sc.nextInt();
        System.out.println("Enter no of edges");
        int e = sc.nextInt();

        int edges[][] = new int[e][3];
        System.out.println("Enter pair of nodes in which edges are connected with weight negative weight also allowed");
        for(int i=0;i<e;i++)
        {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        System.out.println("Enter source node value");
        int src = sc.nextInt();
      

	    int dist[] = bellmanFord(n,edges,src); 
        if(dist.length==1 && dist[0]==-1)
          System.out.println("Negative cycle exist in a graph");
          else
          {
            //print distance array
            for(int i=0;i<dist.length;i++)
            System.out.print(dist[i] + " ");

          }
        
    }
}