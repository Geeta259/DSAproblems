
class FindHeight extends ConstructBinaryTree
{
    public static int maxDepth(TreeNode root) {
        if(root==null)
        return 0;

        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public static void main(String args[])
    {

          TreeNode root = constructTree();
          display(root);
          int height = maxDepth(root);
          System.out.println("Max height of given tree is "+ height);

    }
}