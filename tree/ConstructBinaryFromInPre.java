
/*
. Construct Binary Tree from Preorder and Inorder Traversal
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
 and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
 
*/

import java.util.*;

class ConstructBinaryFromInPre
{	
    public static void postOrder(TreeNode root)
    {
        if(root==null)
        return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static TreeNode createBT(int[] inorder,int istart,int iend,int[] preorder,int prestart,int preend,HashMap<Integer,Integer> map)
    {
        //base condition if nothing start value greater than end value no node left
        if(istart>iend || prestart>preend)
        return null;

        //first node of preorder is root node make it root node
        TreeNode root =  new TreeNode(preorder[prestart],null,null);

        //get index of that node from map 
        //map contain inorder elements
        int idx = map.get(preorder[prestart]);
        //count no of element in left part idx-istart
        int lcount = idx-istart;

        ///from starting to rootidx-1 left part inorder
        //from prestart+1 to prestart+lcount left part preorder 
        root.left = createBT(inorder,istart,idx-1,preorder,prestart+1,prestart+lcount,map);
         ///from rootidx+1 to end right part inorder
        //from prestart+lcount+1 to preend right part preorder 
        root.right = createBT(inorder,idx+1,iend,preorder,prestart+lcount+1,preend,map);
        return root;
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        //map used to get index of any node from inorder
        HashMap<Integer,Integer> map = new HashMap<>();
        //traverse in inorder and put into map
        for(int i=0;i<inorder.length;i++)
        map.put(inorder[i],i);

        //create binary tree and return root node of that tree
        TreeNode root = createBT(inorder,0,inorder.length-1,preorder,0,preorder.length-1,map);   

        return root;
    }

   public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);   
        System.out.println("Enter no of nodes");
        int n = sc.nextInt();

        int inorder[] = new int[n];
        int preorder[] = new int[n];

        System.out.println("Enter inorder tarversal of binary tree");
        for(int i=0;i<n;i++)
        inorder[i] = sc.nextInt();

        System.out.println("Enter preorder tarversal of binary tree");
        for(int i=0;i<n;i++)
        preorder[i] = sc.nextInt();

        //map used to get index of any node from inorder
        HashMap<Integer,Integer> map = new HashMap<>();
        //traverse in inorder and put into map
        for(int i=0;i<inorder.length;i++)
        map.put(inorder[i],i);

        //create binary tree and return root node of that tree
        TreeNode root = createBT(inorder,0,inorder.length-1,preorder,0,preorder.length-1,map); 
        System.out.println("Given tree postorder traversal is ");  
        postOrder(root);
    }
}

/*
 * 
 */