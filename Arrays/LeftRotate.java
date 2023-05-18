import java.util.*;
class RevArr{
    void revArr(long arr[],int s,int e)
    {
        while(s<e)
        {
            long temp = arr[s];
            arr[s] = arr[e];
            arr[e]=temp;
            
            s++;
            e--;
        }
    }
}

class LeftRotate
{
    public static void main(String ar[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

       System.out.println("Enter elements in an array");
        long arr[] = new long[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        System.out.println("Enter left rotate index");
        int k = sc.nextInt();

        if(k>n) //if it greater than total no of elements divide by n and get index
        k=k%n;

        sc.close();

        RevArr obj = new RevArr();
        //to rotate array by left rotate index 
        obj.revArr(arr,0,k-1); //first half rev from 0 to k-1
        obj.revArr(arr,k,n-1); //second half rev from k to n-1
        obj.revArr(arr,0,n-1); //whole array reverse to get rotated array

        System.out.println("After left Rotation array will be");
        for(int i=0;i<n;i++)
        System.out.print(arr[i]+" ");
    }
}