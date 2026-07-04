/*
 * Sieve of Eratosthenes
 * Given a number N, calculate the prime numbers up to N using Sieve of Eratosthenes. 
 * time  complexity =0(n) + 0(nlog(logn)) 
 */

import java.util.*;
class FindPrime{
    public static int countPrimes(int n) {

        //create a  boolean  prime of  n  
        boolean prime[] = new boolean[n];
        //mark  it true at  starting considered all numbers are prime
        Arrays.fill(prime,true);

        
        int count=0;
        //travere from 2 to  sqrt of n for a prime after that if  any  number which is  not prime already marked  it  false
        for(int i=2;i*i<n;i++)
        {
            //it it is prime 
            if(prime[i]==true)
            {
                //go from i*i to  n multiply of i  not start from  2 it already marked false start from i
               for(int j=i*i;j<n;j+=i)
                prime[j]=false; //mark  it false not prime
            }
        }

        //traverse from 2 to n count no  of prime
        for(int i=2;i<n;i++)
        {
            if(prime[i]==true)
            count++;
        }
        //return count
        return count;
    }

    public static void main(String args[])
    {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter a number to get how many prime no till n");
        int n  = sc.nextInt();
        sc.close();
        int total = countPrimes(n);
        System.out.println("Total prime numbers till n is " + total);

    }
}