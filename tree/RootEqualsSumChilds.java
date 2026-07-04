
/*
. Root Equals Sum of Children
You are given the root of a binary tree that consists of exactly 3 nodes: 
the root, its left child, and its right child.
Return true if the value of the root is equal to the sum of the values of its two children, or false otherwise.

 
*/

import java.util.*;

class RootEqualsSumChilds extends ConstructBinaryTree
{	
    public static boolean checkTree(TreeNode root) {
    
        //if root null return true
         if(root==null)
         return true;
 
         //use level order traversal
         Queue<TreeNode> que = new LinkedList<>();
         //add root into queue
         que.offer(root);
 
         //traverse until queue is not  empty
         while(!que.isEmpty())
         {
             //get size of queue
             int size = que.size();
             //iterate until  size not becomes zero
             while(size!=0)
             {
                 //get node from queue
                 TreeNode getnode = que.poll();
                 int sum=0;
 
                 //if left child exist add their value into sum and add into queue
                 if(getnode.left!=null)
                 { que.add(getnode.left); sum+=getnode.left.data;} 
 
                 //if right child exist add their value into sum and add into queue
                 if(getnode.right!=null)
                 { que.add(getnode.right); sum+=getnode.right.data;}
 
                 //if sum not equals to getnode value and it is not leaf node return false
                 if(sum!=getnode.data  && getnode.left!=null && getnode.right!=null)
                 return false;
 
                 //decrement size by one
                 size--;
             }
         }
 
         //else return true
         return true;
 
     }
 
   public static void main(String args[])
    {
        //create tree from given values
		System.out.println("Enter all unique values of nodes");
        TreeNode root = constructTree();
        display(root);
        
        if(checkTree(root))
        System.out.println("Valid tree all roots is equal to sum of its childs");
        else
        System.out.println("Not valid tree all roots is not equal to sum of its childs");  
    }
}

/*
 * 
 */