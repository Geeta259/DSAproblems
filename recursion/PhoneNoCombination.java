/*
. Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, return all possible letter combinations 
that the number could represent
. Return the answer in any order.

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
import java.util.*;


class PhoneNoCombination
{
    //global declared mapping string and resultant string 
    static String phone[];
    static List<String> res; 

    public static void dfs(int idx,String digits,StringBuilder temp)
    {
        //base or terminate condition
        if(idx==digits.length())
        {
            //check temp contains any string or not if conatins add into resultant string
            if(temp.length()!=0)
            res.add(temp.toString());

            return;
        }

        //get mapping string from phone for given index
        String str = phone[digits.charAt(idx)-'0'];
        for(char ch : str.toCharArray())
        {
            //add current character to temp
            temp.append(ch);

            //get next index character 
            dfs(idx+1,digits,temp);

            //after return back remove last element from temp
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
       
        System.out.println("Enter string of phone number from 2 to 9");
        String str = sc.nextLine();
        sc.close();
   
          phone = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        res = new ArrayList<>();

        dfs(0,str,new StringBuilder());
     
        System.out.println("All possible words by pressing the given numbers");
        System.out.println(res);
       
    }
}