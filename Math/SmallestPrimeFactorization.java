/*
 * Prime Factorization using Sieve
Input: 
N = 12246
Output: 
2 3 13 157
Explanation: 
2*3*13*157 = 12246 = N.

N=12
2 2 3
 */

import java.util.*;
class SmallestPrimeFactorization{
      // You must implement this function
      ///create a spf of highest value of n
      static int spf[] = new int[200001];
      static void sieve() {
          int n = spf.length;

          //initialize each number with itself 
          
          for(int i=2;i<n;i++)
          spf[i]=i;
          
          for(int i=2;i*i<n;i++)
          {
            //if it contain same value  means it  is prime
              if(spf[i]==i)   //it is prime number
              {
                  //it is smallest prime factor
                   //go to  its multiple 
                  for(int j=i*i;j<n;j+=i)
                  {
                    //if it contain same value as initial  updated by spf 
                      if(spf[j]==j) //otherwise already updated by previous spf
                      spf[j]=i;   
                  }
              }
          }
      }
  
      static List<Integer> findPrimeFactors(int N) {
          // code here
          
          List<Integer> ans = new ArrayList<>();
          
          //traverse until no greater than 1
          while(N>1)
          {
            //get spf  of n add into  list
             int i = spf[N];
             ans.add(i);
             ///divide N by spf
             N = N/i;
          }
          //return ans
          return ans;
      }

    public static void main(String args[])
    {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter a number for compute prime factorization");
        int n  = sc.nextInt();
        sc.close();
        sieve();
       List<Integer> ans = findPrimeFactors(n);
        System.out.println("prime factorization of  "+ n +" is " + ans);

    }
}