import java.util.*;
class RadixSort
{
    public static void countSort(int arr[],int n,int pos)
    {
        //initialize count array range from 0 to 9 digit
        int count[] = new int[10];
        
        //set frequency of each digit which placed in pos place
        for(int i=0;i<n;i++)
        {
            int digit = (arr[i]/pos)%10;
            count[digit]++;
        }
        
        //prefix sum stored into count array
        for(int i=1;i<10;i++)
        count[i] = count[i]+count[i-1];
        
        //initialize another array which store sorting value according to given pos place
        int B[] = new int[n];
        
        for(int i=n-1;i>=0;i--)
        {
            //get digit of current pos place at ith index
            int digit = (arr[i]/pos)%10;
            //first decrement count array at digit index by 1 becuase given array start from 0 index
            count[digit]--;
            //current element placed at index which count stored 
            B[count[digit]] = arr[i];
        }
        
        //changes done into original array
        for(int i=0;i<n;i++)
        arr[i] = B[i];
    }
    
    static void radixSort(int arr[], int n) 
    { 
        //get maximum element from given array
        int maxelem = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        maxelem = Math.max(maxelem,arr[i]);
        
        //do counting sort for each place value
        //first ones-->tens-->hundred so on....
        
        for(int pos=1;(maxelem/pos)>0; pos*=10)
        countSort(arr,n,pos);
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

          radixSort(arr, n);
        System.out.println("After sorting elements in an array is");
        for(int i=0;i<n;i++)
        System.out.print(arr[i]+" ");
    }
}
