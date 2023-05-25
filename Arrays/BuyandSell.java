/*
Stock buy and sell
The cost of stock on each day is given in an array A[] of size N. Find all the days on which
 you buy and sell the stock 
so that in between those days your profit is maximum.

Input:
N = 7
A[] = { 100, 180, 260, 310, 40, 535, 695 }

Output:
(0 3) (4 6)

Explanation 1:
We can buy stock on day 0, 
and sell it on 3rd day, 
which will give us maximum profit
 */

import java.util.*;

class BuyandSell
{

    public static void stockBuySell(int[] price, int n) {
        // code here
        int start=0,flag=0;
        int i=1;
        for(;i<n-1;i++)
        {
            
            //at any point if price[i] smaller than start value update start for next buy
               if(price[i]<price[start])
               start=i;
               
               //maximum profit when sell at i index for buy start index 
               if(price[i]>price[i-1] && price[i]>price[i+1])
               {
                   System.out.print("("+start+" "+i+")"+" ");

                  // update start for next buy
                   start=i+1;

                   //flag pointer indicate atleast one profit found
                   flag=1;
               }
        }
         
         
        //check for last element if it greater than start value one more profit add into list
       if(price[i]>price[start])
       {
            System.out.print("("+start+" "+i+")"+" ");
            flag=1;
       }
       
       //check if any profit get or not by maintain flag variable
       if(flag==0)
       System.out.print("No Profit");    
        
        
        System.out.println();
        
    }


    public static void main(String ar[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

       System.out.println("Enter elements in an array");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

       
        sc.close();
        stockBuySell(arr,n);
        
    }
}