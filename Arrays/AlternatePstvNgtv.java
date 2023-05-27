/*
 * Alternate positive and negative numbers
 * 
 * Approach
 * //case 1 ) when positive and negative numbers are not equal
 * 1) Define two array one contain positive element and one contain negative element
 * 2) Traverse two array simulataneously and add one positive and one negative elemnt in a single pass in a resultant array 
    3) if positive elements greater than negative element after exit from loop only positive element left add into resulatnt array
    4) if only negative elements left then add into resultant array

    //case 2 ) when positive and negative numbers are equal
    1)No need to declare two separate array for positive and negative elements
    2)create a new resultant array while  traverse into actual array first index contain positive number then third index contain posiitve number and so on pstv index increment by 2 in resultant array
    3) second index contain negative value then fourth , sixth and so on.. ngtv index increment by 2 which contain negative number
    4) This way add all positive and negative number in an alternate way in resulatant array
 

    //optimal approach when positive and negative numbers are equal
       int arr[] = new int[nums.length];
        int pstv=0;
        int ngtv=1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                arr[pstv]=nums[i];
                pstv+=2;
            }
            else
            {
                arr[ngtv]=nums[i];
                ngtv+=2;
            }
          
        }
 */



import java.util.*;

class AlternatePstvNgtv
{

    //when posiitve and negative numbers are not equal
    public static void rearrange(int arr[], int n) {
        // code here
        
        //count positive and negative element
        int pstv=0,ngtv=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>=0)
            pstv++;
            else
            ngtv++;
        }
       int pstvarr[] = new int[pstv];
       int ngtvarr[] = new int[ngtv];
       
       int p=0,ng=0;
       for(int i=0;i<n;i++)
       {
           if(arr[i]<0)
           {
                ngtvarr[ng] = arr[i];
                ng++;    
           }else
           {
               pstvarr[p] = arr[i];
               p++;
           }
           
       }
       
       int i=0,j=0,idx=0;
       while(i<p && j<ng && idx<n)
       {
          arr[idx++]=pstvarr[i++];
          arr[idx++]=ngtvarr[j++];
       }
        
        
        while(i<p && idx<n)
       arr[idx++]=pstvarr[i++];
       
        while(j<ng && idx<n)
       arr[idx++]=ngtvarr[j++];
        
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
        
        rearrange(arr,n);
        for(int i=0;i<n;i++)
        System.out.print(arr[i]+" ");
        
    }
}