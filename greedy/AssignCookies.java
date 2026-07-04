/*
Assign Cookies\

*/

import java.util.*;
class AssignCookies
{
    public static int assignCookie(int []g, int []s) {
        // Write your code here.
        //first sort  greed  factor  and cookie  size
        //so  that maximum no  of children get cookies
         Arrays.sort(g);
       Arrays.sort(s);

        int count=0;
        
        for(int i=0,j=0;i<g.length && j<s.length;)
        {
            //if cookies size greater than greed factor assign cookie  to that  childre and move  forward
            if(s[j]>=g[i])
            {count++; j++; i++;}
            else
            j++;//otherwise increase cookies size  to  assign to children
        }
        //return max no  of  children which get cookies
        return count;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of greed");
        int n = sc.nextInt();

        int[] greed = new int[n];
        System.out.println("Enter value of each  greed");
        for(int i=0;i<n;i++)
        greed[i] = sc.nextInt();

        System.out.println("Enter no of cookies");
        int n2 = sc.nextInt();

        int[] cookie = new int[n2];
        System.out.println("Enter size of each cookie");
        for(int i=0;i<n2;i++)
        cookie[i] = sc.nextInt();


       int ans = assignCookie(greed,cookie);
       System.out.println("Maximum no of  children who get  cookies is " + ans);

    }

}