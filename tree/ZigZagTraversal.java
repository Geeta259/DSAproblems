
/*
 *  Binary Tree Zigzag Level Order Traversal
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes'
 *  values. (i.e., from left to right, then right to left for the next level and alternate between).
 */
import java.util.*;

class ZigZagTraversal extends ConstructBinaryTree
{	
    public static void main(String args[])
    {
         TreeNode root = constructTree();
          display(root);
         
           //create a 2d list to store nodes in zig zag fashion
        List<List<Integer>> list = new ArrayList<>();

        //if root is nul return empty list
        if(root==null)
        System.out.println(list);
        else
        {
            
                //create a queue to traverse level order 
                Queue<TreeNode> que = new LinkedList<>();
                que.offer(root);

                //start from left to right
                boolean lefttoright = true;
                //traverse until queue is not empty
                while(!que.isEmpty())
                {
                    //get no of nodes of current level
                    int size = que.size();
                    //create a temporary list to store current level nodes
                    List<Integer> li = new ArrayList<>(size);

                    for(int i=0;i<size;i++)
                    {
                        //get first visited nodes from queue
                        TreeNode getnode = que.poll();
                        
                        //add current level node in to list
                        li.add(getnode.data);
                        
                        //check left and right child node exist of popped out nodes
                        //add into queue for next level
                        if(getnode.left!=null)
                        que.offer(getnode.left);

                        if(getnode.right!=null)
                        que.offer(getnode.right);
                    }

                    //after complete current level 
                    //update lefttoright boolean flag for next level
                    //add current level list in 2d list

                    //if leftto right false reverse li list
                    if(!lefttoright)
                    Collections.reverse(li);

                    lefttoright = lefttoright==true?false:true;   
                    list.add(li);
                }

                System.out.println(list);
                
        }

    }
}