/*
 *  Fruit Into Baskets
Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
 */
import java.util.*;
class FruitInBasket
{
    public static int totalFruit(int[] fruits) {

        int max = 0;

        //declared two baskets contained no fruits
        int b1=-1,b2=-1; 

        //count number of fruits of type b1 and b2
        int cnt1=0,cnt2=0;

        //use two pointer identify start and end point of valid subarray
        int i=0,j=0;


        while(i<fruits.length && j<fruits.length)
        {
            //if nothing in bag1 or current fruit is type of b1
            //put into b1 bag and count increment for b1 and go for next food type
            if(b1==-1 || fruits[j]==b1)
            {
                   b1 = fruits[j];
                   cnt1++;
                   j++;
            }
             //if nothing in bag2 or current fruit is type of b2
            //put into b2 bag and count increment for b2 and go for next food type
           
           else if(b2==-1 || fruits[j]==b2)
            {
                 b2 = fruits[j];
                 cnt2++;
                 j++;
            }
        
            else{

                    //if different type of fruit comes 
                    //empty either bag1 or bag2 

                    //get length of current subarray
                   max = Math.max(max,j-i);

                    //if fruit in bag1 empty 
                    if(cnt1==0)
                    {
                        //move fruit of bag2 in bag1
                         b1 = b2;
                         //bag2 is empty 
                         b2 =-1;
                         //count update for bag1
                         cnt1 = cnt2;
                         //count update for bag2
                         cnt2=0;
                    }

                    //if bag2 is empty intialize with -1 so that new fruit type can come
                    else if(cnt2==0)
                    {
                       b2=-1;
                    }

                    //if both bag contained fruit incremenet i and remove that ith fruit from  respective bag

                   else if(fruits[i]==b1) 
                   {
                       //remove fruit from bag1
                       i++;
                       cnt1--;
                   }
                    else 
                    {
                        //remove fruit from bag2
                        cnt2--;
                        i++;
                    }
                  
            }
        }

        //return max length of valid subarray
        return  Math.max(max,j-i);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number of tree");
        int n = sc.nextInt();

        System.out.println("Enter type of food for each tree");
        int arr[] = new int[n];

        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        sc.close();
        
        int max = totalFruit(arr);
        System.out.println("Maximum no of food puts in 2 baskets is " + max);

    }
}