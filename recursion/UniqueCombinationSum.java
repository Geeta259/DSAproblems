/*
Combination Sum II
Generate all subsequnces with sum  not contain duplicate subsequence 
subsequence store in sorted way

Input:  candidates = [10,1,2,7,6,1,5], target = 8. 
Output:  [[1,1,6], [1,2,5], [1,7], [2,6]]. 
 */
import java.util.*;


class UniqueCombinationSum
{
    public static void getCombination(int idx,int[] a, int target,  List<List<Integer>> list,   List<Integer> temp)
    {
        //if target becomes 0 get required subsequences add into list and return back
            if(target==0)
            {
                list.add(new ArrayList<>(temp));
                return;
            }
    
      for(int i= idx ; i< a.length ; i++)
        {
            //pick all possible elements from idx to length , if it is already picked in current position no need to pick it again 
            //simulatneously check i-1 and i value if both are equal no need to pick it just continue
            if(i>idx && a[i]==a[i-1])
            continue;
            
            //if current element which you want to pick in current posiiton if it is  greater than target break from loop
            //no need to continue because elements are in sorted order 
            //not valid subsequence
            if(a[i] > target)
            break;
            
            //if above any condition not true  we can pick that element in current position and recursively call for pick possible elements in next position 
            temp.add(a[i]);
            getCombination(i+1,a,target-a[i],list,temp);

            //if came back remove last added value from temp
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

        System.out.println("Enter required sum of subsequence");
        int total = sc.nextInt(); 
        sc.close();
   
        Arrays.sort(arr);
      
        //create 2d arraylist to store all required subsequences
         List<List<Integer>> list = new ArrayList<>();

          //create a temp list to store each subsequence
          List<Integer> temp = new ArrayList<>();
        
        //call recursion mmethod for index 0
        getCombination(0,arr,total,list,temp);
        
        System.out.println(list);
       
          
    }
   

}