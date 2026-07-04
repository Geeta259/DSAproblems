
/*
 *  
Binary Tree Right Side View
Given the root of a binary tree, imagine yourself standing on the right side of it,
 return the values of the nodes you can see ordered from top to bottom.

*/

import java.util.*;


class RightViewNode extends ConstructBinaryTree
{	

    /*
     * recursive way to get rightmost nodes
     * //each level  only one node value add into list 
     * //this condition check by compare list size with level if it equal means first node comes in current level
     *  
     *  public void getRightView(TreeNode root, int lvl , List<Integer> list)
    {
        //if root null return back
        if(root==null)
        return;

        //check level value and list size same if same new level first rightmost value appears
        if(lvl == list.size())
        list.add(root.val);

        //each level only one rightmost element insert into list
        //go first right side 
        getRightView(root.right,lvl+1,list);
        //go left side
        getRightView(root.left,lvl+1,list);
    }
     */
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
            //get all nodes of current level
            while(size!=0)
            {
                //get nodes from queue
                TreeNode node = que.poll();

                //if it last node of current level add into list
                if(size==1)
                list.add(node.data);

                //if popped node left and right node exist add into queue 
                if(node.left!=null)
                que.offer(node.left);

                if(node.right!=null)
                que.offer(node.right);

                //decrement size by 1
                size--;
            }
        }

        //print all right view nodes in resultant array
	       System.out.println("All Right view nodes of given tree is \n" + list);
    }
}