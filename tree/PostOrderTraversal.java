import java.util.*;
class PostOrderTraversal extends ConstructBinaryTree
{
    public static List<Integer> postOrder(TreeNode root) {
        //left --> right ---> node
    List<Integer> list = new ArrayList<>();

    //stack used to store node
    Stack<TreeNode> st = new Stack<>();

    //traverse until  root! null or  stack is not empty
    while(root!=null || !st.isEmpty())
    {
        //push node into stack if it not null
        if(root!=null)
        {
            st.push(root);
            root = root.left;
        }
        else
        {
            //left traversal done
            //get right node of last visited node 
            TreeNode right = st.peek().right;
            if(right==null)
            {
                //last viisted node left & right both visited
                //pop out that node and add into list
                TreeNode node = st.pop();
                list.add(node.data);

                //check pop out node is right node of peek node
                while(!st.isEmpty() && node == st.peek().right)
                {
                    //if it is remove that node also 
                    //because that node both child nodes visited
                    node  = st.pop();
                    list.add(node.data);
                }
            }
            else
            {
              //if right node of last visited node not null update root 
              root = right;
            }
        }
    }

    return list;
    }

    public static void main(String args[])
    {
          //declared arraylist to store preorder traversal
          List<Integer> list = new ArrayList<>();
          TreeNode root = constructTree();
          //display(root);
          
          list = postOrder(root);
          System.out.println(list);

    }
}