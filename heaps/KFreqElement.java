/*

Connect N Ropes With Minimum Cost
 */
import java.util.*;

class KFreqElement
{
    public static int[] KMostFrequent(int n, int k, int[] arr) {
        // Write your code here.
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++)
        map.put(arr[i],map.getOrDefault(arr[i],0)+1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));

        for(Map.Entry<Integer,Integer> em : map.entrySet())
        {
             pq.offer(new int[]{em.getValue(),em.getKey()});

             if(pq.size()>k)
             { pq.poll();}
        }

        int[] ans = new int[k];
        int idx=0;

        while(!pq.isEmpty())
        { ans[idx++] = pq.poll()[1];}

        return ans;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of  array");
        int n = sc.nextInt();

    
        int arr[] = new int[n];
        System.out.println("Enter elements  in an array");
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        System.out.println("Enter no  of frequent element you  want");
        int k = sc.nextInt();

        int[] ans  = KMostFrequent(n,k,arr);
        for(int i=0;i<ans.length;i++)
        System.out.print(ans[i] + " ");
    }
}