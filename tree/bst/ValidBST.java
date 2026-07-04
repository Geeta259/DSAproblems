
/*
 Validate Binary Search Tree
Given the root of a binary tree, determine if it is a valid binary search tree (BST).
Input: root = [2,1,3]
Output: true
*/
class ValidBST extends ConstructBinaryTree
{	
    public static boolean checkBST(TreeNode root,long min,long max)
    {
        //if root null return true
        if(root==null)
        return true;

            //if root value not  lies between min to max return false not BST
        if(root.data<=min || root.data>=max)
        return false;

        //check for left part and right part
        //for left part max will be current root value
        //for right part min will be current root value
        //if any one return false it is not BST
        return checkBST(root.left,min,root.data) && checkBST(root.right,root.data,max);
    }

    public static void main(String args[])
    {

          TreeNode root = constructTree();
          display(root);
            
          boolean flag = checkBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
          if(flag)
          System.out.println("Given tree is BST");
          else
          System.out.println("Given tree is not BST");
    }
}