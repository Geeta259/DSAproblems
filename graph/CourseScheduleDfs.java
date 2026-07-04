/*
 * Course Schedule
first detect cycle if cycle exist not possible return false
get topo order using dfs 
 * */
import java.util.*;

public class CourseScheduleDfs
{    
    public static boolean detectCycle(ArrayList<ArrayList<Integer>> adj,int[] path,int[] visited,int node)
    {
        //mark it visited and path visited of current node
        visited[node]=1;
        path[node]=1;

        //traverse through adjacent node
        for(int adjnode : adj.get(node))
        {
            //if adjcent node not visited go to depth of that node and check cycle 
            if(visited[adjnode]==0)
            {
                //if cycle detected return false
                if(detectCycle(adj,path,visited,adjnode))return true;
            }
            //if it already visited check path visited if it in current path return true cycle detected
            else if(path[adjnode]==1)return true;
        }
        //while return back reomve node from current path
        path[node]=0;
        return false;
    }   
    
    public static void dfs(ArrayList<ArrayList<Integer>> adj,Stack<Integer> st,int node,int[] visited)
    {
        //mark it visited
        visited[node]=1;

        //traverse all adjacent node 
        for(int adjnode : adj.get(node))
        {
            if(visited[adjnode]==0)
            dfs(adj,st,adjnode,visited);
        }

        //while return back  push into stack (first all adjacent node push into stack then current node because it works LIFO)
        st.push(node);
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        //first detect any cycle exist or not if any cycle exist in given edges means not 
         //able to finish prerequisites
 
         //create adjacency list
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
         //initialize adjacency list
         for(int i=0;i<numCourses;i++)
         adj.add(i,new ArrayList<>());
 
         //add all adjacency node of each node
         for(int i=0;i<prerequisites.length;i++)
         {
             adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
         }
 
         //detect cycle using dfs
         //need to array visited and path visited array
         int visited[] = new int[numCourses];
         int path[] = new int[numCourses];
 
         for(int i=0;i<numCourses;i++)
         {
             //if current node is not visited 
             if(visited[i]==0)
             {
                 //go to depth of current node and check if cycle detected means contradict occur return false
                 if(detectCycle(adj,path,visited,i))return new int[0];
             }
         }
        
         //if cycle not detected get any topological sort in which can finish all courses
         int res[] = new int[numCourses];
         for(int i=0;i<numCourses;i++)
         visited[i]=0;
 
         //stack is used to store nodes 
         Stack<Integer> st = new Stack<>();
 
          for(int i=0;i<numCourses;i++)
         {
             //if current node is not visited 
             if(visited[i]==0)
             {
                 //go to depth of that node and store node in stack
                 dfs(adj,st,i,visited);
             }
         }
 
         int idx=0;
         while(!st.isEmpty())
         res[idx++]=st.pop();
 
         return res;
     }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of vertices");
        int n = sc.nextInt();
        System.out.println("Enter no of edges");
        int e = sc.nextInt();

        int prerequisites[][] = new int[e][2];
        System.out.println("Enter prerequisites pair");
        for(int i=0;i<e;i++)
        {
            prerequisites[i][0] = sc.nextInt();
            prerequisites[i][1] = sc.nextInt();
        }

    
        int ans[] = findOrder(n,prerequisites);
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