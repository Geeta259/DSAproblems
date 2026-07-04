
/*
 * .
 *  Delete Node in a BST
Given a root node reference of a BST and a key, delete the node with the given key in the BST. 
Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
 */

import java.util.Scanner;

class BSTDeletion extends ConstructBinaryTree
{	
  
    public static TreeNode findRightMost(TreeNode root)
    {
        //rightmost node of left sub tree is minimum node
		while(root.right!=null)
		{
			//move to right part
			root = root.right;
		}
		//return root value
		return root;
    }
    public static TreeNode deleteNode(TreeNode root, int key) {
        //if root is null return
        if(root==null)
        return null;

        //if given deleted value is root node
        if(root.data==key)
        { return removeNode(root);}

        //store root node
        TreeNode curr = root;
        //traverse until node becomes null
        while(curr!=null)
        {
            if(curr.data > key)
            {
                 //check if current node value greater than key check  left side 
                    if(curr.left!=null && curr.left.data==key)
                    {
                        //if deleted node is in left part 
                        curr.left = removeNode(curr.left);
                    }
                    else
                    {
                        //otherwise move left side
                        curr = curr.left;
                    }

            }
            else
            {
                //check for right part

                //check if current node value greater than key check right side 
                    if(curr.right!=null && curr.right.data==key)
                    {
                        //if deleted node is in right part 
                        curr.right = removeNode(curr.right);
                    }
                    else
                    {
                        //otherwise move right side
                        curr = curr.right;
                    }
            } 
        }

        return root; 
       } 

        public static TreeNode removeNode(TreeNode dltnode)
        {
            //if no  left child exist of deleted  node return right part
            if(dltnode.left==null)
            return dltnode.right;

            //if no  right child exist of deleted  node return left part
            if(dltnode.right==null)
            return dltnode.left;
            

            //if both left and right child exist
            //find right most of left part of deleted node
            TreeNode leftrightmost = findRightMost(dltnode.left);
            leftrightmost.right = dltnode.right;
            return dltnode.left;
        }

    public static void preOrder(TreeNode root)
    {
        if(root==null)
        return;

        System.out.print(root.data +" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String args[])
    {

          TreeNode root = constructTree();
          display(root);
         
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter node value which you want to delete");
          int val = sc.nextInt();
         
          root = deleteNode(root,val);
          
          preOrder(root);
    }
}