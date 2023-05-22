import java.util.*;

class MergeSort
{

    public static void merge(int arr[], int l, int m, int r)
    {
         // Your code here
         int temp[] = new int[r-l+1];
         int left = l;
         int right = m+1;
         
         int idx=0;
         while(left<=m && right<=r)
         {
             if(arr[left]<=arr[right])
             {
                 temp[idx] = arr[left];
                 left++;
             }else
             {
                 temp[idx] = arr[right];
                 right++;
             }
             
             idx++;
         }
         
         while(left<=m)
          temp[idx++] = arr[left++];
          
           while(right<=r)
          temp[idx++] = arr[right++];
          
          
          for(int i=l;i<=r;i++)
          arr[i] = temp[i-l];
                
                
         
    }

    public static void mrgSort(int arr[], int s,int e)
    {
        int mid = (s+e)/2;
        if(s>=e)
        return;

        mrgSort(arr,s,mid);
        mrgSort(arr,mid+1,e);
        merge(arr,s,mid,e);

    }
    
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

      
        mrgSort(arr,0,n-1);
        
        System.out.println("After sorting elements in an array is");
        for(int i=0;i<n;i++)
        System.out.print(arr[i]+" ");
    }
}