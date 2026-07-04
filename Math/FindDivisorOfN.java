/*
  Given an integer ‘N’, your task is to write a program that returns all the divisors of ‘N’ in ascending order.

time complexity o(sqrt(n))
 */

import java.util.*;
class FindDivisorOfN{
    public static List< Integer > printDivisors(int n) {
        // Write your code here
        //create a list to store all  divisor
        List<Integer> ans = new ArrayList<>();
        //start from  i  up to i*i<=n which is sqrt of n
        for(int i=1;i*i<=n;i++)
        {
            //if it  is  divisor of n
            if(n%i==0)
            {
                //add into  list
                ans.add(i);
                //add another  divisor also n/i if not  equal to i
                if(i!=(n/i))
                ans.add(n/i);
            }
        }


        //sort answer list and return
        Collections.sort(ans);
        return ans;
    }

    public static void main(String args[])
    {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter a value of dividend");
        int n  = sc.nextInt();

        List<Integer>  ans = printDivisors(n);
        System.out.println("All  divisor of given number is " + ans);

    }
}