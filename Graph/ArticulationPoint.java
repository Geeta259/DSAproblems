public  static void dfs(ArrayList<ArrayList<Integer>> adj,int node,int parent,int timer,int[] time,int[] low,int[] ap,int[] visited)
	{
		visited[node]  = 1; //mark  it visited current node
		time[node] = timer; //set  current timer as current time & low
		low[node] = timer;
		timer+=1;//increment timer by 1

		int child=0; //track  of  each  node children
		for(int adjnode : adj.get(node))
		{
			if(adjnode == parent) //if it  is  equal to  parent
			continue; //nothing to  do

			if(visited[adjnode]==0)
			{
				//not visited
				dfs(adj,adjnode,node,timer,time,low,ap,visited);
				//while backtrack

				//update  node low time
				low[node] = Math.min(low[node],low[adjnode]);

				//check node  is AP or  not
				if(low[adjnode] >= time[node] && parent!=-1)
				ap[node]=1; //current node is ap 

				child++; //track  no of  children
			}
			else{

				//if it is  already  visited by other node
				//back edge case
				//update current node  low time by compare with time of adjnode
				low[node] = Math.min(low[node],time[adjnode]);
			}
		}


		//check for starting node
		if(parent==-1 && child>1)
		ap[node]=1; //initial node is ap 

	}
    public static int beautifulVertices(int n, int m, int[][] edges) {
		    // Write your code here.
			ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
			for(int i=0;i<=n;i++)
			adj.add(i,new ArrayList<>());

			//create an adjacency list of bidirectional graph
			for(int i=0;i<m;i++)
			{
				int s = edges[i][0];
				int d = edges[i][1];

				adj.get(s).add(d);
				adj.get(d).add(s);
			}

			int timer=0; //initial timer
			int[] time = new int[n+1]; //actual time of each  node
			Arrays.fill(time,-1);
			int[] low = new int[n+1]; //low time of  each node
			Arrays.fill(low,-1);
			
			int[] visited = new int[n+1]; //visited of each node

			int[] ap = new  int[n+1]; //articulation point yes or not


			//dfs call for  each component
			for(int i=1;i<=n;i++)
			{
				if(visited[i]==0) //not visited yet
				{
					dfs(adj,i,-1,timer,time,low,ap,visited);
				}
			}

			int count=0;
			for(int i=1;i<=n;i++)
			{
				if(ap[i]!=0)
				count++;
			}
			return count; //no  of  articulation point
	}
