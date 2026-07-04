
/*
 * Same Tree
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
class CheckSameTree extends ConstructBinaryTree
{	
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        //if one node is null and other one is not null
        //return false not identical
        if((p==null && q!=null) || (p!=null && q==null))
        return false;
        
        //if both null return true
        if(p==null && q==null)
        return true;

        //if p and q value not equal return false
        if(p.data!=q.data)
        return false;

        //check for left sub tree and right sub tree if any one return false 
        //return false
        //if both sub tree return true then both tree is identical
        return  isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public static void main(String args[])
    {
         TreeNode root1 = constructTree();
          display(root1);
          TreeNode root2 = constructTree();
          display(root2);
        
         boolean get = isSameTree(root1,root2); 
        if(get)
        System.out.println("Both trees are identical");
        else
        System.out.println("Both trees are not identical");
    }
}