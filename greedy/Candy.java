/*


*/

import java.util.*;
class Candy
{
    public static int candy(int[] ratings) {
        int n  = ratings.length;
        
        //traverse right to  left store max candid needed for each  index    
        int[] rtol = new  int[n];
        Arrays.fill(rtol,1);    //minimum 1 candy required

        //compare with right neighbor 
        for(int j=n-2;j>=0;j--)
        {
            //if current one has higher rating then its neighbor
            if(ratings[j] > ratings[j+1])
            rtol[j] = rtol[j+1]+1;  //plus one candy more than their neighbor
        }

        //traverse left to right compare left neighbor
        int total=rtol[0],prev=rtol[0]; //at  index 0 max candy reuiqred is  same beacuse there is no  left neighbor
        //compare  with left neighbour
        for(int i=1;i<ratings.length;i++)
        {
            if(ratings[i]>ratings[i-1])
            prev=Math.max(prev+1,rtol[i]);  //if current one has higher rating then its left neighbor add max candy  required  by  compare prev candy+1 or rightotleft 
            else
            prev=rtol[i];   //otherwise same as stored candy

            total+=prev;    //add into  total
        }
        return total;   //return total candy
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of children");
        int n = sc.nextInt();

        int[] ratings = new int[n];
        System.out.println("Enter ratings of each children");
        for(int i=0;i<n;i++)
        ratings[i] = sc.nextInt();

       int ans = candy(ratings);
       System.out.println("Minimum candy required is " + ans);

    }

}