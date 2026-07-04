
/*
 * Search in a Binary Search Tree
You are given the root of a binary search tree (BST) and an integer val.
Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
 If such a node does not exist, return null.
 */

import java.util.Scanner;

class SearchInBST extends ConstructBinaryTree
{	
       
    public static TreeNode searchBST(TreeNode root, int val) {
        if(root==null)
        return null;

        if(root.data==val)
        return root;

        if(root.data < val)
        root = searchBST(root.right,val);
        else
        root = searchBST(root.left,val);

        return root;
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
          System.out.println("Enter value which you want to search");
          int val = sc.nextInt();
          root = searchBST(root,val);
          
          preOrder(root);
    }
}