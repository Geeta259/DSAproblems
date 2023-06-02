/*
Majority Element II
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Approach
Use  Extended Boyer Moore’s Voting Algorithm
1) As we know of n length majority element greater than n/3 is not more than 2 either it 0,1,or 2
2)we take two variable as major1 and major2 element two element whose frequency is larger among all the elements
3)then find their frequency how many times they occur in array
4)if it greater than n/3 add into list otherwise not
 */

import java.util.*;

class MajorityElement
{
    public static List<Integer> majElem(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        int maj1=-1,maj2=-1;

        int c1=0,c2=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==maj1)   //check if it equal to major1 element increment count c1
            c1++;

            else if(nums[i]==maj2) //check if it equal to major2 element increment count c2
            c2++;

            else if(c1==0) //if at any point c1 become zero means till now no majority element found update majority element by current element
            {
                          maj1=nums[i]; 
                          c1++; //increment c1 by  1
            }
      
            else if(c2==0) //if at any point c2 become zero and c1 not zero means till now no second majority element found update second majority element by current element
            {
                        maj2=nums[i];
                        c2++;   //increment c2 by 1
            }
        
            else
            {
                //otherwise if both count not zero and not equal to amjority element decrement c1 and c2 if other elements found except majority element
                c1--;
                c2--;
            }
        }

        //if both majority element found count their frequency in array
        c1=0; c2=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==maj1)
            c1++;

            if(nums[i]==maj2)
            c2++;
        }

        //if their frequency greater than n/3 add into list and return

        if(c1>nums.length/3)
        list.add(maj1);
        if(c2>nums.length/3 && maj1!=maj2)
        list.add(maj2);

     

        return list;
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

        List<Integer> list = new ArrayList<Integer>();
        list = majElem(arr);
      
        System.out.println(list);
        
      
        
    }
}
   