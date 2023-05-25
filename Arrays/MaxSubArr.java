import java.util.*;

class MaxSubArr
{

    public static ArrayList<Integer> findSubarray(int a[], int n) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        int start=-1;
 
        int maxsum=Integer.MIN_VALUE,sum=0;
        int sidx=-1,eidx=-1;
        for(int i=0;i<n;i++)
        {
            if(a[i]>=0)
            {
                //if start index of subarray not intialize first initialize start index
                if(start==-1)
                start=i;
                
                //add every positive element 
                sum+=a[i];
                
            }else
            {
                //if negative element found
                //check sum of the element till current index greater than or equal to maxsum
                //if equal check subarray length 
                if(sum>maxsum || (sum==maxsum && (i-1)-start > eidx-sidx))
                {
                    //if any one condition satisfied update maxsum and starting and ending index of required subarray
                    maxsum=sum;
                     sidx=start;
                    eidx=i-1;
                }
                //check next subarray 
                 start=-1;
                sum=0;
            }
        }
        //after exit from loop again check sum of latest subarray greater than or equal to maxsum
        //if any one condition satisfied update starting and ending index of resulatnt subarray
                 if(sum>maxsum || (sum==maxsum && (n-1)-start > eidx-sidx))
                {
                    sidx=start;
                    eidx=n-1;
                }
                
                //if no subarray find of max sum return -1
                if(sidx==-1 && eidx==-1)
                arr.add(-1);
                else
                {
                    //add resultant subarray element into list and return
                      for(int i=sidx;i<=eidx;i++)
                    arr.add(a[i]);      
                }
              
                
                return arr;
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
        ArrayList<Integer> res = new ArrayList<>();
        res = findSubarray(arr,n);
        for(int i=0;i<res.size();i++)
        System.out.print(res.get(i)+" ");
        
    }
}