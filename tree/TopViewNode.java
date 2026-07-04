
/*
 *  
 Top View of Binary Tree
 Given below is a binary tree. The task is to print the top view of binary tree. \
 Top view of a binary tree is the set of nodes visible 
 when the tree is viewed from the top. For the given below tree

 in a top view vertical line first node value take it rest not take it
 to keep track current line first value already taken or not map will be used
 //used level order traversal add pair value node with line in queue
 //get line of popped out nodes if left child add in queue line decrement by one
 //if right child add in queue line increment by one
*/

import java.util.*;

class LinePair
{
    TreeNode node;
    int line;

    LinePair(TreeNode node,int line)
    {
        this.node = node;
        this.line = line;
    }
}
class TopViewNode extends ConstructBinaryTree
{	
    public static void main(String args[])
    {
        //create tree from given values
         TreeNode root = constructTree();
          display(root);
           //create an arraylist to store all top view nodes
        ArrayList<Integer> arr = new ArrayList<>();
        
        //lining concept use each vertical line first element we will considered as a top view node
        //use level order traversal
        
        //create a queue to traverse level order stored pair data node with line no 
        Queue<LinePair> que = new LinkedList<>();
        
        if(root!=null)
        {
                    
                //create a map to check node already present or not of a current line no
                //data from map sorted order according to line no 
                //tree map used becuase it stored key data in sorted way
                Map<Integer,Integer> map = new TreeMap<>();
                
                //create root node pair with line 0 root node considered in line 0 
                LinePair rt = new LinePair(root,0);
                //add pair into  queue
                que.add(rt);
                
                //iterate until que is not empty
                while(!que.isEmpty())
                {
                    //get current size of queue
                    int size = que.size();
                    
                    while(size!=0)
                    {
                        //get current level node from queue
                        LinePair pa = que.poll();
                        
                        //check line no of poll pair if this line data already present in map
                        //no need  to add into  map
                        if(!map.containsKey(pa.line))
                        map.put(pa.line,pa.node.data);
                        
                        //check left and right nodes of popped out node
                        if(pa.node.left!=null)
                        {
                            //if present left nodes add into queue with line -1
                            //add node into queue with line-1
                            que.add(new LinePair(pa.node.left,pa.line-1));
                        }
                        
                        //check left and right nodes of popped out node
                        if(pa.node.right!=null)
                        {
                            //if present right nodes add into queue with line+1
                            //add node into queue with line+1
                            que.add(new LinePair(pa.node.right,pa.line+1));
                        }
                        
                        size--;
                    }
                
                }
                
                
                //get data from map and add value into list
                for(Map.Entry<Integer,Integer> entry : map.entrySet())
                {
                    arr.add(entry.getValue());
                }
                
        }
        
	        //print all boundary nodes in resultant array
	       System.out.println("All Top view nodes of given tree is \n" + arr);
    }
}