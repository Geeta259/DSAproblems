
/*
 *Construct Binary Search Tree from Preorder Traversal
Input: preorder = [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
*/

import java.util.Scanner;

class ConstructBSTFromPreorder extends ConstructBinaryTree
{	
     public static int idx;

     public static TreeNode createBST(int[] preorder,int max)
    {
        //if all value of preorder add in a tree or  current value greater than max value return from this call 
        //can not add in to left sub tree
        if(idx==preorder.length || preorder[idx]>max)
        return null;

        //create current node of current index value and increment index  value
        TreeNode curr = new TreeNode(preorder[idx],null,null);
        idx++;

        //move to left side update now max limit  to current value
        curr.left = createBST(preorder,curr.data);

        //if from left side return null  then move right side this time max limit will not updated it same as previous value
        curr.right = createBST(preorder,max);

        //at last return node 
        return curr;
    }

    public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);

          System.out.println("Enter no of nodes");
          int n =  sc.nextInt();

          System.out.println("Enter node value in a preorder traversal");
          int preorder[] = new int[n];

          for(int i=0;i<n;i++)
          preorder[i] = sc.nextInt();
          

        //optimal approach used
        idx=0;
        //start to create BST with upper bound max value
        TreeNode root = createBST(preorder,Integer.MAX_VALUE);     
        display(root);        
    }
}