/*
 Leaders in an array
 Given an array A of positive integers. Your task is to find the leaders in the array.
  An element of array is leader if it is greater than or equal to all the elements to its right side.
   The rightmost element is always a leader. 


   Input:
n = 6
A[] = {16,17,4,3,5,2}
Output: 17 5 2
Explanation: The first leader is 17 
as it is greater than all the elements
to its right.  Similarly, the next 
leader is 5. The right most element 
is always a leader so it is also 
included.

Approach
1)compare from end rightmost element always a leader because no element found after this
2)maintain a max variable and compare from end if it greater than max from right update max and add into list because it is leader element till now it is maximum element from right
3) reverse arraylist element beacuse want element inn a order inn which it is given
 
 */
import java.util.*;

class LeaderArr
{

   //Function to find the leaders in the array.
   static ArrayList<Integer> leaders(int arr[], int n){
    // Your code here
    
    ArrayList<Integer> res = new ArrayList<Integer>();
    
    res.add(arr[n-1]);
    int max=arr[n-1];
    
    for(int i=n-2;i>=0;i--)
    {
        if(arr[i]>=max)
        {
            res.add(arr[i]);  
            max=arr[i];
        }
        
    }
    
   //reverse arraylist element
   for(int i=0;i<res.size()/2;i++)
   {
       int temp =res.get(i);
       int last = res.size()-i-1;
       
       res.set(i,res.get(last));
       res.set(last,temp);
   }
    return res;
    
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
        
        ArrayList<Integer> res = new ArrayList<>();
        res = leaders(arr,n);

        System.out.println("Leader Elements are");
        for(int i=0;i<res.size();i++)
        System.out.print(res.get(i)+" ");
        
    }
}