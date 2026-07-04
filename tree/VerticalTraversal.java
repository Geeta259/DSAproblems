
/*
Vertical Order Traversal of a Binary Tree
 */
import java.util.*;
class Pair3{
    TreeNode  node;
    int pos;
    Pair3(TreeNode node,int pos)
    {
        this.node = node;
        this.pos = pos;
    }
}

 class Pair2{
    int  val;
    int pos;
    Pair2(int val,int pos)
    {
        this.val = val;
        this.pos = pos;
    }
}

class VerticalTraversal extends ConstructBinaryTree
{	

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        
        //to  store answer
       List<List<Integer>> ans = new ArrayList<>();
       //queue is required for traversal
       Queue<Pair3>  pq = new LinkedList<>();

       //map  required to  store  node of each level
       HashMap<Integer,ArrayList<Integer>> map = new  HashMap<>();

       if(root==null)return ans;
       pq.offer(new Pair3(root,0));
       int lvl=0;

       while(!pq.isEmpty())
       {
           int size = pq.size();

           //temp list  required to store node with  column posiiton of current lvl
           ArrayList<Pair2> temp = new ArrayList<>();
           for(int i=0;i<size;i++)
           {
                     Pair3 pa = pq.poll();

                     //add node value and its position
                   temp.add(new Pair2(pa.node.data,pa.pos));
              
                    if(pa.node.left!=null)
                   {
                       //push into queue if left child is not null
                       pq.offer(new Pair3(pa.node.left,pa.pos-1));
                   }

                   if(pa.node.right!=null)
                   {
                       //push into  queue if  right child is not null
                       pq.offer(new Pair3(pa.node.right,pa.pos+1));
                   }
           }


           //sort current level node by  their values
           Collections.sort(temp,(a,b)->Integer.compare(a.val,b.val));
           //traverse through temp
           for(Pair2 pa : temp)
           {
               //store into map with their position
               ArrayList<Integer> tp = new ArrayList<>();
               if(map.containsKey(pa.pos))
               tp = map.get(pa.pos);

               tp.add(pa.val);
               map.put(pa.pos,tp);
           }
           lvl++;
       }

       int start = lvl-1;  

       //from -lvl to +lvl column  value can expend
       for(int i=-start;i<=start;i++)
       {
           //check  if it  present get list and add in answer
           if(map.containsKey(i))
           {
                 ArrayList<Integer> temp = map.get(i);
               
                ans.add(temp);
           }   
       }
       //return ans
       return ans;
   }

    public static void main(String args[])
    {
         TreeNode root = constructTree();
          display(root);
         
           //create a 2d list to store nodes in zig zag fashion
        List<List<Integer>> list = new ArrayList<>();
        list = verticalTraversal(root);
        System.out.println(list);

    }
}