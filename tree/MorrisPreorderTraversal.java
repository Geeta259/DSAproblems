
/*
Morris preorder Traversal of a Binary tree
//it does not take any  extra space 0(1) constant space

0(n) + 0(n) nearly about 0(n) time complexity
*/
import java.util.*;

class MorrisPreorderTraversal extends ConstructBinaryTree
{	
    public static List<Integer> preorderTraversal(TreeNode root) {
        
        //use morris preorder tarversal to get inorder without taking any extra space //use threaded binary tree
    
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;

        //left--->root-->right

        //traverse until current node not becomes null
        //traverse through N nodes 0(n)
        while(curr!=null)
        {
            //if it leftmost nodes 
            if(curr.left==null)
            {
                //add current nodes into list
                list.add(curr.data);
                //move curr nodes right
                curr= curr.right;
            }
            else
            {
                //if it is not leftmost nodes
                //before moving left find rightmost of curr node
                //and link rightmost nodes to curr node

                //move to left part to find right most nodes without changing node current
                TreeNode prev = curr.left;

                //traverse until rightmost node found or right nodes already linked with current nodes
                //if any one case false stop iterate

                //iterate through overall all n nodes in worst case 0(n)
                //not for each iteration
                while(prev.right!=null && prev.right!=curr)
                 prev = prev.right;
                

                //two cases can be possible
                if(prev.right==null)
                {
                    //right most node linked with current root
                    //becuase after complete rightmost node it will directly come back to current node
                    prev.right = curr;
                    list.add(curr.data);
                    //move to left
                    curr = curr.left; 
                }
                else
                {
                    //it means prev.right already linked with current node
                    //left part is completed add current node into list and move right part
                    ///remove that link
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }

        return list;
    }
   
    public static void main(String args[])
    {
        //create tree from given values
         TreeNode root = constructTree();
          display(root);
        
         List<Integer> list  = new ArrayList<>();
         list = preorderTraversal(root);
		 System.out.println("Preorder traversal of given binary tree is " + list);
    }
}