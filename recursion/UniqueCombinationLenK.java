/*
 Combination Sum III
 Only number 1 through 9 are used.
Each number is used atmost once.
Find all valid combinations of K digit numbers that sum upto to N 

Input:
K = 3
N = 7
Output: { {1, 2, 4} }
 */
import java.util.*;


class UniqueCombinationLenK
{
    public static void getSubSeq(int num,int idx,int digit,int target,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> temp)
    {
        //base condition
       //check get equal no of digits  if we get
        if(idx>digit)
        {
            //check target value if it becomes zero get required subsequence add into list
            if(target==0)
            res.add(new ArrayList<>(temp));
            
            //return back
            return;
        }
        
        
        //possible combination from num to 9 to pick starting element
        for(int i=num;i<=9;i++)
        {
            //if current number greater than target no need to continue break from loop
            if(i>target)
            break;
            
            //otherwise pick current element
            temp.add(i);
            //check for next digit possible combinations from i+1 to 9 
            //subtract added number from target 
             getSubSeq(i+1,idx+1,digit,target-i,res,temp);

             //after return back remove last added numbers from temp
             temp.remove(temp.size()-1);
           
        }
    }

    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of digit of subsequence");
        int digit = sc.nextInt();
       
        System.out.println("Enter sum of subsequence");
        int target = sc.nextInt();
        sc.close();
   
        //store all combination of subsequence of length k
        ArrayList<ArrayList<Integer>> res = new  ArrayList<ArrayList<Integer>>();

        //check all possible subsequence
         ArrayList<Integer> temp = new  ArrayList<>();
           
         //start from 1 number
         getSubSeq(1,1,digit,target,res,temp);     
      
         System.out.println(res);
       
          
    }
   

}