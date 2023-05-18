import java.util.*;

class InsertionSort
{

    public static void Sort(int arr[], int n)
    {
        //code here
        for(int i=1;i<n;i++)    //n-1 pass required
        {
           int j=i-1;
           int temp = arr[i];
           while(j>=0 && arr[j]>temp)
           {
                arr[j+1] = arr[j];
                j--;
           }

           arr[j+1] = temp;
        }
    }
    

    /*
     * using recursion
     * static void insert(int arr[],int n,int i)
  {
       // Your code here
            if(i==n)
            return;
            
            int j=i-1;
            int temp = arr[i];
            while(j>=0 && arr[j]>temp)
            {arr[j+1]=arr[j];
            j--;}
            
           arr[j+1]=temp;
           
           insert(arr,n,i+1);
        
       
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