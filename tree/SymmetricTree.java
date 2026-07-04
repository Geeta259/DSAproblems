
/*
Symmetric Tree
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

*/

import java.util.*;

class SymmetricTree extends ConstructBinaryTree
{	

    public static boolean symmetricCheck(TreeNode p,TreeNode q)
    {
        //if exactly one of them is null among two return false
        if((p==null && q!=null) || (p!=null && q==null))
        return false;

        //if both null return true
        if(p==null && q==null)
        return true;

        //if value of both node not equal return false
        if(p.data!=q.data)
        return false;

        //check left node of left subtree equal right node of right subtree
        //check right node of left sub tree should be equal to left node of  right sub tree
        return symmetricCheck(p.left,q.right) && symmetricCheck(p.right,q.left);

    }

    public static void main(String args[])
    {
        //create tree from given values
         TreeNode root = constructTree();
          display(root);
        
         if(symmetricCheck(root.left,root.right))
         System.out.println("Given tree is symmetric tree");
         else
         System.out.println("Given tree is not symmetric tree");
        
    }
}