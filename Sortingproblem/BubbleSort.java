import java.util.*;

class BubbleSort
{

    public static void Sort(int arr[], int n)
    {
        //code here
        for(int i=0;i<n-1;i++)    //n-1 pass required
        {
            for(int j=0;j<n-1-i;j++)
            {
                if(arr[j]>arr[j+1])//swap
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    //using recursion perform bubble sort
    /*
     * 	public static void bubbleSort(int arr[], int n)
    {
        if(n==1)
        return;
        
        for(int i=0;i<n-1;i++)
        {
            if(arr[i]>arr[i+1])
            {
                int temp =arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        bubbleSort(arr,n-1);
    }
     */
    
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

      
        Sort(arr,n);
        
        System.out.println("After sorting elements in an array is");
        for(int i=0;i<n;i++)
        System.out.print(arr[i]+" ");
    }
}