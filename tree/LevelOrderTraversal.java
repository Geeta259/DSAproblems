import java.util.*;
class LevelOrderTraversal extends ConstructBinaryTree
{
    public static List<List<Integer>> levelOrder(TreeNode root) {
        //create a list to store nodes level wise
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)
        return list;

        //create a queue to store nodes level wise
        Queue<TreeNode> que = new LinkedList<>();
        //add root node
        que.add(root);

        //traverse until queue is not empty
        while(!que.isEmpty())
        {
            //get current size of queue
            int size = que.size();
            //create list for current level
             List<Integer> li = new ArrayList<>();
             //loop until size not becomes 0
            while(size!=0)
            {
                //get node from queue
                TreeNode node = que.poll();
                //add that node value into list
                li.add(node.data);

                //if node left not null add into queue
                if(node.left!=null)
                que.add(node.left);
                //if node right not null add into queue
                if(node.right!=null)
                que.add(node.right);
                //decrement size by 1
                size--;
            }
            //add into  list
            list.add(li);
        }

        //return list
        return list;
    }

    public static void main(String args[])
    {
          //declared arraylist to store preorder traversal
          List<List<Integer>> list = new ArrayList<>();
          TreeNode root = constructTree();
          //display(root);
          
          list = levelOrder(root);
          System.out.println(list);

    }
}