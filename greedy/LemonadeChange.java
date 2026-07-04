/*
Lemonade Change
Input: bills = [5,5,5,10,20]
Output: true
Explanation: 
From the first 3 customers, we collect three $5 bills in order.
From the fourth customer, we collect a $10 bill and give back a $5.
From the fifth customer, we give a $10 bill and a $5 bill.
Since all customers got correct change, we output true.
*/

import java.util.*;
class LemonadeChange
{
    public static boolean lemonadeChange(int[] bills) {
        //count no of 5 and 10 coins
        int c5=0,c10=0;

        //traverse through bills
        for(int i=0;i<bills.length;i++)
        {
            //if customer give 5 rupee no need to give change count 5 no of coins
            if(bills[i]==5)
            c5++;
            //else customer pay either 10 or 20 must have atleast one 5 coins to give change if have not return false
            else if(c5==0)return false;
            //if customer pay 10
            else if(bills[i]==10)
            {
                //one 5 rupee coin decrement give change to customer and one 10 rupee coin increment
                c5--;
                c10++;
            }
            else
            {
                //if customer pay 20 give chnage to 15 back to customer
                //if we have 10 coin give that one and one 5 coins 
                if(c10>=1) 
                {
                    c10--;
                    c5--;
                }
                //if does not have any 10  coins give 3 5coins if does not have cannot give change to customer return false
                else if(c5>=3)
                {
                    c5-=3;
                }
                else
                return false;
            }
        }

        //if successfully give change to all customers return true
        return true;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of bills");
        int n = sc.nextInt();

        int bills[] = new int[n];
        System.out.println("Enter rupees for each bill either 5,10 or 20");
        for(int i=0;i<n;i++)
        bills[i] = sc.nextInt();

        boolean ans = lemonadeChange(bills);
        if(ans)
        System.out.println("Provided required change to each customers");
        else
        System.out.println("Can not able to provide required change to each customers");

    }

}