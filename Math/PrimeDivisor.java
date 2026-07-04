/*
 * print prime divisor of N
 * You must return the unique prime factors of 'N' in increasing order.
 */

import java.util.*;

public class PrimeDivisor{

    static boolean prime[];
     public static void FillPrimes(int n) {
         prime = new boolean[n];
        Arrays.fill(prime,true);

        for(int i=2;i*i<n;i++)
        {
            if(prime[i]==true)
            {
               for(int j=i*i;j<n;j+=i)
                prime[j]=false;
            }
        }
    }


    public static List< Integer > getPrimes(int n) {
        // Write your code here.
        FillPrimes(n);
        List<Integer> ans = new ArrayList<>();

        for(int i=2;i*i<=n;i++)
        {
            if(n%i==0)
            {
                if(prime[i]==true)   //for 15 (3*5) check  for both 3 and 5 one by one 
                 ans.add(i);

                
                if(prime[n/i]==true && (n/i)!=i)
                ans.add(n/i);
            }   

        }
        return ans;
    }

    public static void main(String args[])
    {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter a number for find prime divisor");
        int n  = sc.nextInt();
        sc.close();
        List<Integer> ans = getPrimes(n);
        System.out.println("prime divisor of " + n + " is " + ans);

    }
}