
/*
.Construct Binary Tree from Inorder and Postorder Traversal
Given two integer arrays inorder and postorder where inorder is the 
inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, 
construct and return the binary tree.

 Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
 
*/

import java.util.*;

class ConstructBinaryFromInPost
{	
    public static void preOrder(TreeNode root)
    {
        if(root==null)
        return;

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
       
    }

    public static TreeNode constructBT(int[] inorder,int istart,int iend, int[] postorder,int postart,int poend,HashMap<Integer,Integer> map) {

        //base condition if nothing start value greater than end value no node left
        if(istart>iend || postart>poend)
        return null;

        //last node of postorder is root node make it root node
        TreeNode root =  new TreeNode(postorder[poend],null,null);

        //get index of that node from map 
        //map contain inorder elements
        int idx = map.get(postorder[poend]);
        //count no of element in left part idx-istart
        int lcount = idx-istart;

        ///from starting to rootidx-1 left part inorder
        //from postart to postart+lcount-1 left part preorder 
        root.left = constructBT(inorder,istart,idx-1,postorder,postart,postart+lcount-1,map);
         ///from rootidx+1 to end right part inorder
        //from postart+lcount to poend right part preorder 
        root.right = constructBT(inorder,idx+1,iend,postorder,postart+lcount,poend-1,map);
        return root;
    }
    
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        //map used to get index of any node from inorder
        HashMap<Integer,Integer> map = new HashMap<>();
        //traverse in inorder and put into map
        for(int i=0;i<inorder.length;i++)
        map.put(inorder[i],i);

        //create binary tree and return root node of that tree
        TreeNode root = constructBT(inorder,0,inorder.length-1,preorder,0,preorder.length-1,map);   

        return root;
    }

   public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);   
        System.out.println("Enter no of nodes");
        int n = sc.nextInt();

        int inorder[] = new int[n];
        int postorder[] = new int[n];

        System.out.println("Enter inorder tarversal of binary tree");
        for(int i=0;i<n;i++)
        inorder[i] = sc.nextInt();

        System.out.println("Enter postorder tarversal of binary tree");
        for(int i=0;i<n;i++)
        postorder[i] = sc.nextInt();

        //map used to get index of any node from inorder
        HashMap<Integer,Integer> map = new HashMap<>();
        //traverse in inorder and put into map
        for(int i=0;i<inorder.length;i++)
        map.put(inorder[i],i);

        //create binary tree and return root node of that tree
        TreeNode root = constructBT(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);   

        System.out.println("Given tree preorder traversal is ");  
        preOrder(root);
    }
}

/*
 * 
 */