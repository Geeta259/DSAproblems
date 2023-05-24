/*
 * Find all pairs with a given sum
 * Given two unsorted arrays A of size N and B of size M of distinct elements, 
 * the task is to find all pairs from both arrays whose sum is equal to X.
 * 
 * Approach : 
 * Input:
A[] = {1, 2, 4, 5, 7}
B[] = {5, 6, 3, 4, 8} 
X = 9 


1)create a hashmap to store second array element 
2)sort first array elements because we need resultant array in a sorted way
3)while traversing first array check second pair (x-a[i]) present in a map or not
4)if it present in a map create a pair and add into list
5)after all pair add into list create a pair array store into array and return

 */

import java.util.*;
class pair
{
    int first,second;
    public pair(int first,int second)
    {
            this.first = first;
            this.second = second;
    }
}

class TwoPairSum
{

    public static pair[] allPairs( int A[], int B[], int N, int M, int X) {
        // Your code goes here 
        
        //create hashmap to store second array elements
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<M;i++)
        map.put(B[i],1);
        
        
        ArrayList<pair> list = new ArrayList<>();
        
        //sort first array elements because we need pair in increasing order
        Arrays.sort(A);
        
        for(int i=0;i<N;i++)
        {
            //check map contains x-a[i] elements if it present one pair we get sum equal to x
            if(map.containsKey(X-A[i]))
            {
                //create a pair and add into list
                pair p = new pair(A[i],X-A[i]); 
                list.add(p);
            }
        }
        
        //create an array which contain all pair whose sum equal to x and return resultant arary
        pair ans[] = new pair[list.size()];
        for(int i=0;i<list.size();i++)
        ans[i] = list.get(i);
        
        return ans;
        
    }

     public static void main(String ar[])
    {
        System.out.println("Enter size of first array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

       System.out.println("Enter elements in a first array");
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
        arr1[i] = sc.nextInt();

        System.out.println("Enter size of second array");
        int m = sc.nextInt();

       System.out.println("Enter elements in a second array");
        int arr2[] = new int[n];
        for(int i=0;i<m;i++)
        arr2[i] = sc.nextInt();

        System.out.println("Enter pair sum");
        int x = sc.nextInt();

        sc.close();

        pair ans[] = allPairs(arr1,arr2,n,m,x);

        for(int i=0;i<ans.length;i++)
        System.out.println(ans[i].first+" "+ans[i].second);
        
    }
}