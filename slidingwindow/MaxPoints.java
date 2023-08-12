/*
 *    Maximum Points You Can Obtain from Cards
Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. However, 
choosing the rightmost card first will maximize your total score.
 The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
 */
import java.util.*;
class MaxPoints
{
    public static int maxScore(int[] cardPoints, int k) {
        //total length of card
        int len = cardPoints.length;
        //discard elements from cards
        int discard = len-k;

        int total=0;

        //get total points of card
        for(int n : cardPoints)
        total+=n; 

        //start from 0th index considered subarray which is not include in k cards
        int i=0,j=0,ans=0,sum=0;
        while(i<=j && j<len)
        {
            //if no of discard elements covered
            if(j>=discard)
            {
                //remove one card from beginning and add current card for considered discard subarray cards 

                //required k cards points is total-sum
                //store max points
                ans = Math.max(ans,total-sum);

                //remove ith card from discard sum at beginning and include in k cards
                sum-=cardPoints[i];
                //incrrment i index
                i++;
            
            }
            //current discard card index points add into sum
            sum+=cardPoints[j];
            //increment jth index
            j++;
        }
        
        //get max and return
        ans = Math.max(ans,total-sum);
        return ans;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of cards");
        int n = sc.nextInt();

        System.out.println("Enter points of each cards");
        int arr[] = new int[n];

        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        System.out.println("size of subarray");
        int k = sc.nextInt();

        sc.close();
        
        int max = maxScore(arr,k);
        System.out.println("Maximum sum of  "+ k + "cards pick either from beginning or end is  " + max);



    }
}