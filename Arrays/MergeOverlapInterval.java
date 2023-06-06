/*
 * Overlapping Intervals
 * Given a collection of Intervals, the task is to merge all of the overlapping Intervals.
 * 
 * Input:
Intervals = {{1,3},{2,4},{6,8},{9,10}}
Output: {{1, 4}, {6, 8}, {9, 10}}
Explanation: Given intervals: [1,3],[2,4]
[6,8],[9,10], we have only two overlapping
intervals here,[1,3] and [2,4]. Therefore
we will merge these two and return [1,4],
[6,8], [9,10].
 */

import java.util.*;

class MergeOverlapInterval
{

    public static List<List<Integer>> overlappedInterval(int[][] Intervals)
    {
        //sort array by first column 0 index
         Arrays.sort(Intervals,(a,b)->(a[0]-b[0]));
        
        List<List<Integer>> arr = new ArrayList<List<Integer>>();

        //declare two variable at first min and max value is interval first pair
        
        int min=Intervals[0][0],max=Intervals[0][1];
        
        for(int i=1;i<Intervals.length;i++)
        {

            //compare with second pair if first element at index pair less than or equal to max value merge pair
            if(Intervals[i][0]<=max)
            {
                //update min and max value 
                 min=Math.min(min,Intervals[i][0]);  
                 max=Math.max(max,Intervals[i][1]);  
            }else
            {
                //if it separate pair not overlapping add previous pair into list and update min and max value by current pair
                arr.add(Arrays.asList(min,max));
                min=Intervals[i][0];
                max=Intervals[i][1];
                
            }
           
        }
        
        //last pair add into list and return
         arr.add(Arrays.asList(min,max));
        
        return arr;
    }


    public static void main(String ar[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

       System.out.println("Enter "+ n +  " pair of elements");
        int arr[][] = new int[n][2];
        for(int i=0;i<n;i++)
        {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
       
        sc.close();


        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res = overlappedInterval(arr);
        System.out.println(res);
        
    }
}