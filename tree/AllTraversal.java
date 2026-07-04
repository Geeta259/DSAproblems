import java.util.*;
class AllTraversal extends ConstructBinaryTree
{
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
		//create a list of inorder,preorder and postorder
		List<Integer> inorder   = new ArrayList<>();
		List<Integer> preorder  = new ArrayList<>();
		List<Integer> postorder = new ArrayList<>();


		//create a stack  to insert node
		Stack<Pair> st = new Stack<>();	
		//1 for preorder 2 for inorder 3 for postorder
		Pair rt = new Pair(root,1);	
		st.push(rt);

		while(!st.isEmpty())
		{
			//pop out peek node from stack
			Pair tn = st.pop();
			if(tn.state==1)
			{
				preorder.add(tn.node.data);
				//state change to 2 for insert in inorder
				tn.state=2;
				//again push back in stack
				st.push(tn);

				//check left node present or not if present insert into stack
				if(tn.node.left!=null)
				st.push(new Pair(tn.node.left,1));
			}
			else if(tn.state==2)
			{
				//add into  inorder
				inorder.add(tn.node.data);
				//state change to 3 to add in postorder
				tn.state=3;
				//again push back in stack
				st.push(tn);

				//check for right node if present add into stack
				if(tn.node.right!=null)
				st.push(new Pair(tn.node.right,1)); 
			}
			else
			{
				//add into postorder
				postorder.add(tn.node.data);
				//now no need to insert again back in stack
			}
		}

		List<List<Integer>> list = new ArrayList<>();
		list.add(preorder);
		list.add(inorder);
		list.add(postorder);

		return list;
    }

    public static void main(String args[])
    {
          //declared arraylist to store preorder traversal
          List<List<Integer>> list = new ArrayList<>();
          TreeNode root = constructTree();
          display(root);
          
          list = getTreeTraversal(root);
          System.out.println(list);

    }
}