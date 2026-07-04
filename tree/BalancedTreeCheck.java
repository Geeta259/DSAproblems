
class BalancedTreeCheck extends ConstructBinaryTree
{	
        public static int checkBalanced(TreeNode root)
        {
            //base or terminate condition
            if(root == null)
            return 0;

            //get height of left sub tree
            int left = checkBalanced(root.left);
            //if at any pointe left subtree height get -1 return back with value -1 from this point
            if(left==-1)
            return -1;

            //get height of right sub tree
            int right = checkBalanced(root.right);
            //if at any point right subtree height get -1 return back with value -1 from this point
            if(right==-1)
            return -1;

            //get absolute value of left and right sub tree
            //if it greater than 1  return back with value -1
            if(Math.abs(left-right)>1)
            return -1;

            //otherwise return height of sub tree
            return Math.max(left,right)+1;
        }

    public static void main(String args[])
    {

          TreeNode root = constructTree();
          display(root);
          int check = checkBalanced(root);
          if(check==-1)
          System.out.println("Given binary tree is not balanced");
          else
          System.out.println("Given binary tree is balanced");

    }
}