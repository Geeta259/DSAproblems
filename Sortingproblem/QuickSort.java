import java.util.*;

class QuickSort
{
    static void qckSort(int arr[], int low, int high)
    {
        // code here
        if(low>=high)   //if low greater than or equal to high return null base condition
        return;
        
        int pvtidx = partition(arr,low,high);   //get correct index of a pivot element
        qckSort(arr,low,pvtidx-1);  //divide into two parts left subarr before pivot element
        qckSort(arr,pvtidx+1,high); //right subarr after pivot element
        
        
    }
    static int partition(int arr[], int low, int high)
    {
        // your code here
        int pivot = arr[low];   //considering first element as pivot element
        int left = low;  
        int right = high;
        
        while(left<right)       //iterate until left pointer less than right pointer
        {
            while(arr[left]<=pivot && left<high)    //stop when greater than pivot element find from left 
            left++;
            
            while(arr[right]>pivot && right>low) //stop when smaller than pivot element find from right
            right--;
            
            if(left<right)  //if left less than right swap both the elements continue next iteration 
            {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right]  = temp;
            }
        }
        
        //swap pivot element with right  if left pointer greater than right pointer after exit from loop right pointer point to correct posiiton of pivot element swap with first value
        int temp = arr[low];
        arr[low] = arr[right];
         arr[right]  = temp;
         
         
         return right; //return right pointer which is correct index of pivot element
        
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

      
        qckSort(arr,0,n-1);
        
        System.out.println("After sorting elements in an array is");
        for(int i=0;i<n;i++)
        System.out.print(arr[i]+" ");
    }
}