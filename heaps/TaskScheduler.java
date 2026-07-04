
// Task Scheduler

import java.util.*;


class TaskScheduler
{
    public static int taskScheduler(String s, int n, int k) {

        // Write your code here.
        //try out to complete first highest frequency task for this need max priority queue
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->Integer.compare(b, a));

        int freq[] = new int[26];
        //store freq first for each character
        for(int i=0;i<n;i++) 
        freq[s.charAt(i)-'A']++;

        //store all  frequency in a queue
        for(int i=0;i<26;i++)
        {
              if(freq[i] > 0)   //if any charcter present then add into queue
              pq.offer(freq[i]);
        }
      

        int time=0;
        //traverse until queue is not empty
        while(!pq.isEmpty())
        {
              //create a one temp  array to store all updated frequency in interval of n+1 time
                ArrayList<Integer> temp = new ArrayList<>();
              
            //at  each time you have to poll out k+1 elements because same element frequency can get after n delay
            for(int i=1;i<=k+1;i++)
            {
                //poll out from queue different character frequency
                if(!pq.isEmpty())
                {
                    int getfreq = pq.poll();    //get frequency of any character
                    getfreq--;  //decrease this freq by one one task  completed
                    //add  into  a temp
                    temp.add(getfreq); //store into  temp updated freq
                }
            }

            //all  updated freq after completed k+1 time again add into queue
            for(int i=0;i<temp.size();i++)
            {
                if(temp.get(i)>0) //if charcter freq exchausted no  need to again into queue
                pq.offer(temp.get(i));
            }

            //if queue is  empty no  character left
            if(pq.isEmpty())
            time+=temp.size(); //add into time whatever temp  size is  
            else
            time+=(k+1); //otherwise k+1 time you must have to give it....

         //   System.out.println(time);
        }

        return time;
    }
   
    public static  void main(String args[])
    {
        Scanner sc = new  Scanner(System.in);

        System.out.println("Enter a string of uppercase  character");
        String s = sc.next();
        
        System.out.println("Enter a delay time of same character");
        int k = sc.nextInt();
        
        int getMinTime = taskScheduler(s,s.length(),k);
        System.out.println("Minimum time to complete  all task is  " + getMinTime);
    }
}