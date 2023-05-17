import java.util.*;

class LargestElem
{
    public static int findLargest(int arr[],int n)
    {
         int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>max)
            max=arr[i];
        }
        
        return max;
    }

    public static void main(String ar[])
    {
        
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        sc.close();
        //find largest element
        int max = findLargest(arr,n);
        System.out.println("Largest Element is\n" + max);
    }

    
}