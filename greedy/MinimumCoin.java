/*
Minimum number of Coinsinfinite supply of each denomination of Indian currency 
{ 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 } and a target value N.
*/

import java.util.*;
class MinimumCoin
{
    static List<Integer> minPartition(int N)
    {
        // code here
        //create a currency rupees
        int curr[] = {1,2,5,10,20,50,100,200,500,2000};
        
        //create a list which store min no of coins 
        List<Integer> list = new ArrayList<>();
        
        //start from last and pick element greedy
        int i=9;
        //iterate until i becomes 0
        while(i>=0)
        {
            //if current rupee less than N pick that element and add into list
            //decrement n by current rupee
            if(curr[i]<=N)
            {
                list.add(curr[i]);
                N-=curr[i];
            }
            //if current rupee greater than N decrement i value pick small rupee
            else
            i--;
        }
        
        //return min no of coins list
        
        return list;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of required rupees to get minimum no of coins");
        int val =  sc.nextInt();

        List<Integer> list = new ArrayList<>();
        list = minPartition(val);
        System.out.println("Coins required " + list);
    }

}