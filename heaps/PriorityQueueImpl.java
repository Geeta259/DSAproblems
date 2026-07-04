//implementation of  max priority queue using array  implementation of binary heap
import java.util.*;

class  PriorityQueueImpl
{
    public static  ArrayList<Integer> data;
    
    public static int size()
    { return data.size();}

    private static void swap(int i,int j)
    {
        int  temp = data.get(i);
        data.set(i,data.get(j));
        data.set(j,temp);
    }
    private static void  upHeapify(int idx)
    {
        //call from  last index
        //compare with its parent
        if(idx==0)return; //base  case

        int  parent = (idx-1)/2; //get parent of  current index
        if(data.get(parent) < data.get(idx))
        {
            //upheapify  call if parent  value is less than its  child
            swap(parent,idx); //swap parent value  with its child
            idx  = parent; //now  update idx  with  parent
            upHeapify(idx); //recursive call  
        }
    }
    public static void add(int val)
    {
        data.add(val);
        //upheapify call from  last  index
        upHeapify(data.size()-1);
    }
    public static  void  downHeapify(int i)
    {
        
        int left = 2*i+1;
        int right = 2*i+2;

        int max = i;
        if(left<data.size() && data.get(left)>data.get(max))max=left;
        if(right<data.size() && data.get(right)>data.get(max))max=right;

        if(max!=i)  //if max  is not  a  parent  then  swap
        {
            swap(max,i);
            downHeapify(max); //call  downward heapify
        }
    }
    public static  int remove()
    {
        if(size()==0){
            System.out.println("Underflow");
            return  -1;
        }

        //swap first  element  with last  element 
        //first element is  maximum  element
        swap(0,data.size()-1);
        int  val = data.size()-1;

        data.remove(data.size()-1); //remove  last  element
        //call downheapify to check  heapify maintain or not
        downHeapify(0);
        return val; //return  maximum element
    }
    public static  int  getMaximum()
    {
        if(size()==0)
        {
            System.out.println("Underflow..");
            return  -1;
        }
        return data.get(0);//top  element  is  maximum one
    }
    public static  void main(String args[])
    {
        Scanner sc = new  Scanner(System.in);
        data = new ArrayList<>();
        int  ch =0;
        do{
            System.out.println("press 1 for Add");
            System.out.println("press 2 for Remove");
            System.out.println("press 3 for Size");
            System.out.println("press 4 for Get Maximum");
            System.out.println("press -1 for Exit..");

            ch = sc.nextInt();

            switch(ch)
            {
                case 1:
                {
                    System.out.println("Enter a value");
                    int  val = sc.nextInt();
                    add(val);
                    break;
                }
                case  2:
                remove();
                break;

                case 3:
                System.out.println("Size of  current queue is " + size());
                break;

                case 4:
                System.out.println("Size of  max element  is " + getMaximum());
                break;

                default:
                System.out.println("Exit...");
            }
        }while(ch!=-1);
    }
}