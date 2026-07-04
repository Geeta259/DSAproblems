import java.util.*;

class SetRightMostBits
{
    static int setBit(int N){

        //get how many bit required for N 
        //use binary search from 1 to N
        //min 1 bit required and max 32 bit required to represent N
        int start =1 ;
        int end = 32;
        int maxbit = 1;
        
        while(start <= end)
        {
            //get mid 
            int mid = (start + end)>> 1;
            //if pow(2,mid) greater than n 
            if((1<<mid) > N)
            {
             //     System.out.println(mid+" "+ (1<<mid));

                //minimize power
                //store and check for min bit
                maxbit = mid;
                end = mid-1;
            }
            else
            {
                //otherwise increase no of bit
                start=mid+1;
            }
        }
        
        //System.out.println(maxbit);
        
        //check from rightmost to maxbit make first 0 bit to 1
        for(int i=0;i<maxbit;i++)
        {
            //if current bit is 0 make it 1 and break from loop
            if((N & (1<<i)) == 0)
            {
                //this will set current bit
                 N = N | (1<<i);
                 break;
            }
           
        }
        
        //return modified number after set rightmost bit
        return N;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();

        sc.close();

        int num = setBit(n);
        System.out.println("After set rightmost bit in given number is " + num);
       

    }
}