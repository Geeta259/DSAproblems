import java.util.*;

class findSingleElem
{

    public static int singleNumber(int[] nums,int n) {

        int sum=0;
 
         for(int i=0;i<n;i++)
         {
             sum = sum ^  nums[i];  //xor property use all same are cancel out with each other at last only single element left
         }
         
         return sum;        //it will return single element

         //if given array element is already sorted without xor 
         /*
          *  for(int i=0;i<N-1;i+=2)
        {
            if(A[i]!=A[i+1])
            return A[i];
        }
        
         return A[N-1];
          */
     }


    public static void main(String ar[])
    {
        System.out.println("Enter odd size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

       System.out.println("Enter two ocuurrence of each elements in an array except one element");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

       
        sc.close();

        int res = singleNumber(arr,n);
        System.out.println("Single element in an array is " + res);
        
    }
}