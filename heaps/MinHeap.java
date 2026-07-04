//implementation of  max priority queue using array  implementation of binary heap
import java.util.*;

class  MinHeap
{
    static int[] harr;
    static int capacity;
    static int heap_size;
    MinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }
   static int parent(int i) { return (i - 1) / 2; }
    static int left(int i) { return (2 * i + 1); }
    static int right(int i) { return (2 * i + 2); }

    //Function to extract minimum value in heap and then to store 
    //next minimum value at first index.
    static int extractMin()
    {
        // Your code here.
        if(heap_size==0)return -1; 
        int val=harr[0];
        if(heap_size==1)
        {
            heap_size=0;
            return val;
        }
        
        //swap with last element
        harr[0]=harr[heap_size-1];
        heap_size--;
        MinHeapify(0);
        return val;
    }

    //Function to insert a value in Heap.
   static void insertKey(int k) 
    {
        // Your code here.
        if(heap_size==capacity)return;
        harr[heap_size]=k;
       
       int i=heap_size;
        while(i>0)
        {
          int idx =   parent(i);
          if(harr[idx] > harr[i])
          {
              int temp = harr[idx];
              harr[idx] = harr[i];
              harr[i] = temp;
              
              i = idx;
          }
          else
          break;
        }
        heap_size++;
    }

    //Function to delete a key at ith index.
    static void deleteKey(int i) 
    {
        if(heap_size==0)return;
        if(i<0 || i>=heap_size)return;
        
        decreaseKey(i,Integer.MIN_VALUE);
        extractMin();
        
    }

    //Function to change value at ith index and store that value at first index.
    static void decreaseKey(int i, int new_val) 
    {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    /* You may call below MinHeapify function in
      above codes. Please do not delete this code
      if you are not writing your own MinHeapify */
   static void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i]) smallest = l;
        if (r < heap_size && harr[r] < harr[smallest]) smallest = r;
        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            MinHeapify(smallest);
        }
    }

    public static  void main(String args[])
    {
        Scanner sc = new  Scanner(System.in);
        System.out.println("Enter a capacity of heap");
        int size = sc.nextInt();
        new MinHeap(size);
        int  ch =0;
        do{
            System.out.println("press 1 for insert");
            System.out.println("press 2 for remove");
            System.out.println("press 3 for Get Minimum");
            System.out.println("press -1 for Exit..");

            ch = sc.nextInt();

            switch(ch)
            {
                case 1:
                {
                    System.out.println("Enter a value");
                    int  val = sc.nextInt();
                    insertKey(val);
                    break;
                }
                case  2:
                {
                    System.out.println("Enter a index to  delete value");
                    int  idx = sc.nextInt();
                    deleteKey(idx);
                    break;
                }
              
                case 3:
                System.out.println("Minimum  value is " + extractMin());
                break;
            
                default:
                System.out.println("Exit...");
            }
        }while(ch!=-1);
    }
}