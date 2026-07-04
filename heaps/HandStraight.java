/*
 Hand of Straights
 */
import java.util.*;

class HandStraight
{
    public static  boolean isNStraightHand(int[] hand, int groupSize) {
        //create  a min  priorityqueue to get elements in a sorted order one  by  one
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = hand.length;
        //push all elements in a queue
        for(int i=0;i<n;i++)
        pq.offer(hand[i]);

        //traverse until queue is not empty or  queue size less than groupsize
        while(!pq.isEmpty() && pq.size()>=groupSize)
        {
            int count=0,prev=-1;
            //list  to store  duplicate element  so  that  can again  add into  queue for  next  group
            ArrayList<Integer> dup = new ArrayList<>();

            while(!pq.isEmpty() && count<groupSize)
            {
                //get  current element
               int  curr= pq.poll();
              // System.out.println(curr);
              //if prev element exist compare with  current  element 
               if(prev!=-1)
               {
                //if  cuurent and prev  are  same  add into  duplicate and continue  for next consecutive
                    if(curr==prev)
                    { dup.add(curr); continue; }
                    else  if(curr!=prev+1)  //otherwise check is it consecutive if not  can not  make  group  
                    return false;//return false
               }
               //otherwise increment count by  one to  track  groupsize
                count++;
                //store  current  element  to  prev
               prev = curr;
            }

            //check  able to make group  of  given  size if not  return false
            if(count!=groupSize)return false;
            //duplicate  value  add into  pq for next group
            for(int j=0;j<dup.size();j++)
            pq.offer(dup.get(j));
        }

        //if all element covered return true otherwise false
        if(pq.isEmpty())return true;
        return false;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of  card");
        int n = sc.nextInt();

    
        int arr[] = new int[n];
        System.out.println("Enter value  of  each card");
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        System.out.println("Enter group size");
        int k = sc.nextInt();

        boolean ans = isNStraightHand(arr,k);

        System.out.print("Able to  Rearrange all cards  of  given group  size ? " + ans);
    }
}