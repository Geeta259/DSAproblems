
/*
All Root to Leaf Paths In Binary Tree.
Given the root of a binary tree, return all root-to-leaf paths in any order.
A leaf is a node with no children.
*/

import java.util.*;

class BinaryTreePath extends ConstructBinaryTree
{	

    public static void getAllPath(TreeNode root,StringBuilder str,List<String> arr)
	{
        if(root==null)
		return;
	    
		//if it is leaf node append current node into string then add into list 
		if(root.left==null && root.right==null)
		{
				arr.add(str.append(root.data).toString());
				return;
		}
	
		//get current length of stringbuilder before append root value
		int len = str.length();
		//move to left subtree after append root data in string
		getAllPath(root.left, str.append(root.data+"->"), arr);
		//set orignal length  of stringbuilder while return back
		str.setLength(len);
		//move to right subtree after append root data in string
		getAllPath(root.right,str.append(root.data+"->"), arr);
		//while return  back set string orignal length
		str.setLength(len);
	}


    public static void main(String args[])
    {
        //create tree from given values
         TreeNode root = constructTree();
          display(root);
        
        List<String> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        getAllPath(root,sb,arr);
        
        System.out.println("All Path from root node to leaf node is " + arr);
    }
}