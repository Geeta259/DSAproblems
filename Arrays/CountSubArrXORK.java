/*
Count the number of subarrays having a given XOR
Input : arr[] = {4, 2, 2, 6, 4}, m = 6
Output : 4
Explanation : The subarrays having XOR of 
              their elements as 6 are {4, 2}, 
              {4, 2, 2, 6, 4}, {2, 2, 6},
               and {6}

 */

import java.util.*;

class CountSubArrXORK
{

    public  static int subsetXOR(int arr[], int N, int K) {

        //use map to store prefix xor
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        //iniially fill map with 0 having frequency 1
        map.put(0,1);
        
        int getxor=0,count=0;
        for(int i=0;i<N;i++)
        {
            //xor of each element of array till index i
            getxor^=arr[i];

            //getxor^x = k we want xor k  of subarray // getxor^x^getxor = k^getxor // getxor^getxor becomes zero 
            //x = k^getxor if we get xor x in a map means x^getxor give xor k

            if(map.containsKey(getxor^K))
            //if present add frequency how many times it present in map  into count 
            count+=map.get(getxor^K);
            
            //put getxor xor till index i into map if not present frequency 1 if present increment frequency by  1
            map.put(getxor,map.getOrDefault(getxor,0)+1);
        }
        
        //return total no of subarray having xor k
        return count;
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

        System.out.println("Enter a number to get xor of subarrays");
        int k = sc.nextInt();

        sc.close();

        int res = subsetXOR(arr,n,k);
        System.out.println("Total Subarray with XOR "+k+" is "+res);
      
        
    }
}