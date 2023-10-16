/*
 * Sieve of Eratosthenes
 * Given a number N, calculate the prime numbers up to N using Sieve of Eratosthenes.  
 */

import java.util.*;
class FindPrime{
    public static int countPrimes(int n) {

        ///create a n size sieve of eratosthenes to store
        //which is prime and which is not
        int sieve[] = new int[n];

        int countp = 0;
        //traverse from 2 to upto n
        //0,1 not considered as prime no start from 2
        for(int i=2;i<n;i++)
        {
            //check value of sieve if it still 0 means if it not updated before and it is prime no
            if(sieve[i]==0)
            {
                //increment count
                countp++;

                //all numbers which is multiplication of current numbers must be not prime 
                for(int j=i+i;j<n;j+=i)
                //make it as -1
                sieve[j] = -1;

            }

        }
        
        //return count of prime numbers upto n
        return countp;
    }

    public static void main(String args[])
    {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter a number to get how many prime no till n");
        int n  = sc.nextInt();

        int total = countPrimes(n);
        System.out.println("Total prime numbers till n is " + total);

    }
}