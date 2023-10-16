/*
 * Sieve of Eratosthenes
 *Given a number N. Find its unique prime factors in increasing order. 
 */

import java.util.*;
class PrimeFactor{
    public static ArrayList<Integer> primeFactors(int N)
    {
        // code here
        
        int[] spf = new int[N+1];
        for(int i=0;i<=N;i++)
        spf[i] = i;
        
       //store in smallprime factor of numbers
       //smallest prime fcators less than sqrt of n
       
       for(int i=2;i*i<=N;i++)
       {
           //check it is not updated  by smallest prime factor till yet it is prime no
           if(spf[i]==i)
           {
               //go to that prime no multiplication and update all
                for(int j=i*i;j<=N;j+=i)
               {
                   //if it is updated before any other prime factor then update by i prime factor
                   if(spf[j]==j)
                   spf[j] = i;
               }       
           }
       }
       
       ArrayList<Integer> res = new ArrayList<>();
       int prev=0;
       
       //find all prime factor of n
       while(N>1)
       {
          //check prime factor of n
          int getprime = spf[N];
          N = N/getprime;
          
          //store  into array if it greater than prev prime
             if(getprime>prev)
             {
               res.add(getprime);
               prev = getprime;
             }
          
       }

       //return arraylist which contains prime factor of given number
    
        return res;
    }

    public static void main(String args[])
    {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter a number whom you want to get prime factors");
        int num  = sc.nextInt();

       ArrayList<Integer> res = primeFactors(num);
        System.out.println("Prime factors of given number is " + res);

    }
}