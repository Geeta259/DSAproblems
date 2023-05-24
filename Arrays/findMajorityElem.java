/*
Majority Element
Given an array A of N elements. Find the majority element in the array.
 A majority element in an array A of size N is an element that appears more than N/2 times in the array.
 
 */

import java.util.*;

class findMajorityElem
{

   public static int majorElem(int a[], int size)
    {
        // your code here
        //if a majority element greater than n/2 means rest all elements less than n/2 
        //assume first element as majority element
       int majelem = a[0];
       int count=0;
       
       for(int i=0;i<size;i++)
       {
           //if at any point count become neutral 0 means no mjaority element found at that point assume current one majority element
           if(count==0)
           majelem = a[i];
           
           //if current element equal to assuming majority element increment count by one
           if(majelem == a[i])
           count++;
           
           //if it different from majority element decrement count by one
           else
           count--;
       }
       
       
       //at last we will get majority element in majelem variable
       //verify that finding majorityelem is greater than n/2 or not
       count=0;
       for(int i=0;i<size;i++)
       {
           if(a[i]==majelem)
           count++;
       }
        
        if(count>size/2)
        return majelem;
        else
        return -1;
    }
   
     public static void main(String ar[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

       System.out.println("Enter elements in a array");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        sc.close();

       int  res = majorElem(arr,n);
       if(res!=-1)
        System.out.println("Majority Element greater than n/2 is " + res);
        else
        System.out.println("Majority Element not found!!");
        
    }
}