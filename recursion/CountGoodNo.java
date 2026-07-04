/*
 Count Good Numbers
A digit string is good if the digits (0-indexed) at even indices are even
 and the digits at odd indices are prime (2, 3, 5, or 7).
 */
import java.util.*;

class CountGoodNo
{
   static int mod = 1000000007;

   public static long calPower(long n,long pow)
   {
    //if power is 0 return 1
       if(pow==0)
       return 1;

       //if power is even 
       if(pow%2==0)
       {
           //calculate power for half 
           long ans = calPower(n,pow/2);
            //multiply twice  to get ans
           return (ans%mod*ans%mod)%mod;
       }
       else
       {
        //if power is odd calculate power for pow-1 which is even and multiply by n number to get ans 
           long ans = calPower(n,pow-1);
           return (n%mod * ans%mod)%mod;
       }
   }

    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many digits good number you want");
        int n = sc.nextInt();
          
        //if n is even digit
        //half odd index half even index 
        //possibilities of odd index is prime 2,3,5,7 ( 4 possibilities)

        //total 5^n/2 * 4^n/2 --- 20^n/2 

        int ans = 0;
        if(n%2==0)
        ans =  (int)calPower(20,n/2);

        //if n is odd digit
        //possibilities of even index is even no 0,2,4,6,8  (5 possibilities)
        //half odd index half even index and one more even index with possibilites 5 
        else
        ans = (int)((5 * calPower(20,(n-1)/2))%mod);

        System.out.println("Total Good Number of "+ n + " digit is " + ans);
    }
   

}