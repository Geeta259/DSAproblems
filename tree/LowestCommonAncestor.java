
/*
. Lowest Common Ancestor of a Binary Tree
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

Approach:
check left subtree and right subtree value if any one given node find return that node
if left subtree value return null means not any given nodes find in left subtree it must be right subtree return right
if right subtree value return null means not any given nodes find in right subtree it must be in left subtree return left
if left subtree not give null value and right subtree also give not null value means current one is lca which is common for both
//return that node
*/

import java.util.*;

class LowestCommonAncestor extends ConstructBinaryTree
{	

    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        //if current node is null
        if(root==null)
        return null;

        //if current root is either p or q return that node 
        if(root.data==p || root.data==q)
        return root;

        //check return left value 
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        //check return right value
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        

        //if left part return null means neither p or q not found return right value
        if(left==null)
        return right;

        //if right part return null means neither p or q not found return left value
        if(right==null)
        return left;

        //if left and right part both are not null return current root value
        //which is ancestors of p and q
        return root;
        
    }


    public static void main(String args[])
    {
        //create tree from given values
		System.out.println("Enter all unique values of nodes");
         TreeNode root = constructTree();
          display(root);
        
		System.out.println("Enter value of nodes which you want to find lowest common ancestors");
        Scanner sc = new Scanner(System.in);
		int val1 = sc.nextInt();
        int val2 = sc.nextInt();

        TreeNode getancestor = lowestCommonAncestor(root,val1,val2);
        System.out.println("Lowest Common Ancestor of a Binary Tree is " + getancestor.data);
    }
}

/*
 *
 */