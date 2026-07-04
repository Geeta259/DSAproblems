/*
Combination Sum
Given an array of integers and a sum B, find all unique combinations in the array where the sum is equal to B. 
The same number may be chosen from the array any number of times to make B.

elements should be in sorted order and not repeat combination
 */
import java.util.*;


class CombinationSum
{
    static void getSubSeq(int idx,ArrayList<Integer> arr,int total, ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> temp)
    {
        //if idx equal to length of array
        if(idx==arr.size())
        {
            //check total value if it is equal to 0 required subseq add into ans list and return
            if(total==0)
            ans.add(new ArrayList<>(temp));
          
            return ;
        }
      
       //check can we pick this element at idx 
        
        if(arr.get(idx)<=total)
        {
            //if this value less than or equal to total can pick this element add into data structure
                temp.add(arr.get(idx));
               //System.out.print(temp + " ");
               //call next recursion of same index
                getSubSeq(idx,arr,total-arr.get(idx),ans,temp);
                
                //after complete and back to this idx remove last element from data structure 
                temp.remove(temp.size()-1);
        }
        
        
        //go to the next index 
         getSubSeq(idx+1,arr,total,ans,temp);
     
    }

    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array");
        int n = sc.nextInt();
       
        System.out.println("Enter elements in to array");
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++)
        arr.add(sc.nextInt());

        System.out.println("Enter required sum of subsequence");
        int total = sc.nextInt(); 
        sc.close();
   
        Collections.sort(arr);
      
        //create 2d arraylist to store all required subsequences
          ArrayList<ArrayList<Integer>> list = new ArrayList<>();

          //create a temp list to store each subsequence
          ArrayList<Integer> temp = new ArrayList<>();
        
          //create arr list to store all unique element from given array
        ArrayList<Integer> uniquearr = new ArrayList<>();
        //remove duplicate element
        
        for(int i=0;i<arr.size();i++)
        {
            if(!uniquearr.contains(arr.get(i)))
            uniquearr.add(arr.get(i));
        }
        
        //call recursion mmethod for index 0
        getSubSeq(0,uniquearr,total,list,temp);
        
        System.out.println(list);
       
          
    }
   

}