/*
Cheapest Flights Within K Stops
There are n cities and m edges connected by some number of flights. You are given an array flights 
where flights[i] = [fromi, toi, pricei]
 indicates that there is a flight from the city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops
. If there is no such route, return -1.
*/
import java.util.*;
//pair node with price to  create adjacency list
class Pair9
{
    int node,price;
    Pair9(int node,int price)
    {
        this.node = node;
        this.price = price;
    }
}
//triple class used to stored in queue
class Triple
{
    int node,price,stop;
    Triple(int node,int price,int stop)
    {
        this.node = node;
        this.price = price;
        this.stop = stop;
    }
}

public class CheapestFlight
{    
    public static int findCheap(int n,int flights[][],int src,int dst,int k) {
        //according to no of stops price will ne updated
        //and no of stops vary constant by 1 from one node to another node 
        //so no  need to  use dijkstra a simple queue is enough to store
        Queue<Triple> que = new LinkedList<>();
        
        //create adjacency list  store node with price 
        ArrayList<ArrayList<Pair9>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(i,new ArrayList<>());
        
        for(int i=0;i<flights.length;i++)
        adj.get(flights[i][0]).add(new Pair9(flights[i][1],flights[i][2]));
        
        //price array required to stored minimum price to reach a particular node
        int price[] = new int[n];
        //intialize with maximum value
        Arrays.fill(price,(int)1e9);
        
        //add source node into queue with price and stop and update price array 
        que.add(new Triple(src,0,0));
        price[src] = 0;
        
        //traverse until queue is not empty
        while(!que.isEmpty())
        {
            //polled out triple from queue
            Triple tri = que.poll();
            int node = tri.node;
            int cost = tri.price;
            int stop = tri.stop;
            
            ///if no of stop exceed than k continue no need to  go further from that node
            if(stop > k)continue;
            
            //if no of stop not exceed traverse adjacent node
            for(Pair9 adjnode : adj.get(node))
            {
                //check  previous cost to reach at this node
                if(cost + adjnode.price < price[adjnode.node])
                {
                    //update with minimum price and add into queue
                    price[adjnode.node] = cost + adjnode.price;
                    //store node ,price, and stop increment by  1
                    que.add(new Triple(adjnode.node,cost+adjnode.price,stop+1));
                }
            }
        }
        
        //check dest node price updated or did not able to  reach that node
        if(price[dst] == (int)1e9)
        return -1;
        
        //otherwise return price of that node
        return price[dst];
     }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
	 System.out.println("Enter no of vertices");
        int n = sc.nextInt();
        System.out.println("Enter no of edges");
        int e = sc.nextInt();

        int edges[][] = new int[e][3];
        System.out.println("Enter pair of nodes in which edges are connected with price");
        for(int i=0;i<e;i++)
        {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        System.out.println("Enter source node value");
        int src = sc.nextInt();
        System.out.println("Enter destination node value");
        int dst = sc.nextInt();
        System.out.println("Enter maximum no of stops");
        int k = sc.nextInt();

	   	int price = findCheap(n,edges,src,dst,k);
         System.out.println("Minimum price to reach to destination node is " + price);
        
    }
}