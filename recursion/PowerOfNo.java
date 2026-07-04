/*
 * Power Of Numbers
 * Given a number and its reverse. Find that number raised to the power of its own reverse.
Note: As answers can be very large, print the result modulo 109 + 7
Input:
N = 2
Output: 4
 */
import java.util.*;

class PowerOfNo
{
    static int mod = 1000000007;

    public static long power(int N,int R)
    {
        //base condition
        //if number is 0 return 0
        if(N==0)
        return 0;
        
        //if power is 0 return 1
        if(R==0)
        return 1;
        
        //if power is even calculate for half power 
        if(R%2==0)
        {
            long cal = power(N,R/2);
            //return cal*cal
            return (cal%mod*cal%mod)%mod;
        }else
        {
            //if power is  odd calculate for r-1/2 half of even
           long cal = power(N,(R-1)/2);
           //return cal*cal*n
           return (cal%mod*cal%mod*N%mod)%mod;
        }
    }

    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        
        System.out.println("Enter a reverse of given number");
        int pow = sc.nextInt();
    
        long ans =  power(n,pow);
        //print the ans
        System.out.println("Power of numbers is "+ ans);
    }
   

}