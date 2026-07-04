
// Replace Each Element Of Array With Its Corresponding Rank

import java.util.*;

class Pair4
{
    int  val,idx;
    Pair4(int val,int idx)
    {
        this.val=val;
        this.idx=idx;
    }
}
class ReplaceElementRank
{
	public static List<Integer> replaceWithRank(List<Integer> arr, int n) {
        // Write your code here
   
        PriorityQueue<Pair4> pq = new  PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(int i=0;i<n;i++)
        pq.offer(new Pair4(arr.get(i),i));

        int rank=1;
        while(!pq.isEmpty())
        {
            Pair4 pa = pq.poll();
            arr.set(pa.idx,rank);

            if(!pq.isEmpty() && pa.val!=pq.peek().val)
            rank++;
        }

        return arr;
        
    }
   
    public static  void main(String args[])
    {
        Scanner sc = new  Scanner(System.in);

        System.out.println("Enter size of kth array");
        int k = sc.nextInt();
        int arr[] = new int[k];
    	
		for(int j=0;j<k;j++)
        arr[j] = sc.nextInt();

        
           List<Integer> val = new ArrayList<>();
            for(int j=0;j<k;j++)
            val.add(arr[j]);

        
        val = replaceWithRank(val,k);
        System.out.println("Rank  of an element  is  " + val);
    }
}