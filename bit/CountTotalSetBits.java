import java.util.*;

class CountTotalSetBits
{
    public static int binSearch(int n)
    {
        //nearest value which is considered as power of 2
        int max = 0;
        int start = 1 ;
        int end = n;
        
        while(start<=end)
        {
            //find median
            int mid = (start+end)>>1;
            if(Math.pow(2,mid)>n)
            {
                //mimimize the value move to left part
                end = mid-1;
            }
            else
            {
                //if it  less than or equal to n store value and move right part
                max = mid;
                start = mid+1;
                
            }
        }
        
        return max;
    }
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
    
        // Your code here
        //use bit  operation
        
        int count = 0;
        
        //first find nearest number which can be represent power of 2 by use binary search
        int x = binSearch(n);
        
        //till 2^x -1 count no of 1
        
        count+= (int)Math.pow(2,x-1) * x ;
        
        //from 2^x to n  count no of 1's
        
        //count 1's of last bit which is equal to n-2^x+1
        
        count+= n - (int)Math.pow(2,x)+1;
        
        
        //count 1's for remaining number
        n = n - (int)Math.pow(2,x);
        
        if(n!=0)
        count+= countSetBits(n);
        
        return count;
        
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();

        int count = countSetBits(n);
        System.out.println("Total no  of  set bits from 1 to "+n+" is " + count);
        sc.close();

    }
}