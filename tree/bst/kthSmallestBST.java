
/*
 * .
 *   Kth Smallest Element in a BST
Given the root of a binary search tree, and an integer k, return the kth smallest value
 (1-indexed) of all the values of the nodes in the tree.

 
 Input: root = [3,1,4,null,2], k = 1
Output: 1

use morris inorder tarversal becuase it does not take extra space 
inorder of bst give nodes in ascending order does not need to store inorder in any extra data structure because we just want to get kth nodes
 
to find kth largest
first find total no  of nodes  
then find total - k nodes from starting of inorder tarversal 
//it give kth nodes from ending
//two traversal required in this case
*/

import java.util.Scanner;

class kthSmallestBST extends ConstructBinaryTree
{	
 public static int kthSmallest(TreeNode root, int k) {

        //use morris inorder traversal bcz it will take 0(1) no extra space
        //declare a count variable to get kth smallest number
        int count=0;

        //traverse until root not becomes null
        while(root!=null)
        {
            //if root left is null 
            if(root.left==null)
            {
                //increment count bcz root itself add into  inorder
                count++;
                //check if it is equal to k 
                //if it is break  out from loop
                if(count==k)
                break;

                //left part  is completed root couted move to right part
                root=root.right;
            }
            else
            {
                //if left part not null not completed yet
                TreeNode leftright = root.left;

                //before move to left get right most node of left part
                //or traverse until rightmost linked with root itself
                while(leftright.right!=null && leftright.right!=root)
                leftright = leftright.right;

                //if rightmost node is null linked rightmost node of left part to current root then move left part
                if(leftright.right==null)
                {
                    leftright.right = root;
                    root = root.left;
                }
                else
                {
                    //if it already rightmost linked with root means left part completed remove linked
                    leftright.right=null;
                    //root value counted increment count by 1
                    count++;
                    //check if it is equal to k  break out from loop
                    if(count==k)break;

                    //move to right part
                    root = root.right;
                }
            }
      
        }

        //return root value at k nodes
        return root.data;
    }

    public static void main(String args[])
    {

          TreeNode root = constructTree();
          display(root);
         
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter kth smallest value to get");
          int k = sc.nextInt();
         
          int val = kthSmallest(root,k);
          System.out.println(k + " smallest value in BST is " + val);
    }
}