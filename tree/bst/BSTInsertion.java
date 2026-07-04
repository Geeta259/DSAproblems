
/*
 * . Insert into a Binary Search Tree
You are given the root node of a binary search tree (BST) and a value to insert into the tree.
 Return the root node of the BST after the insertion.
 It is guaranteed that the new value does not exist in the original BST.

 Input: root = [4,2,7,1,3], val = 5
Output: [4,2,7,1,3,5]
 */

import java.util.Scanner;

class BSTInsertion extends ConstructBinaryTree
{	
       
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        //create a newnode  of given value
        TreeNode newnode = new TreeNode(val,null,null);
        //take another variable curr node
        TreeNode curr = root;

        //if root null return newnode
        if(root==null)
        return newnode;

        //traverse until current node becomes null
        while(curr!=null)
        {
            //if  given value greater than current node move right
            if(val>curr.data)
            {
                //check if it is last node if it is add new node curr right and break from it
                if(curr.right==null)
                {
                    curr.right = newnode;
                    break;
                }
                
                curr=curr.right;
            }
            //otherwise move left
            else
            {
                 //check if it is last node if it is add new node curr left and break from it
                if(curr.left==null)
                {
                    curr.left = newnode;
                    break;
                }
                
                curr=curr.left;
            }
        }

        //return root 
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
          System.out.println("Enter value which you want to insert");
          int val = sc.nextInt();
         
          root = insertIntoBST(root,val);
          
          preOrder(root);
    }
}