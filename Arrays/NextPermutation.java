/*
 * Next Permutation
 * Input: N = 6
arr = {1, 2, 3, 6, 5, 4}
Output: {1, 2, 4, 3, 5, 6}
Explaination: The next permutation of the 
given array is {1, 2, 4, 3, 5, 6}.

Approach
1) first finnd breaking point either from starting or ending here breaking point 3 at index 2 (after breaking point all are decreasing order)
2) if no breaking point find means given array in decreasing order so just reverse it for next arrangement
3) find minimum but greater than breaking value  (for next lexicographic order) here is 4 at index 5
4) after find minimum value swap with breaking point value (1,2,4,6,5,3)
5)after breaking point value sort array ascending order (1,2,4,3,5,6)
 */
import java.util.*;

class NextPermutation
{

    public static void nextLexicographicorder(int N, int arr[]){
       
         //find breaking index either check from starting or ending
        int brkidx=-1;
        for(int i=1;i<N;i++)
        {
            if(arr[i]>arr[i-1])
            brkidx=i-1;
        }
        
        //find minimum value after breaking point if not any breaking point find means all element are in decreasing order
        int min=Integer.MAX_VALUE,minidx=-1;
        if(brkidx!=-1)
        {
             for(int i=brkidx+1;i<N;i++)
                {
                    if(arr[i]<min && arr[i]>arr[brkidx])
                    {
                          min=arr[i];
                          minidx = i;
                    }
                  
                }
             
        }
       
        //swap breaking point with minimum value after breaking point
        if(minidx!=-1)
        {
             int temp = arr[brkidx];
                arr[brkidx] = arr[minidx];
                arr[minidx] = temp;     
        
        }
        
            
            //sort element  from brkidx+1 to n
             Arrays.sort(arr,brkidx+1 , N);
        
         
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
        
        nextLexicographicorder(n,arr);
        for(int i=0;i<n;i++)
        System.out.print(arr[i]+" ");
        
    }
}