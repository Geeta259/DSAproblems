/*
 * Sieve of Eratosthenes
 *Given a number N. Find its all prime factors in increasing order. 
 */

import java.util.*;
class PrimeFactorOfN{

     //static variable of size intialize will goes up to sqrt(n)
    //static boolean type prime array created with max size
    static int size=0;
    static boolean notprime[] = new boolean[200001];
    
    static void sieve() {
        
        //set which no is prime and which not
        //traverse up to k because prime no of any given number can be at max sqrt of that number
        for(int i=2;i<size;i++)
        {
            //if it is still false means not divisible by any previous number means it is prime number
            if(!notprime[i])
            {
                //make all elements not prime which is multiplication of that number upto size
                for(int j=2*i;j<size;j+=i)
                notprime[j]=true;
            }
        }
    }

    public static ArrayList<Integer> primefactors(int N) {
        // code here
        //initialize global variable size up to sqrt  of N
         size = (int)(Math.sqrt(N)) + 1;
         
         //call sieve function to initalize notprime array
         sieve();
         
         //create list which store resultant primes
         ArrayList<Integer> list = new ArrayList<>();
         
         //traverse from 2 to size
         for(int i=2;i<size;i++)
         {
             //check it is prime or not
             if(!notprime[i])
             {
                 //if given no divisible by i  divide until not divisible by  i
                 while(N%i==0)
                 {
                    list.add(i);
                    //update N 
                    N/=i;
                 }
             }
             
         }
         
         //if N not completely divisible then add last updated N into list which is prime 
         if(N>1)
         list.add(N);
         
         return list;
    }

    public static void main(String args[])
    {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter a number whom you want to get prime factors");
        int num  = sc.nextInt();

        sc.close();

       ArrayList<Integer> res = primefactors(num);
        System.out.println("Prime factors of given number is " + res);

    }
}