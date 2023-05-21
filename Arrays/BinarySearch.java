import java.util.*;

class BinarySearch 
{
    static int searchInSorted(int arr[], int N, int K)
    {
        
        // Your code here
        int start=0,end=N-1;
        while(start<=end)
        {
            int mid = end -  (end-start)/2;
            if(arr[mid]==K)
            return mid;
            else if(arr[mid]>K)
            end=mid-1;
            else
            start=mid+1;
        }
        
        return -1;
    }

    public static void main(String ar[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

       System.out.println("Enter sorted elements in an array");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        System.out.println("Enter key which you want to search in an array");
        int key = sc.nextInt();
       
        sc.close();

       int res = searchInSorted(arr,n,key);
       if(res!=-1)
       System.out.println("Key found at index " + res);
       else
       System.out.println("Key not found in an array");
        
    }
}