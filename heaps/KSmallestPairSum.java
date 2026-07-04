/*

Find K Pairs with Smallest Sums
You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.


 */
import java.util.*;
class Pair2{
    int first,second;
    Pair2(int first,int second)
    {
        this.first = first;
        this.second = second;
    }
}
class SumCompare implements Comparator<Pair2>
{
    public int compare(Pair2 p1,Pair2 p2)
    {
        if(p1.first+p1.second > p2.first+p2.second)
        return -1;
        else if(p1.first+p1.second < p2.first+p2.second)
        return 1;
        else
        return 0;
    }
}
class KSmallestPairSum
{
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        //create a min-heap priority queue to  store k smallest pair sum
        PriorityQueue<Pair2> pq = new PriorityQueue<>(new SumCompare());

        //k pair add into queue
        int count=0;
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
                //get pair 
                count++;
                int sum = nums1[i] + nums2[j];
                //if count less than or equal to k simplay add into min priority queue
                if(count<=k)
                {
                      Pair2 pa = new Pair2(nums1[i],nums2[j]);
                       pq.add(pa);
                }
                //otherwise check current pair sum if it less than min sum of queue remove that one add current
                else if(sum < (pq.peek().first + pq.peek().second))
                {
                        pq.poll();
                         Pair2 pa = new Pair2(nums1[i],nums2[j]);
                        pq.add(pa);
                }
                //otherwise if current pair sum greater than min sum of queue break from it ..further all  pair sum greater
                else
                break;             
            }    
        }

        List<List<Integer>> ans = new ArrayList<>();
        while(!pq.isEmpty())
        {
            Pair2 pa = pq.poll();
            ans.add(Arrays.asList(pa.first,pa.second));
        }
        return ans;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of elements");
        int n = sc.nextInt();

        int first[] = new int[n];
        System.out.println("Enter value in first array of " + n + " elements in a sorted manner");
        for(int i=0;i<n;i++)
       first[i] = sc.nextInt();

        int second[] = new int[n];
        System.out.println("Enter value in second array of " + n + " elements in a sorted manner");
        for(int i=0;i<n;i++)
        second[i] = sc.nextInt();

        
        System.out.println("Enter value of k Pair you want");
        int k = sc.nextInt();

       List<List<Integer>> ans = kSmallestPairs(first,second,k);
        System.out.println(k + " pairs with minimum sum is " + ans);
    }
}