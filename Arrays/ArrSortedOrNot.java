import java.util.*;
class CheckSorted
{
    boolean arraySortedOrNot(int[] arr, int n) {
        for(int i=0;i<n-1;i++)
        {
            if(arr[i]>arr[i+1])
            return false;
        }
        
        return true;
    }
}

class ArrSortedOrNot
{
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

        CheckSorted obj = new CheckSorted();
        boolean ans  = obj.arraySortedOrNot(arr,n);
        System.out.println(ans ? "Sorted Array" : "Not Sorted Array");
    }
}