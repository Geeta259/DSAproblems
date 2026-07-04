/*
 Palindrome Partitioning
Given a string s, partition s such that every 
substring of the partition is a palindrome
. Return all possible palindrome partitioning of s.
 */
import java.util.*;


class PalinPartitioning
{
    public static boolean isPalin(String s , int start,int end)
    {
        while(start<=end)
        {
            if(s.charAt(start)!=s.charAt(end))
            return false;

            start++;
            end--;
        }

        return true;
    }
    public static void getAllPalin(String s,int idx,List<List<String>> list,List<String>temp)
    {
        //base condition
        if(idx==s.length())
        {
            //after last index add possible palin in to list and return back
            list.add(new ArrayList<>(temp));
            return;
        }
        
        //can partition from 0 to length
        for(int i=idx;i<s.length();i++)
        {
            //check if from idx to i is a palin or not
            if(isPalin(s,idx,i))
            {
                //if it is palin add this palin string in temp
                temp.add(s.substring(idx,i+1));

                //check for remaining string after i
                getAllPalin(s,i+1,list,temp);

                //after return back remove last string from temp
                temp.remove(temp.size()-1);
            }
        }
              
    }

    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
       
        System.out.println("Enter a  string");
        String str = sc.nextLine();
        sc.close();
   
        List<List<String>> list = new ArrayList<>();
        getAllPalin(str,0,list,new ArrayList<String>());

        System.out.println("All possible palindrome in a string is");
        System.out.println(list);
       
    }
}