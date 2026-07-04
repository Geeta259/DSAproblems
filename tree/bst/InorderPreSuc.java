
/*
 find inorder Predecessor and inorder Successor of a given binary search tree
    
*/
import java.util.*;
class InorderPreSuc extends ConstructBinaryTree
{	
    public static void main(String args[])
    {
          TreeNode root = constructTree();
          display(root);

           int[] ans = new int[2];
           ans[0] =-1;
           ans[1] = -1;

           Scanner sc =  new Scanner(System.in);
           System.out.println("Enter value whom find inorder predecessor and successor");
           int key = sc.nextInt();

          //store root node into current
          TreeNode curr = root;
          //traverse until current  not becomes null
          while(curr!=null)
          {
             //first focuus on to find predecessor
             //if current node value less than key value it may be predecessor 
             if(curr.data < key)
             {
                 //updtae 0 index which contain predecessor by current node value
                 ans[0] = curr.data;
                 //move to right immediate predecessor
                 curr = curr.right;
             }
             //if current node value greater than key value move left to find smallest node value
             else
             curr = curr.left;
          }
          
          //update  current node from root to find successor
          curr = root;
          //traverse until current node becomes null
          while(curr!=null)
          {
             //focuus on to find sucsecessor
             //if current value greater than key it may be successor move left to  find immediate successor
             if(curr.data > key)
             {
                //updtae 1 index which contain sucsecessor by current node value
                 ans[1] = curr.data;
                 curr = curr.left;
             }
             
             //move right to find greate node value than key value
             else
             curr = curr.right;
          }

          System.out.println("Inorder predecessor of given BST is " + ans[0]);
          System.out.println("Inorder successor of given BST is " + ans[1]);
    }
}