
/*
Maximum Width of Binary Tree
Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.
*/

import java.util.*;

class IndexPair
{
   int idx;
   TreeNode node;
   IndexPair(int idx,TreeNode node)
   {
       this.idx = idx;
       this.node = node;
   }
}

class MaximumWidth extends ConstructBinaryTree
{	

    public static int widthOfBinaryTree(TreeNode root) {
        //use level order traversal to find minimum width of given tree
        int ans = 0;

        if(root==null)
        return ans;

        //queue used for level order traversal
        Queue<IndexPair> que = new LinkedList<>();
        que.add(new IndexPair(0,root));

        //traverse until queue is  not empty
        while(!que.isEmpty())
        {
            //get minidx of first node value of current level
            int minidx = que.peek().idx;
            int size = que.size();
            //track first and last node index of current level to find maximum width between nodes
            int first=0,last=0;
            for(int i=0;i<size;i++)
            {
                //get node with index
                IndexPair pa = que.poll();

           // current node index minus min index of curr level so that nodes count start from zero  ...so that overflow does not occur

                //get current index after modifiy by minus with minidx of current level
                int curr_idx = pa.idx - minidx;

                //if i = 0 or size-1 update first and last by curr_idx
                if(i==0)
                first = curr_idx;
                if(i==size-1)
                last = curr_idx;
            
               
               //if left child exist of popped out nodes add in queue with  left index
                if(pa.node.left!=null)
                {
                    que.add(new IndexPair((2*curr_idx)+1 , pa.node.left));
                }

                //if right child exist of popped out nodes add in queue with right index
                  if(pa.node.right!=null)
                {
                    que.add(new IndexPair((2*curr_idx)+2 , pa.node.right));
                }
            }

            //update ans for each level  get max width by 
            //last index - first index +1
            
            ans  = Math.max(ans,last-first+1);
        }

        //return max width
        return ans;
    }

    public static void main(String args[])
    {
        //create tree from given values
         TreeNode root = constructTree();
          display(root);
        
         int max = widthOfBinaryTree(root);
		 System.out.println("Maximum width of binary tree among all levels is " + max);
    }
}