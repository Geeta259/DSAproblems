import java.util.*;

class findMissingOne
{

    public static int missingNumber(int A[], int N)
    {
         // Your code goes here
        int sum=(N*(N+1))/2;
        
        int getsum=0;
        for(int i=0;i<N;i++)
        getsum+=A[i];
        
       int res = sum-getsum;
        return res;
    }


    public static void main(String ar[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

       System.out.println("Enter elements in an array from 1 to " + n + "  except one element");
        int arr[] = new int[n];
        for(int i=0;i<n-1;i++)
        arr[i] = sc.nextInt();

       
        sc.close();

        int res = missingNumber(arr,n);
        System.out.println("Missing element from 1 to " + n + "  is  " + res);
        
    }
}