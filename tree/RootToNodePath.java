
/*
Print Root to Node Path in a Binary Tree.
Write a program to print path from root to a given node in a binary tree.
*/

import java.util.*;

class RootToNodePath extends ConstructBinaryTree
{	

    public static boolean getPath(TreeNode root,List<Integer> path,int val)
	{
        //if current root is null return false not found yet
      	if(root==null)
		return false;

        //add current node value into list
		path.add(root.data);
        //check current node value is required value if it is return true 
		if(root.data==val)
        { return true;}

        //if required node not found yet
        // check in left subtree and right subtree of current node if it found in either left or right return true
		 if(getPath(root.left,path,val) ||  getPath(root.right,path,val))
         return true;

        //if for a particular node left and right child checked and required node not found remove that node from list 
        //while return back remove that node it's not connsidered in required path
		path.remove(path.size()-1);
        return false;
	}


    public static void main(String args[])
    {
        //create tree from given values
		System.out.println("Enter all unique values of nodes");
         TreeNode root = constructTree();
          display(root);
        
		System.out.println("Enter value of nodes till where you want to print path");
        Scanner sc = new Scanner(System.in);
		int val = sc.nextInt();

        List<Integer> path = new ArrayList<>();
        getPath(root,path,val);
        System.out.println("Path from root node to given node is " + path);
    }
}

/*
 * output
 * 
 * entr value in a order
 * node --> leftnode-->rightnode-->rightleftnode-->rightrightnode-->leftleftnode-->leftrightnode
 *  
 Enter all unique values of nodes
Enter no of level
4
Enter 15 values in a preorder if any node not present in respective place -1 entered
1 2 3 -1 -1 4 5 6 7 -1 -1 -1 -1 -1 -1
2 <- 1 -> 3
4 <- 2 -> 5
null <- 4 -> null
6 <- 5 -> 7
null <- 6 -> null
null <- 7 -> null
null <- 3 -> null
Enter value of nodes till where you want to print path
3
All Path from root node to given node is [1, 3]
 */