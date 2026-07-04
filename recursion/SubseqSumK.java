/*

 */
import java.util.*;


class SubseqSumK
{
   public static  void  getSubSeq(int arr[],ArrayList<Integer> li,int sum, int total,int idx)
   {
        //base consition
        if(idx==arr.length)
        {
            //check sum equal to total
            if(sum==total)
            System.out.print(li+" ");

            return;
        }

           //pick idx element  form arr
            //add into list and update sum
            li.add(arr[idx]);
            sum+=arr[idx];

            //call for next element with pick current element
            getSubSeq(arr,li,sum,total,idx+1);

            //not pick idx element from arr

            //remove last element from list picked element and decrement sum
            li.remove(li.size()-1);
            sum-=arr[idx];
          
            //call for next element without picking current element
            getSubSeq(arr,li,sum,total,idx+1);

   }
    
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array");
        int n = sc.nextInt();
       
        System.out.println("Enter elements in to array");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        System.out.println("Enter required sum of subsequence");
        int total = sc.nextInt(); 
        sc.close();
   
        //recursively call to get each subseq of total sum
        int sum=0;
          ArrayList<Integer> li = new ArrayList<>();
       
          getSubSeq(arr,li,sum,total,0);
    }
   

}