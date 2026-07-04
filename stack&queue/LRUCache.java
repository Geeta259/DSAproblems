/*
 * LRU cache program
 */
import java.util.*;
//doubly linked list used to insert and remove node in constant time
class Node
{
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key,int val)
    {
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}

class ImplementLRU {

    //use hashmap to store key with node address
    HashMap<Integer,Node> map;
    int cap;
    Node head;
    Node tail;

    public ImplementLRU(int capacity) {
        
        //intialize instance variables
        map = new HashMap<>();
        cap = capacity;
        //dummy head and tail node created
        head = new Node(0,0);
        tail = new Node(0,0);
        //liinked both node with each other
        head.next = tail;
        tail.prev = head;
    }
    
    public void insert(Node node)
    {
        //just after head insert in 0(1) constant time
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;

         //insert newnode also in map with key
          map.put(node.key,node);
    }

    public void remove(Node node)
    {
        //remove least recent node which insert at last just before tail node
        node.prev.next = node.next;
        node.next.prev = node.prev;

        //remove from map using key
        map.remove(node.key);
    }
    public int get(int key) {
        //check is present in map or not
        if(map.containsKey(key))
        {
            //get that node from map
            Node node = map.get(key);
            //remove that node and insert into beginning just after head because it is recently used node
            remove(node);
            insert(node);

            return node.val;
        }
        else
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            //get that node from map
            Node newnode  = map.get(key);

            //remove that node from ddl  
            remove(newnode);
        }

        //if map capacity is full last node just after tail  node remove
        if(map.size()==cap)
        remove(tail.prev);
        
        //create  a new node
        Node newnode = new Node(key,value);
        //recently used node insert into dll at beginning just after head
        insert(newnode);
    }
}
 
class LRUCache
{
    public static void main(String args[])
    {
      
        Scanner sc = new Scanner(System.in);
          System.out.println("Enter capacity of cache");
        int capacity = sc.nextInt();


        ImplementLRU obj = new ImplementLRU(capacity);

       do
        {
            System.out.println("Choose opeartion of LRU Cache\n1 for put\n2 for get\npress any key to break except 1 & 2");
            int op = sc.nextInt();
            if(op==1)
            {
                System.out.println("Enter key and value to put into LRU cache");
                int key  = sc.nextInt();
                int val = sc.nextInt();
                obj.put(key,val);
            }
            else if(op==2)
            {
                System.out.println("Enter key to get value from LRU cache");
                int key  = sc.nextInt();
                int getval = obj.get(key);
                if(getval!=-1)
                System.out.println("Value of given key is "+getval);
                else
                System.out.println("Not found in LRU Cache");
            }
            else
            {
                sc.close();
                break;
            }

       }while(true);
    }
}