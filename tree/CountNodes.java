
/*
Count Complete Tree Nodes
Given the root of a complete binary tree, return the number of the nodes in the tree.

Design an algorithm that runs in less than O(n) time complexity.
*/

class CountNodes extends ConstructBinaryTree
{	
    public static int leftHeight(TreeNode root)
    {
        //if root null return 0
        if(root==null)
        return 0;

        int count=0;
        //traverse until root not beocmes null and increment count
        while(root!=null)
        {
            count++;
            root=root.left;
        }

        //return total no of nodes in left side
        return count;
    }
     public static int rightHeight(TreeNode root)
    {
        //if root  null return 0
        if(root==null)
        return 0;

        int count=0;
        //traverse until root not becomes null and increment count 
        while(root!=null)
        {
            count++;
            root=root.right;
        }
        //return total no of nodes in right side
        return count;

    }
    public static int countNodes(TreeNode root) {
        //if root is null return 0 
        if(root==null)
        return 0;

        //count left height of current node
        int lefth = leftHeight(root);
        //count right height of current node
        int righth = rightHeight(root);


        if(lefth==righth)
        {
            //if both are equal means left and right subtree height are equal 
            //it is full binary tree return total no of nodes which is 2^h-1
            return ((1<<lefth)-1);
        }

        //if left height and right height not equal means it is not full binary tree
        //count 1 nodes and go for left subtree then go for right subtree
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
   
    public static void main(String args[])
    {
        //create tree from given values
         TreeNode root = constructTree();
          display(root);
        
         int count = countNodes(root);
		 System.out.println("Total no of nodes in a complete binary tree is " + count);
    }
}