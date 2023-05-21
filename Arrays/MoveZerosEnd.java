import java.util.*;
class ZeroEnd{
    void pushZerosToEnd(int[] arr, int n) {
        // code here
        for(int i=0,j=1;i<n && j<n;)
        {
            //use two pointer approach to shift all zero at end
            if(arr[i]!=0)   //if current elem not zero increment both pointer by one
            {
                i++;
                j++;
            }
  
            else if(arr[i]==0 && arr[j]!=0) //if current elem is zero and next elem not zero swap both then increment by one
            {
                   arr[i]=arr[j];
                   arr[j]=0;
                   j++; 
                   i++;
            }
              else  //if current elem and next elem both zero find next non zero elem by increment only j pointer so that we can swap zero by non negative element
            j++;
         }
      
    }
}

class MoveZerosEnd
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

        ZeroEnd obj = new ZeroEnd();
        //to rotate array by left rotate index 
        obj.pushZerosToEnd(arr,n);

        System.out.println("After push all zeros at end the array will be");
        for(int i=0;i<n;i++)
        System.out.print(arr[i]+" ");
    }
}