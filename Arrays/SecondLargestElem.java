import java.util.*;

class SecondLargestElem
{
   
    public static int findSecondLargest(int arr[], int n) {
        // code here
 
        //find second max in a single iteration
        int secondmax=-1,firstmax=-1;
    
        for(int i=0;i<n;i++)
        {
            if(arr[i]>firstmax)
            {
                secondmax=firstmax;
                firstmax=arr[i];
            }
            if(arr[i]>secondmax && arr[i]!=firstmax)
            secondmax = arr[i];
        
        }
        return secondmax;
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
         int secondmax = findSecondLargest(arr,n);
        System.out.println("Second Largest Element is\n" + secondmax);
    }

    
}