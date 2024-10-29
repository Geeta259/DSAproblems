 public  static void partition(Node node,Node[] left,Node[] right)
    {
   //traverse through list after pivot node
        Node temp = node.next;
        while(temp!=null)
        {
          //stored next node
            Node nextnode  = temp.next;
            //if it less than pivot node
            if(temp.data <= node.data)
            {
              //add into left list  update left list  head by  temp
                temp.next = left[0];
                left[0] = temp;
            }
            else{
              //if it greater  than pivot node
              //add into right list update right list head by  temp
                temp.next = right[0];
                right[0] = temp;
            }
            //move  to next node
            temp = nextnode;
        }
    
    }
    public static Node quickSort(Node node) {
        // Your code here
      //if a single node remaining return that node base condition
        if(node==null || node.next==null)
        return node;

//track  left list & right list by reference
        Node  left[] = new Node[1];
        Node right[] = new Node[1];

//do partition 
        partition(node,left,right);
        
        //recursion call for left part & right part
       left[0] =  quickSort(left[0]);
       right[0] =   quickSort(right[0]);

//pivot node next  linked with right head
        node.next = right[0];

//traverse left  list
        Node temp = left[0];

//if nothing present in left list retun pivot node which is head
        if(temp==null)
        return node;

//traverse through left list
        while(temp.next!=null)
        temp=temp.next;

//add left list last node to  pivot node
        temp.next = node;
//retunr left head
        return left[0];
    }
