/*
Job Sequencing Problem
Given a set of N jobs where each jobi has a deadline and profit associated with it.
*/

import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class MaximumJobSchedule
{
      //Function to find the maximum profit and the number of jobs done.
      static int[] JobScheduling(Job arr[], int n)
      {
          //declare ans array to contain max  no of jobs and total profit
          int ans[] = new int[2];
          
          //get maximum deadline of a jobs
          int max = Integer.MIN_VALUE;
          for(int i=0;i<n;i++)
          max = Math.max(arr[i].deadline,max);
          
          //declare new array up to index max deadline
          //this array store which day which job is implemented
          int jobs[] = new int[max];
          
        //  sort array according to their profit higher profit check first
        //descending order sort 
          Arrays.sort(arr,(a,b)->(b.profit - a.profit));
          
          //declare two pointer variable to get maxprofit and countjob
          int maxprofit = 0,countjob=0;
          
          //traverse upto all jobs
          for(int i=0;i<n;i++)
          {
              //get deadline of current job 
              //minus 1 becuase jobs array index start from 0
             int day = arr[i].deadline-1;
             //start from that day and goes upto 0 index
             //try to execute jobs near  from deadline day so that maximum job can execute to gain max profit            for(int j=day;j>=0;j--)
              for(int j=day;j>=0;j--)
              {
                  //if at any day no jobs execute till now
                      if(jobs[j]==0)
                      {
                          //execute this job on that day with high profit
                          jobs[j]  = arr[i].id;
                          //add their profit and increment countjob by 1 break from loop
                          maxprofit+=arr[i].profit;
                          countjob++;
                          break;
                      }
              }
          }
          //store countjob and maxprofit in to resultant array and return ans
          ans[0] = countjob;
          ans[1] = maxprofit;
          
          return ans;
      }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total no of jobs");
        int n = sc.nextInt();

        Job arr[] = new Job[n];
        System.out.println("Enter jobs data in a pair (id,profit,deadline)");

        for(int i=0;i<n;i++)
        { Job obj = new Job(sc.nextInt(),sc.nextInt(),sc.nextInt());
          arr[i] = obj;
        }

        int ans[] = new int[2];
       ans  = JobScheduling(arr,n);
       System.out.println("Maximum no of jobs can executed is " + ans[0] + " \nMaximum profit can gained is " + ans[1]);
    }

}