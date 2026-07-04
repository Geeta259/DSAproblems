
//Merge K Sorted Arrays
import java.util.*;

class  Pair3
{
	int val,idx,pos;
	Pair3(int  val,int idx,int pos)
	{
		this.val=val;
		this.idx=idx;
		this.pos=pos;
	}
}
class KSortedArray
{

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		//create  an ans  arraylist
		ArrayList<Integer> ans = new  ArrayList<>();

		//given k array  is sorted itself
		//use heap  to store k elements and give minimum  among  it
		PriorityQueue<Pair3> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val, b.val));

		//first store all k array 0th  position element
		for(int i=0;i<k;i++)
		pq.offer(new  Pair3(kArrays.get(i).get(0),i,0));  //index of k array //position of  element in ith array 

		//traverse until pq  is not empty
		while(!pq.isEmpty())
		{
			//pop out first  minimum  value
			Pair3  pa =pq.poll();
			ans.add(pa.val); //add minimum value into ans
			//get index  of  k  array
			int  idx = pa.idx; //go  to  that index and check next  position element
			int pos = pa.pos+1; //pick next element to  poll out  element

			if(pos < kArrays.get(idx).size()) //elements  exist
			pq.offer(new  Pair3(kArrays.get(idx).get(pos),idx,pos));
		}

		return ans; //return ans array  which  contained elements in a  sorted order
	}

    public static  void main(String args[])
    {
        Scanner sc = new  Scanner(System.in);

        System.out.println("Enter size of kth array");
        int k = sc.nextInt();

        int input[][] = new  int[k][k];
        for(int i=0;i<k;i++)
        {
            System.out.println("Enter " + k + " elements  in  a " + i +" index");
            int arr[] = new int[k];
            for(int j=0;j<k;j++)
            arr[j] = sc.nextInt();

            input[i] = arr;
        }
        
        ArrayList<ArrayList<Integer>>  arr = new  ArrayList<>();
        for(int i=0;i<k;i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0;j<k;j++)
            temp.add(input[i][j]);

            arr.add(temp);
        }

        ArrayList<Integer> ans = mergeKSortedArrays(arr,k);
        System.out.println("sorted list  of  an arrray  is  " + ans);
    }
}