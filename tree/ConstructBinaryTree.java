/* insert nodes last visited root --> left --> right then enter left and right node of previous node and so on  */
import java.util.*;
//a treenode construct 
class TreeNode
{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data,TreeNode left,TreeNode right)
    {
       this.data = data;
       this.left = left;
       this.right = right;
    }
}


//pair class construct with node and state 
//state defined node inserted left,right or both filled
class Pair
{
    TreeNode node;
    int state;

    Pair(TreeNode node,int state)
    {
        this.node = node;
        this.state = state;
    }
}
public class ConstructBinaryTree
{
     public static void display(TreeNode node)
    {
        if(node == null)
        return;

        //if current node not null
        String str = "";
        //print left node node data right node
        str+= node.left==null?"null":node.left.data + "";
        str+= " <- " + node.data + " -> ";
        str+= node.right==null?"null":node.right.data + "";

        System.out.println(str);

        display(node.left);
        display(node.right);
    }
    

    public static TreeNode constructTree()
    {
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter no of level");
         int n = sc.nextInt();
         
         n = (int)Math.pow(2,n)-1;

         //max no of nodes inserted
         int[] arr = new int[n];
        
         System.out.println("Enter "+ n +" values in a preorder if any node not present in respective place -1 entered");
         for(int i=0;i<n;i++)
         arr[i] = sc.nextInt();
        

          TreeNode root=null;
         if(arr[0]!=-1)
         {  
             //create root node with 0 index value 
          root = new TreeNode(arr[0],null,null);

         //create pair for root node with state 1
         Pair rtp = new Pair(root,1);

         //create stack which contained pair
         Stack<Pair> st = new Stack<>();
         //root pair push into stack
         st.push(rtp);

         //create pair of root node with state 
         //1 insert left child 
         //2 insert right child 
         //3 complete pop out from stack
         //get value in a preorder construct

        int idx=1;
         while(!st.isEmpty() && idx<n)
         {
            //get peek node
              Pair top = st.peek();
              //if that node state 1 next value inserted left side of that node
              if(top.state==1)
              {
                
                 //check if it is not null
                 if(arr[idx]!=-1)
                 {
                    //create a new node with value arr[idx] and insert into left of top pair node
                    top.node.left = new TreeNode(arr[idx],null,null);
                    //create pair of new node with state 1 and push into stack
                    Pair lp = new Pair(top.node.left,1);
                    //push left pair into stack
                    st.push(lp);
                 }
                 else
                 //otherwise push node left null
                 top.node.left = null;

                 //update state 
                 //left child inserted go for right child with state 2
                 top.state = 2;
                 st.push(top);
                 idx++;
              }
              else if(top.state==2)
              {
                   
                    //check if it is not null
                    if(arr[idx]!=-1)
                    {
                        //create a new node with value arr[idx] and insert into right of top pair node
                        top.node.right = new TreeNode(arr[idx],null,null);
                        //create pair of new node with state 1 and push into stack
                        Pair rp = new Pair(top.node.right,1);
                        st.push(rp);
                    }
                    else
                    //otherwise push node right null
                    top.node.right = null;

                    //update state 
                    //right child inserted update state3 means pop out that node from stack
                    top.state = 3;
                    st.push(top);
                    idx++;
              }
              else
              {
                 //left and right inserted pop out that node from stack
                 st.pop();
              }
          }
        }
        
         return root;
    }
}

/**
 * 
 * insert node value 
 * fill from rightmost node first
 * 3-->.5-->7 (3 root 5 left child 7 right child)
 * 7-->-1-->9 (7 root -1 left 9 right) -- 7 complete
 * 9-->-1-->-1(9 root -1 left -1 right) --> 9  complete
 * 5-->-1-->-1 ( 5 root -1 left -1 right) -- > 5 complete
 */