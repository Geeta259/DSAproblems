
/*
 *  Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf node you could reach 
when you always travel preferring the left subtree over the right subtree. 

Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.

Reverse right boundary nodes: defined as the path from the right-most node to the root. The right-most node is the
 leaf node you could reach when you always travel preferring the right subtree over the left subtree. 
Exclude the root from this as it was already included in the traversal of left boundary nodes
*/

import java.util.*;

class BoundaryTraversal extends ConstructBinaryTree
{	
    public static void getLeftBoundary(TreeNode node,ArrayList<Integer> arr)
    {
        //if current node null return back
        if(node == null)
        return;
        
        //if left and right node not exist of current node means it is leaf node return back
        if(node.left==null && node.right==null)
        return;
        
        //add current boundary nodes into list
        arr.add(node.data);
        
        //first check left child exist or not if exist go to leftmost otherwise go to right one
        if(node.left!=null)
        getLeftBoundary(node.left,arr);
        else
        getLeftBoundary(node.right,arr);
    }
    
    public static void getLeafNode(TreeNode node,ArrayList<Integer> arr)
    {
        if(node==null)
        return;
        
        if(node.left==null && node.right==null)
        {    arr.add(node.data);
               return;
        }
     
        getLeafNode(node.left,arr);
        getLeafNode(node.right,arr);
    }
    
    public static void getRightBoundary(TreeNode node,ArrayList<Integer> temp)
    {
        if(node == null)
        return;
        
         //if left and right node not exist of current node means it is leaf node return back
        if(node.left==null && node.right==null)
        return;
        
        //add current boundary nodes into list
        temp.add(node.data);
        
        //first check right child exist or not if exist go to rightmost otherwise go to left one
        if(node.right!=null)
        getRightBoundary(node.right,temp);
        else
        getRightBoundary(node.left,temp);
    }
    
    public static void main(String args[])
    {
        //create tree from given values
         TreeNode root = constructTree();
          display(root);
          //create an arraylist to store boundary nodes
	       ArrayList<Integer> arr = new ArrayList<>();
	       
	       //check root value exist or not
	       if(root!=null)
           {
                //add root node value into list
                arr.add(root.data);
                
                
                if(root.left!=null || root.right!=null)
                {
                     //left traversal from root to leaf node  
                        //leaf node not included (left boundary nodes add into arraylist)
                        if(root.left!=null)
                        getLeftBoundary(root.left,arr);
                        
                        //add all leaf nodes into list
                        getLeafNode(root,arr);
                        
                    
                        //create an temporary list to add right boundary nodes then reverse it 
                        ArrayList<Integer> temp = new ArrayList<>();
                        if(root.right!=null)
                        getRightBoundary(root.right,temp);
                        
                        //reverse node from temp list to  arr list
                        for(int i = temp.size()-1;i>=0;i--)
                        arr.add(temp.get(i));
            
                }
                
                
           }
	        
	        //print all boundary nodes in resultant array
	       System.out.println("All Boundary nodes  of given tree \n" + arr);
    }
}