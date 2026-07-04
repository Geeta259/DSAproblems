
/*
 * .
 *Lowest Common Ancestor of a Binary Search Tree
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
*/

import java.util.Scanner;

class LowestCommonAncestor extends ConstructBinaryTree
{	
    public static TreeNode lCA(TreeNode root, int p, int q) {
        //if root null return null
        if(root==null)
        return null;

          //if both p and q node value small than root value move to left subpart
        if(p < root.data && q < root.data)
        {
            //both lies in left sub tree
            return lCA(root.left,p,q);
        }
      //if both p and q node value greater than root value move to right subpart
        else if(p > root.data && q > root.data)
        {
            return lCA(root.right,p,q);
        }
        //if one  lies in left and on elies in right split that one is LCA return that node
        else
        return root;        
    }

    public static void main(String args[])
    {
          System.out.println("Enter unique value of nodes");
          TreeNode root = constructTree();
          display(root);
         
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter first node value to get");
          int p = sc.nextInt();
          System.out.println("Enter second node value to get");
          int q = sc.nextInt();

          TreeNode node = lCA(root,p,q);
          System.out.println("Lowest common ancestor of given two nodes is " + node.data);
    }
}