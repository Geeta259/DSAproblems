/*
Find Nth root of M
  */

import java.util.*;

class FindNthRoot
{
     
    public static int NthRoot(int n, int m)
    {
        // code here
        int l=1,h=m;
        while(l<=h)
        {
            int mid = (l+h)/2;
            long mul = (long)Math.pow(mid,n);
            //System.out.println(mid + " " + mul);
            if(mul==m)
            return mid;
            else if(mul<m)
            l=mid+1;
            else
            h=mid-1;
        }
        
        return -1;
    }

    public static void main(String args[])
    {

        System.out.println("Enter any number for root");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Enter number whom you want to find root");
        int m = sc.nextInt();

        sc.close();
     
        int res = NthRoot(n,m);
        System.out.println(n+ "root of given number " + m + "is "+ res);
        
    }
}