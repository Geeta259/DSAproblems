/* 
 Painter's Partition Problem
 Given an array/list of length ‘n’, where the array/list represents the boards and each element of the given array/list represents the length of each board. Some ‘k’ numbers of painters are available to paint these boards. Consider that each unit of a board takes 1 unit of time to paint.
You are supposed to return the area of the minimum time to get this job done of painting all the ‘n’ boards under a constraint that any painter will only paint the continuous sections of boards.

Example :
Input: arr = [2, 1, 5, 6, 2, 3], k = 2

Output: 11
*/

import java.util.*;
public class PainterPartition 
{
    public static boolean getPaints(ArrayList<Integer> boards,int time,int k)
    {
        int count=1,total=0;
        for(int i=0;i<boards.size();i++)
        {
            //not possible  go to  right for this return max value of paint
            if(boards.get(i) > time)return false;
            if(total+boards.get(i) > time)
            {
                count++;
                total = boards.get(i);
            }
            else
            total+=boards.get(i);
        }

        //if no of  paints less than or equal to  k return true otherwise false
         if(count <= k)return true;
        return false;
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
       //get  range of unit of time 
       //minimum  time you take minimum value of  boards
       //maximum  time you take sum of  boards
       int min=boards.get(0);
       int max=0;
       for(int i=0;i<boards.size();i++)
       {
           if(boards.get(i)<min)min=boards.get(i);
           max+=boards.get(i);
       }
        
        int ans=-1;
       //use binary search  to  fixed  highest unit of time
       while(min<=max)
       {
           int mid = (min+max)>>1;
           if(getPaints(boards,mid,k))
           {
               //store that  max unit of  time as ans and go to left
              ans = mid;
               //go to left to minimize  max  unit of time ans also if  no of paint is less than k 
               //still you have to minimize time
               max = mid-1;
           }
           else
           {
               //otherwise increase unit of time
               min=mid+1;
           }
       }

       return ans;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of a board");
        int n =sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter a length of each  board");
        for(int i=0;i<n;i++)
        arr.add(sc.nextInt());

        System.out.println("Enter no of  max  paint  can used");
        int k =sc.nextInt();
     
        sc.close();

        int res = findLargestMinDistance(arr,k);
        System.out.println("Minimum unit of time is used to paint all board by using at most k  no  of  paint is  " +  res);
        
    }
}

