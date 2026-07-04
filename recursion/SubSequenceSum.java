/*
Subset Sums
Given a list arr of N integers, print sums of all subsets in it.
Input:
N = 2
arr[] = {2, 3}
Output:
0 2 3 5
 */
import java.util.*;


class SubSequenceSum
{
    public static void generateSubSeqSum(int idx, int[] arr, ArrayList<Integer> sumarr,int sum)
    {
        //base condition if reach out of bounds
        if(idx==arr.length)
        {
            //store current subseq sum into arraylist & get back from it
            sumarr.add(sum);
            return;
        }
        
        //first possibility to pick current element and add into sum & go to next element
        generateSubSeqSum(idx+1,arr,sumarr,sum+arr[idx]);
        
        //second possibility not pick current element  & go to next index
        generateSubSeqSum(idx+1,arr,sumarr,sum);
        
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

         sc.close();
   
      
          //create a list to store sum of each subsequence
          ArrayList<Integer> sumarr = new ArrayList<>();
        
          int sum=0;
        //call recursion mmethod for index 0
        generateSubSeqSum(0,arr,sumarr,sum);

        Collections.sort(sumarr);
        
        System.out.println(sumarr);
       
          
    }
   

}