import java.util.*;

class BSTIterator
{
	//create a instance variable to know whether we have to find next greater or next smaller
	boolean reverse = false;

	//if reverse false iterate left to right find next greater element
	//if reverse true iterate right to left find next smaller element

	//create a stack to get next greater or next smaller element
	Stack<TreeNode> st = new Stack<>();
	public BSTIterator(TreeNode root , boolean reverse)
	{
		//get value of reverse
		this.reverse = reverse;
		//push element in stack 
		pushAll(root);
	}

	public void pushAll(TreeNode root)
	{
		//traverse until root not becomes null
		while(root!=null)
		{
				st.push(root);
				//if reverse true means find next smaller right to left
				if(reverse)
				{
					//push all right side elements in to stack to get highest element first , then lowest no
					root = root.right;
				}
				else
				{
					//if reverse not set push left elements into stack to get lowest element first , then highest no
					root = root.left;
				}
		}
	}

	//to get next value either left to right increasing value or
	//right to left next decreasing value
	public int next()
	{
		//pop out top elements from  stack
		TreeNode temp = st.pop();

		//check current instance reverse variable set or not
		if(reverse)
		{
			//if reverse set means store next decreasing value than this (right to left)
			//left nodes push into stack

             //pop right greatest value already pop out stack push left
			pushAll(temp.left);
		}
		else
		{
			//if reverse not set means store next increasing value than this (left to right) 
			//right nodes push into stack

            //pop left smallest value already pop out stack push right 
			pushAll(temp.right);
		}

		return temp.data;
	}
}
class FindPairSum extends ConstructBinaryTree{

    public static boolean findTarget(TreeNode root, int k) {
      //create two object of bstiterator class 
		//one object stack store nodes value to traverse left to right
		//another object stack store nodes value to  traverse right to left
		BSTIterator bst1 = new BSTIterator(root, false);
		BSTIterator bst2 = new BSTIterator(root, true);
		
		//get first node value and last node value 
		int left = bst1.next();
		int right = bst2.next();

        System.out.println(left + " " + right);

		//traverse until left smaller than right
		while(left < right)
		{
			//check sum value 
			if(left + right == k)
			return true;

			else if(left + right < k)
			{
				//increase value to find next greater element for this bst1 operator
				left = bst1.next();
			}
			else
			////increase value to find next smaller element for this bst2 operator
			{
				right = bst2.next();
			}
		}

		//if not a single pair found return false
		return false;
    }

	public static void main(String args[])
    {

          TreeNode root = constructTree();
          display(root);
           
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of pair");
		int k = sc.nextInt();

        if(findTarget(root,k))
		System.out.println("Pair exist in a tree");
		else
		System.out.println("Pair does not exist in a tree");
    }
}