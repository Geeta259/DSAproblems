/*
 *nCr
   Given two integers n and r, find nCr. Since the answer may be very large, calculate the answer modulo 109+7.

   Efficient and quick way to find ncr use pascal triangle property to solve & update value for each itertaion
 */

import java.util.*;
class FindnCr{
    public static int nCr(int n, int r)
    {
        // code here
        if(r>n)return 0;
        if(r==0 || r==n)return 1;
        
        int mod=1000000007;
        ///create a one dp array of size r+1 becuase it starts from o to r
        int pascal[] = new int[r+1];
        
        //update pascal value for each iteration  from 0  to n
        
        //start from 1 becuase for 0  it's 1
        pascal[0] = 1;
        
        //update pascal values for each iteration
        for(int i=1;i<=n;i++)
        {
            //updates value from end
            //r<=i  for each itertaion if r is small then update value till r otherwise till i
            for(int j=Math.min(i,r);j>0;j--)
            {
                //to update current value need prev value of current index + value of prev index
                pascal[j] = (pascal[j] + pascal[j-1])%mod;
            }
            
        }
        
        
        //ncr value contains in r index
        return pascal[r];
    }
  
    public static void main(String args[])
    {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter a value of n to find combination");
        int n  = sc.nextInt();

        System.out.println("Enter a value of r to find combination");
        int r  = sc.nextInt();

        sc.close();

        int ans = nCr(n,r);
        System.out.println("Combination of given ncr is " + ans);

    }
}