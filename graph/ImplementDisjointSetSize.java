import java.util.*;
class DisjointSetBySize
{
    //first need size and parent list 
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    
    public DisjointSetBySize(int n)
    {
        //initialize size of n
        //initially all nodes size is 0 and parent contain itself
        for(int i=0;i<=n;i++)
        {
            size.add(0);
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
    
    //build graph one by one by given u---> v edges union by size
    public void unionBySize(int u,int v)
    {
        //get first parent node of u and v
        int pu = findParent(u);
        int pv = findParent(v);
        
        //if both have same parent node already in same component return 
        if(pu == pv)return;
        
        //otherwise check size of parent node
        //if size  of parent(u) < size of parent(v)
        if(size.get(pu) < size.get(pv))
        {
            //connect with more size
            //parent of u is parent of v node means u node connected in v node
            parent.set(pu,pv);
            size.set(pv,size.get(pv)+size.get(pu));
        }
        else
        {
            //if both parent nodes has same size or  greater u than v
            //connect any one of them with anyone
             parent.set(pv,pu);
            size.set(pu,size.get(pu) + size.get(pv));
        }
    }
}

class ImplementDisjointSetSize
{
    public static void main(String args[])
    {
        //7 edges given here
        DisjointSetBySize obj = new DisjointSetBySize(7);
        obj.unionBySize(1,2);
        obj.unionBySize(2,3);
        obj.unionBySize(4,5);
        obj.unionBySize(6,7);
        obj.unionBySize(5,6);

        //check if 3 and 7 are in same component or not
        if(obj.findParent(3) == obj.findParent(7))
        System.out.println("3 and  7  nodes belong into same components");
        else
        System.out.println("3 and  7  nodes not  belong into same components");

        //after linked this edge
        obj.unionBySize(3,7);

        //check if 3 and 7 are in same component or not
        if(obj.findParent(3) == obj.findParent(7))
        System.out.println("3 and  7  nodes belong into same components");
        else
        System.out.println("3 and  7  nodes not  belong into same components");
    }
}