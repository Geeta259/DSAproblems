
/*
. All Nodes Distance K in Binary Tree
Given the root of a binary tree, the value of a target node target, and an integer k, 
return an array of the values of all nodes that have a distance k from the target node.
You can return the answer in any order.

Find all nodes which are at distance k from target node
can move left,right or upward
 
Approach:
Store all parent node of each nodes  in map
Track all visited node can use another map
move left , right or upward decrement k by 1
if k becomes 0 at any node it is required nodes
*/

import java.util.*;

class NodeDistanceK extends ConstructBinaryTree
{	
    //targetnode conatin node of target value
    static TreeNode targetnode;
    
    public static void getParent(TreeNode root,HashMap<TreeNode,TreeNode> map,int target)
    {
        //if root is null return back
        if(root==null)
        return;

        if(root.data ==  target)
        targetnode = root;

        //any traversal we can use to store parent node of each node
        //if root left not null store into map with their parent node and move to left
        if(root.left!=null)
        {
             map.put(root.left,root);
             getParent(root.left,map,target);
        }
        //if root right not null store into map with their parent node and move to right
        if(root.right!=null)
        {
             map.put(root.right,root);
            getParent(root.right,map,target);
        }
    }

    public static void getDistanceK(TreeNode target,int k,HashMap<TreeNode,Integer> visited,HashMap<TreeNode,TreeNode> map,List<Integer> list)
    {
        //if node null or it already visited no need to move further return back
        if(target==null || visited.containsKey(target))
        return;

        //mark it viisted add into map
        visited.put(target,1);

        //if at current node k becomes 0 means it is required node add into list
        //and return back from this no need to move further
        if(k==0)
        {
            list.add(target.data);
            return;
        }

        //go to left,right & parent of current node with distance decrement by 1 
        getDistanceK(target.left,k-1,visited,map,list);
        getDistanceK(target.right,k-1,visited,map,list);
        getDistanceK(map.get(target),k-1,visited,map,list);
    }

   public static void main(String args[])
    {
        //create tree from given values
		System.out.println("Enter all unique nodes values");
        TreeNode root = constructTree();
        display(root);
       
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter target node");
        int target = sc.nextInt();
        
        System.out.println("Enter k distance");
        int k = sc.nextInt();

         //store all nodes with their parent node to track of parent node
         HashMap<TreeNode,TreeNode> map = new HashMap<>();
         //store into map
         targetnode = null;
         getParent(root,map,target);

          //list which store all node value at distance k from target node
         List<Integer> list = new ArrayList<>();
 
         //another map which is used to track which node is already visited or not
         HashMap<TreeNode,Integer> visited = new HashMap<>();
 
         //get all node value at distance k
         getDistanceK(targetnode,k,visited,map,list);
 
         System.out.println("All nodes at a distance k from target node is");
        System.out.println(list);
    }
}

/*
 * 
 */