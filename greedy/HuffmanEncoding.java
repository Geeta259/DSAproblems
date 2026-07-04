
import java.util.*;
//create a class Node to construct a tree
class Node
{
    int freq;
    Node left,right;
    Node(int freq)
    {
        this.freq = freq;
        left = null;
        right = null;
    }
}

class HuffmanEncoding
{
    public static void preOrder(Node root,String s,ArrayList<String> ans)
    {
           //if it is leaf node add current string into list for a character
        if(root.left==null && root.right==null)
        { ans.add(s); return; }
        
        //traverse left side add 0 into string
        preOrder(root.left,s+"0",ans);
        //traverse right side add 1 into string
        preOrder(root.right,s+"1",ans);
        
    }
    public static ArrayList<String> huffmanCodes(int f[], int N)
    {
        //create a min heap to store nodes according to their frequency data
        //if first value less than second no swap return -1 
        //otherwise first value graeter than second swap by return 1
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y)->x.freq < y.freq ? -1 : 1);
        
        //create node for all  n character  with value their frequency
        for(int i=0;i<N;i++)
        {
            Node temp = new Node(f[i]);
            //add node into prioirty queue
            pq.offer(temp);
        }
        
        
        //polled out node from priorityqueue until more than 1 nodes present into pq
        while(pq.size() > 1)
        {
            //polled out two nodes from priority queue which contain less frequency 
            //one for left and one for right
            Node left = pq.poll();
            Node right = pq.poll();
            
            //create new node which is parent node contain frequency which is equal to sum of left and right child node
            Node parent = new Node(left.freq + right.freq);
            //link left and right nodes with parent
            parent.left = left;
            parent.right = right;
            
            //add new parent node into queue
            pq.offer(parent);
        }
     
     
        //at last one nodes definitely contain in priority queue which is root node
        Node root = pq.poll();
        
        //now huffman tree constructed traverse in preorder and binary string stored in arraylist
        ArrayList<String> ans = new ArrayList<>();
        //store bit for each character in a preorder way
        preOrder(root,"",ans);
        //return that arraylist
        return ans;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of distinct character");
        int n = sc.nextInt();

        int freq[] = new int[n];
       
        System.out.println("Enter frqeuency of each character represented with index");
        for(int i=0;i<n;i++)
        {
           freq[i] = sc.nextInt();
        }

        ArrayList<String> ans = huffmanCodes(freq,n);
        System.out.println("Bit pattern of all distinct character is " + ans);
        System.out.println(ans);
    }
}