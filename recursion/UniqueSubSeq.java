/*
 Subsets II
Generate all subsequnces not contain duplicate subsequence 
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
import java.util.*;


class UniqueSubSeq
{
    public static void getSubSeq(int idx,int[] nums,List<List<Integer>> ans,List<Integer> temp)
    {
        for(int i=idx;i<nums.length;i++)
        {
            //if i greater than idx check with previous index element if they are equal no need to pick this element again because it will create duplicate subseq
            if(i>idx && nums[i]==nums[i-1])
            continue;
            
            //pick all possible starting element for current index in each recursive calls
            temp.add(nums[i]);
            ans.add(new ArrayList<>(temp));
            
            //go to the next index
            getSubSeq(i+1,nums,ans,temp);
            
            //to return back remove last inserted element from temp 
            temp.remove(temp.size()-1);
          
        }
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
   
         //sort array to compare number with previous one 
        Arrays.sort(arr);
      
        //create 2d arraylist to store all unique subsequences
         List<List<Integer>> list = new ArrayList<>();

          //create a temp list to store each subsequence
          List<Integer> temp = new ArrayList<>();
        
          //add blank subseq which is also part of subsequence
          list.add(new ArrayList<>());
          
        //call recursion mmethod for index 0
        getSubSeq(0,arr,list,temp);
        
        System.out.println(list);
       
          
    }
   

}