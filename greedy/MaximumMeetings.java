/*
N meetings in one room
There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) 
where start[i] is start time of meeting i and end[i] is finish time of meeting i.

find out no of maximum meeting can held in  a day in single room  
Input:
N = 6
start[] = {1,3,0,5,8,5}
end[] =  {2,4,6,7,9,9}
Output: 
4
Explanation:
Maximum four meetings can be held with
given start and end timings.
The meetings are - (1, 2),(3, 4), (5,7) and (8,9)
*/

import java.util.*;

//declare  a pair class which consist start position , end posiiton,meeting number
class Pair
{
    int start;
    int end;
    int pos;
    
    Pair(int start,int end,int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

//declared meeting compare class which implements Comparator interface 
class MeetingCompare implements Comparator<Pair>
{
    //override compare method 
    public int compare(Pair m1 , Pair m2)
    {
        //if first pair element meeting end time small then second pair element no need to swap return -1
        if(m1.end < m2.end)
        return -1;
        //if first pair element meeting end time greater than second pair meeting need to swap return 1 
        else if(m1.end > m2.end)
        return 1;
        //if both meeting pair has end time equal pick that meeting which comes first sort by position
        //if first pair comes first no need to swap otherwise swap it 
        else if(m1.pos < m2.pos)
        return -1;
        else
        return 1;
    }
}

class MaximumMeetings
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // create a arraylist which consist pair element
        ArrayList<Pair> arr = new ArrayList<>();
        
        //traverse through 0 to n-1 and add pair element in to array
        
        for(int i=0;i<n;i++)
        arr.add(new Pair(start[i],end[i],i+1));
        
        //according end time sort pair to get maximum no of meeting held in a day
        //use comparator to condition based sorting
        
        MeetingCompare comp = new MeetingCompare();
        Collections.sort(arr,comp);
        
        //declare count to indicate max no of meeting can hold
        //first meeting can held 
        int count=1;
        //store it end time
        int limit = arr.get(0).end;
        
        for(int i=1;i<arr.size();i++)
        {
            //if current meeting start time greater end time of last executed meeting
            ///this meeting can also held
            if(arr.get(i).start >  limit)
            {
                //update count
                count++;
                //update limit pointer by current meeting end time
                limit = arr.get(i).end;
            }
            //if current meeting start time less than or equal to end time of last executed meeting
        
            //nothing have to do this meeting cannot be held
        }
        
        
        //return count 
        return count;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total no of meeting");
        int n = sc.nextInt();

        int[] start = new int[n];
         int[] end= new int[n];

        System.out.println("Enter starting time of each meeting");
        for(int i=0;i<n;i++)
        start[i] = sc.nextInt();
        System.out.println("Enter ending time of each meeting");
        for(int i=0;i<n;i++)
        end[i] = sc.nextInt();

       int max = maxMeetings(start,end,n);
       System.out.println("Maximum no of meetings held in a day  is " + max);
    }

}