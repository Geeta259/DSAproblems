/*
 * given undirected garph with n nodes and e edges print adjacency list of graph
 */
import java.util.*;

public class GraphRepresentation{
    public static ArrayList<ArrayList<Integer>> printAdjacency(int n,  int[][] edges) {
       
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

        //converted into 2d array
    /*   int[][] ans = new int[n][];
       for(int i=0;i<n;i++)
       {
           int len = arr.get(i).size();
           int temp[] = new int[len+1];
           temp[0] = i;

           for(int j=0;j<len;j++)
           temp[j+1] = arr.get(i).get(j);

           ans[i] = temp;
       }
       */
       //return 2d array
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
        System.out.println("Enter pair of nodes in which edges are connected");
        for(int i=0;i<e;i++)
        {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        arr = printAdjacency(n,edges);

        System.out.println("Adjacency list of given connected edges are");

        for(int i=0;i<n;i++)
        System.out.println(i+"--->"+arr.get(i));
    }
}