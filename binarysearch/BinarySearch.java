import java.util.*;

class BinarySearch
{
    public static int binSearch(int arr[], int n, int k) {
        // code here
        int start=0;
        int end=n-1;
        
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(arr[mid]==k)
            return mid;
            else if(arr[mid]>k)
            end=mid-1;
            else
            start=mid+1;
        }
        
        return -1;
    }

    public static void main(String args[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter elements in to array");
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        System.out.println("Enter element which you want to find");
        int k = sc.nextInt();
        sc.close();
        int idx = binSearch(arr,n,k);
        if(idx!=-1)
        System.out.println("Target Element found at index " + idx);
        else
        System.out.println("Target Element not found");
    }
}