/*
 * Course Schedule
There are a total of n tasks you have to pick, labeled from 0 to n-1. 
Some tasks may have prerequisites tasks, for example to pick task 0 you have to first finish tasks 1, 
which is expressed as a pair: [0, 1] given
here edges go 1--->0

based on topo sort
if cycle does not exist possible to complete all task in an order but if cycle contain not get all nodes in a order
here use bfs to get topo sort if possible get all nodes in an order

if topo array not contain all nodes return empty array
 * */
import java.util.*;

public class CourseScheduleBfs
{    
    static int[] findOrder(int N, int P, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        // add your code here
        //check is it possible to finish all task 
        //get topo sort of given task if it contain all nodes means there is no cycle exist so possible to
        //finish all task in an order
        
        //use bfs to get topsort order
        int indegree[] = new int[N];
        
        //create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      
      //initialize adjacency list  
        for(int i=0;i<N;i++)
        adj.add(i,new ArrayList<>());
        
        //add adjacent node of each node
        //u-->v u comes before v //here egdes go  1--->0
        for(int i=0;i<P;i++)
        {
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }
        
        //maintain indegree of each node
        for(int i=0;i<N;i++)
        {
            for(int adjnode : adj.get(i))
            indegree[adjnode]++;
        }
        
        //queue used to store all nodes which indegree becomes zero
        Queue<Integer> que = new LinkedList<>();
        
        for(int i=0;i<N;i++)
        {
            //if any node indegree 0 it can be start node add into queue
            if(indegree[i]==0)
            que.offer(i);
        }
        
        //create array to store topo order
        int topo[] = new int[N];
        int i=0;
        //traverse until queue is not empty
        while(!que.isEmpty())
        {
            //get node from queue
            int node = que.poll();
            //add into topo array
            topo[i++] = node;
            
            //update indegree of all adjacent node of that node because it is placed in topo sort
            for(int adjnode : adj.get(node))
            {
                //decrement indegree of adjacent node by 1
                indegree[adjnode]--;
                //if it becomes 0 add into queue
                if(indegree[adjnode]==0)
                que.offer(adjnode);
            }
        }
        
       //if topo array  contain all nodes means possible to complete all course return topo array
        if(i==N)return topo;
        
         //if not possible to finish all task return empty array
        int[] arr ={};
        return arr;
        
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of vertices");
        int n = sc.nextInt();
        System.out.println("Enter no of edges");
        int e = sc.nextInt();

        int edges[][] = new int[e][2];
        System.out.println("Enter prerequisites pair");
        for(int i=0;i<e;i++)
        {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
        for(int i=0;i<e;i++)
        prerequisites.add(i,new ArrayList<Integer>(Arrays.asList(edges[i][0],edges[i][1])));

        int ans[] = findOrder(n,e,prerequisites);
         if(ans.length==0)
         System.out.println("Not possible to complete all task order not possible cycle exist in given prerequisites");
         else
         {
            System.out.println("One of the possible order to complete all task is");
            for(int i=0;i<ans.length;i++)
            System.out.print(ans[i] + " ");
         }    
    }
}