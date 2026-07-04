import java.util.*;
class InOrderTraversal extends ConstructBinaryTree
{
    public static List<Integer> inOrder(TreeNode root) {
        //using iteratively
        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while(true)
        {
            while(root!=null)
            {
                st.push(root);
                root = root.left;
            }
            if(st.isEmpty())
            break;

            TreeNode node = st.pop();
            list.add(node.data);
            root = node.right;
        }

        return list;
    }
    public static void main(String args[])
    {
          //declared arraylist to store preorder traversal
          List<Integer> list = new ArrayList<>();
          TreeNode root = constructTree();
          display(root);
          
          list = inOrder(root);
          System.out.println(list);

    }
}