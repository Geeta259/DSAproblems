
/*
 * Diameter of Binary Tree
Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them
 */
class FindDiameter extends ConstructBinaryTree
{	
    public static int maxlength=0;
    public static int getLongestPath(TreeNode root)
    {
        //check root is null or not
        if(root==null)
        return 0;

        //get left height and right height of each node
        int left = getLongestPath(root.left);
        int right = getLongestPath(root.right);

        //update max length if find longest path than maxlength
        maxlength = Math.max(maxlength,left+right);

        //return to previous node 
        //add 1 more edges to maximum one either left or right side edges  
        return 1 + Math.max(left,right);
    }

    public static void main(String args[])
    {
         TreeNode root = constructTree();
          display(root);
          maxlength=0;
         getLongestPath(root);
        System.out.println("Diameter of given tree is " + maxlength);;
    }
}