import java.util.*;
class DisjointSet
{
    //first need rank and parent list 
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    
    public DisjointSet(int n)
    {
        //initialize size of n
        //initially all nodes rank is 0 and parent contain itself
        for(int i=0;i<=n;i++)
        {
            rank.add(0);
            parent.add(i);
        }
    }
    
    //findParent
    //get immediate top parent node of given node 
    public int findParent(int node)
    {
        //if node itself is parent node means it is topmost node return that node
        if(node == parent.get(node))
        return node;
        
        //recursively get parent node from bottom to top
        //and set into parent list of given nodes
        parent.set(node,findParent(parent.get(node)));
        
        //return parent of that node
        return parent.get(node);
    }
    
    //build graph one by one by given u---> v edges union by rank
    public void unionByRank(int u,int v)
    {
        //get first parent node of u and v
        int pu = findParent(u);
        int pv = findParent(v);
        
        //if both have same parent node already in same component return 
        if(pu == pv)return;
        
        //otherwise check rank of parent node
        //if rank  of parent(u) < rank of parent(v)
        if(rank.get(pu) < rank.get(pv))
        {
            //connect with more rank
            //parent of u is parent of v node means u node connected in v node
            parent.set(pu,pv);
        }
          //if rank  of parent(v) < rank of parent(u)
        else if(rank.get(pv) < rank.get(pu))
        {
            //connect with more rank
            //parent of v is parent of u node means v node connected in u node
            parent.set(pv,pu);
        }
        else
        {
            //if both parent nodes has same rank
            //connect any one of them with anyone
             parent.set(pv,pu);
             //and rank of pu (parent of u node) increment
             rank.set(pv,rank.get(pu)+1);
        }
    }
}

class ImplementDisjointSet
{
    public static void main(String args[])
    {
        //7 edges given here
        DisjointSet obj = new DisjointSet(7);
        obj.unionByRank(1,2);
        obj.unionByRank(2,3);
        obj.unionByRank(4,5);
        obj.unionByRank(6,7);
        obj.unionByRank(5,6);

        //check if 3 and 7 are in same component or not
        if(obj.findParent(3) == obj.findParent(7))
        System.out.println("3 and  7  nodes belong into same components");
        else
        System.out.println("3 and  7  nodes not  belong into same components");

        //after linked this edge
        obj.unionByRank(3,7);

        //check if 3 and 7 are in same component or not
        if(obj.findParent(3) == obj.findParent(7))
        System.out.println("3 and  7  nodes belong into same components");
        else
        System.out.println("3 and  7  nodes not  belong into same components");
    }
}