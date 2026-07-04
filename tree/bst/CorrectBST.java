/*
 * Recover Binary Search Tree
Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
 */

import java.util.*;

class CorrectBST extends ConstructBinaryTree{
  //declare a class variable which needed to track inorder traversal
  public static TreeNode prev=null,first=null,last=null,middle=null;

  public static void inOrder(TreeNode root)
  {
	  if(root==null)
	  return;

	  inOrder(root.left);

	  if(prev!=null && root.data < prev.data)
	  {
		  //if it is not first node and current node value less than previous node value violation occur 
		  //store that node check it is first violation node or not
		  if(first==null)
		  {
			  //store prev node into first and root node into middle 
			  first = prev;
			  middle = root;
		  }
		  else
		  {
			  //if first violation node already found store current violation node into last
			  last = root;
		  }
	  }

	  //update prev by current root
	  prev = root;
	  
	  inOrder(root.right);
  }
   
	public static void main(String args[])
    {
          TreeNode root = constructTree();
          display(root);
          
          prev=null;
          first=null;
          last=null;
          middle=null;

		  inOrder(root);
		  //if both violation node found
		  if(first!=null && last!=null)
		  {
			  //swap value of both of them
			  int temp = first.data;
			  first.data = last.data;
			  last.data = temp;
		  }
		  else if(first!=null && middle!=null)
		  {
			   //swap value of adjacent node of first violation node with itself first violation node
			  int temp = first.data;
			  first.data = middle.data;
			  middle.data = temp;
		  }

          display(root);
    }
}