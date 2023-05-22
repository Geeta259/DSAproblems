import java.util.*;
class SortArr
{
	int  select(int arr[], int i)
	{
        // code here such that selectionSort() sorts arr[]
        int min = i;
        for(int idx=i;idx<arr.length;idx++)
        {
            if(arr[idx]<arr[min])
            min=idx;
        }
        
        return min;
	}
	
	void selectionSort(int arr[], int n)
	{
	    //code here
	    for(int i=0;i<n-1;i++)
	    {
	        int minidx = select(arr,i+1);
	        if(arr[i]>arr[minidx])
	        {
	            int temp = arr[i];
	            arr[i] = arr[minidx];
	            arr[minidx]=temp;
	        }
	        
	       
	    }
	}
}


class SelectionSort
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

        SortArr obj = new SortArr();
        obj.selectionSort(arr,n);
        
        System.out.println("After sorting elements in an array is");
        for(int i=0;i<n;i++)
        System.out.print(arr[i]+" ");
    }
}