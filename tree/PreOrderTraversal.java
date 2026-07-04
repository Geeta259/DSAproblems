import java.util.*;
class PreOrderTraversal extends ConstructBinaryTree
{
    public static List<Integer> preOrder(TreeNode root) {
        //declared arraylist to store preorder traversal
        List<Integer>  list = new ArrayList<>();

        //if current root null return list
        if(root==null)
        return list;

        //using iteratively 
        //create stack 
        Stack<TreeNode> st = new Stack<>();
        while(true)
        {
                //if current root is not null
                while(root!=null)
                {
                    //add into list
                    list.add(root.data);
                    //push current node into stack
                    st.push(root);
                    //move into left node
                    root = root.left;
                }

                //all left node covered 
                //if stack is empty break from loop 
                if(st.isEmpty())
                break;

                //pop out node from stack 
                root = st.pop();
                //go to right  of that node
                root = root.right;
        }
        
        return list;
    }

    public static void main(String args[])
    {
          //declared arraylist to store preorder traversal
          List<Integer> list = new ArrayList<>();
          TreeNode root = constructTree();
          display(root);
          
          list = preOrder(root);
          System.out.println(list);

    }
}