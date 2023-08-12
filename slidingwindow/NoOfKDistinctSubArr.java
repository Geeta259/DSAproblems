/*
 Subarrays with K Different Integers
Input:
N = 5
k = 2
arr[ ] = {1, 2, 1, 2, 3}
Output: 7
Explanation: Subarrays formed with exactly 2 different integers:
 {1, 2}, {2, 1}, {1, 2}, {2, 3}, {1, 2, 1}, {2, 1, 2}, {1, 2, 1, 2}.
 */
import java.util.*;
class NoOfKDistinctSubArr
{
    static int findAtMost(int arr[],int N,int k)
    {
        //map create to store frequency of each element
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int i=0,j=0,distinct=0,count=0;
        
        //use sliding window to get valid substring 
        while(i<=j && j<N)
        {
            //check freq of current element till j index
            //if current element freq 0 or not present in map means it appears first time increment distinct by 1
            if(!map.containsKey(arr[j]) || map.get(arr[j])==0)
            distinct++;
            
            //increment freq of current element by 1
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            
            //if distinct at any point greater than k
            while(distinct > k)
            {
                //remove element from beginning until distinct<=k
                //decrement frequency of ith index element in map
                map.put(arr[i],map.get(arr[i])-1);
        
                //if freq becomes 0 of that element
                //one distinct element removed completely from current subarray 
                //decrement distinct by 1
                if(map.get(arr[i])==0)
                distinct--;
                
                //increment ith index
                i++;
                
            }
            
            //add no of possible subarray from i to j in count
            count+=j-i+1;
            j++;
        }
        
        return count;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of array");
        int n = sc.nextInt();

        System.out.println("Enter number in an array");
        int arr[] = new int[n];

        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        System.out.println("Enter no of distinct character in substring");
        int k = sc.nextInt();
        sc.close();
        
         //to find no of substring having exact k element
        //find no fo substring at most k distinct element minus no of substring at most k-1 element
        
        int count =  findAtMost(arr,n,k) - findAtMost(arr,n,k-1);
       
        System.out.println("Total no of subarray having k distinct character is  "+ count);

    }
}