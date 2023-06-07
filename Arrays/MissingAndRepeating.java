/*
Find Missing And Repeating
Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2,....,N}
 is missing and one number
 'B' occurs twice in array. Find these two numbers.

 Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and 
smallest positive missing number is 1.
 *
 * 
 * Approach
 * 1) one way to use count freq array from 1 to n and store frequency of each array
 * 2) if frequnecy of any element from 1 to n is 0 it is missing number
 * 3) if frequency of any element from 1 to n is 2 it is repeating number
 * 
 * It took extra space 0(n)
 * 
 * without taking any extra space  use mathematical approach to solve this question
 */

import java.util.*;

class MissingAndRepeating
{

    public static int[] findTwoElement(int arr[], int n) {
        //use mathematical approach to solve this problem

        long len = (long) n; 
        
        long S = (len * (len + 1) ) / 2;
        long P = (len * (len + 1) * (2 * len + 1) ) / 6;
        long missingNumber = 0, repeating = 0;

        for (int i = 0; i < n; i++) {
            //remove element from sum  one by one
            S -= (long)arr[i];

            //remove square elements from square sum one by one
            P -= (long)arr[i] * (long)arr[i];
        }

 //now we have two equation consider from 1 to n elements as X and all array element is Y
        //X-Y = sum X2-Y2 = squaresum to solve these equation get x and y which is missing and repeating number
        
        //by solving these equation simplify X-Y=S and X+Y = P/S 
        //X = (S+P/S)/2 AND Y=X-S   
        
        missingNumber = (S + P / S) / 2;

        repeating = missingNumber - S;

           
        int res[] = new int[2];
        res[1] = (int)missingNumber;
        res[0] = (int)repeating;
        
        return res;

    
        
    }


    public static void main(String ar[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
       System.out.println("Enter elements in to a array in which exactly one element is missing in a sequnence order and exactly one number is twice");
        for(int i=0;i<n;i++)
         arr[i] = sc.nextInt();
    
        
        sc.close();

        int res[] = new int[2];
        res = findTwoElement(arr,n);
       
  
       System.out.println("Repeating Number in an array is " + res[0]);
       System.out.println("Missing Number in an array is " + res[1]);   
        
    }
}