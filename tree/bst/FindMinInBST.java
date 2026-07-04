
/*
 * Minimum element in BST
 * 
 * leftmost element in bst is minimum one if present otherwise root
 */


class FindMinInBST extends ConstructBinaryTree
{	
    public static void main(String args[])
    {

          TreeNode root = constructTree();
          display(root);
         
         if(root==null)
         System.out.println("Tree is empty no node present");
        
         //get leftmost node
        while(root.left!=null)
        root = root.left;
        
        //print that node value
         System.out.println("Minimum value present in binary search tree is " + root.data);
    }
}