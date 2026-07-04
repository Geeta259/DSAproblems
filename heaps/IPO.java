/*
 * Kth Largest Element in an Array
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

solve it without sorting.

//IPO
You are given n projects where the ith project has a pure profit profits[i] 
and a minimum capital of capital[i] is needed to start it.

Pick a list of at most k distinct projects from given projects 
to maximize your final capital, and return the final maximized capital.


 */
import java.util.*;
class Pair{
    int pft,cptl;
    Pair(int pft,int cptl)
    {
        this.pft = pft;
        this.cptl = cptl;
    }
}
class SortByCapital implements Comparator<Pair>
{
    public int compare(Pair p1,Pair p2)
    {
        //if it is in decreasing order swap it
        if(p1.cptl > p2.cptl)
        return 1;
        //if it is in ascending order no swap
        else if(p1.cptl < p2.cptl)
        return -1;
        else
        return 0;
    }
}


class IPO
{
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        //create a list  which contain pair (profit,capital)  and sort according to capital
        List<Pair> list = new ArrayList<>();

        for(int i=0;i<profits.length;i++)
        { list.add(new Pair(profits[i],capital[i]));}

        //sort according to capital
        Collections.sort(list,new SortByCapital());

        //at most k distinct project needed for this used max-heap  priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int idx=0;

        //traverse until all k distinct projects profit gets
        while(k!=0)
        {
            //traverse through list
            while(idx<list.size())
            {
                if(list.get(idx).cptl <= w)
                {
                    //can considered this project
                    pq.add(list.get(idx).pft);
                    idx++;
                }
                else
                break;
            }
            
            if(pq.isEmpty())break;

            //get maximum profit from current capacity
            w+=pq.poll();
            ///decrement k by one becuase one project included
            k--;

        }
        //return w which is total profit gets
        return w;
    }
  
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of elements");
        int n = sc.nextInt();

        int profit[] = new int[n];
        System.out.println("Enter value of profits of " + n + " elements ");
        for(int i=0;i<n;i++)
        profit[i] = sc.nextInt();

        int capital[] = new int[n];
        System.out.println("Enter value of capital of " + n + " elements ");
        for(int i=0;i<n;i++)
        capital[i] = sc.nextInt();

        
        System.out.println("Enter value of k projects you want to get");
        int k = sc.nextInt();

        System.out.println("Enter initial capital value");
        int w = sc.nextInt();

        int total= findMaximizedCapital(k,w,profit,capital);
        System.out.println("Total profit of n projects is " + total);
    }
}