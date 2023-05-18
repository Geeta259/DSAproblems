import java.util.*;
class RmvDup {
    int remove_duplicate(int A[],int N){
        // code here
        int idx=0;
        for(int i=1;i<N;i++)
        {
            if(A[idx]!=A[i])    //if elements are distinct in a sequence add in to array else skip
            {
                idx++;  
                A[idx] = A[i];
            }
        }

        return idx+1; //return total no of distinct element in a sorted array 
           
    }
}

class RemoveDuplicateElement
{
    public static void main(String ar[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

       System.out.println("Enter elements in an array sorted manner");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        sc.close();

        RmvDup obj = new RmvDup();
        int count = obj.remove_duplicate(arr,n);

        for(int i=0;i<count;i++)
        System.out.print(arr[i]+" ");
    }
}