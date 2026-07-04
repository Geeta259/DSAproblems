
/*
 *  
Binary Tree Left Side View
Given the root of a binary tree, imagine yourself standing on the left side of it,
 return the values of the nodes you can see ordered from top to bottom.

*/

import java.util.*;
class LeftViewNode extends ConstructBinaryTree
{	
    public static void main(String args[])
    {
        //create tree from given values
         TreeNode root = constructTree();
          display(root);
        
             //create an arraylist which store right view nodes
        List<Integer>  list = new ArrayList<>();
        //queue used for level order traversal
        Queue<TreeNode> que = new LinkedList<>();
        //if root null return empty list
        if(root != null)
        //queue add root node
        que.add(root);

        //if queue is not empty
        while(!que.isEmpty())
        {
            //get current size of queue
            int size = que.size();
            //get first flag variable
            boolean first= true;
            //left side view considered only first node value of current level
            //get all nodes of current level
            while(size!=0)
            {
                //get nodes from queue
                TreeNode node = que.poll();

                //if it first node of current level add into list
                if(first)
                list.add(node.data);

                //if popped node left and right node exist add into queue 
                if(node.left!=null)
                que.offer(node.left);

                if(node.right!=null)
                que.offer(node.right);

                //decrement size by 1
                size--;
                //update first value to false
                first = false;
            }
        }

        //print all left view nodes in resultant array
	       System.out.println("All Left view nodes of given tree is \n" + list);
    }
}