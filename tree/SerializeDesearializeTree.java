import java.util.*;
class Node
{
    int val;
    Node left,right;
    Node(int val)
    {
        this.val = val;
    }
}

class SerializeDesearializeTree
{
    public static Node Desarialize(int[] arr)
    {
        if(arr[0]==-1)
        return null;

        Node root = new Node(arr[0]);
        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        int idx=1;
        while(!que.isEmpty())
        {
            Node getnode = que.poll();
            
            if(idx<arr.length && arr[idx]!=-1)
            {
                Node leftnode = new Node(arr[idx]);
                getnode.left = leftnode;
                que.offer(leftnode);
            }
            idx++;
            if(idx<arr.length && arr[idx]!=-1)
            {
                Node rightnode = new Node(arr[idx]);
                getnode.right = rightnode;
                que.offer(rightnode);
            }
            idx++;
        }
        return root;
    }

    public static int[] Serialize(Node root)
    {
        if(root==null)
        return new int[]{-1};

        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        ans.add(root.val);

        while(!que.isEmpty())
        {
            Node getnode = que.poll();
            if(getnode.left!=null)
            {
                ans.add(getnode.left.val);
                que.offer(getnode.left);
            }
            else
            ans.add(-1);

            if(getnode.right!=null)
            {
                ans.add(getnode.right.val);
                que.offer(getnode.right);
            }
            else 
            ans.add(-1);
        }

        int n = ans.size();
        int[] res = new int[n];
        for(int i=0;i<n;i++)
        res[i] = ans.get(i);

        return res;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();
        
        Node rootnode = Desarialize(arr);
        int ans[] = Serialize(rootnode);

        for(int i=0;i<ans.length;i++)
        System.out.println(ans[i] + " ");
    }
}