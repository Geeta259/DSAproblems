/*

Connect N Ropes With Minimum Cost
 */
import java.util.*;

class ConnectNRopes
{
    public static long connectRopes(int[] arr)
    {
        //Write your code here
        PriorityQueue<Integer> pq = new  PriorityQueue<>();
        for(int i=0;i<arr.length;i++)
        pq.offer(arr[i]);   //add all  ropes into min priority queue

        long cost=0;
        while(pq.size()>1)
        {
            //get first  two minimum
             int r1 = pq.poll();
             int r2= pq.poll();

             //add cost  of combine
            cost+= (long)(r1+r2);

                //add new rope in queue
            pq.offer(r1+r2);
        }

        return cost;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no  of  rope");
        int n = sc.nextInt();

    
        int arr[] = new int[n];
        System.out.println("Enter length  of  a rope");
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        
        long  cost = connectRopes(arr); 
        System.out.println("minimum  cost  to combined all ropes  is " + cost);
    }
}