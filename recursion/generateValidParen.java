/*

Given an integer N representing the number of pairs of parentheses, the task is to 
generate all combinations of well-formed(balanced) parentheses.

Input:
N = 3
Output:
((()))
(()())
(())()
()(())
()()()
 */
import java.util.*;


class generateValidParen
{
    public static void validParen(List<String> res, int n , int i, String str)
    {
        if(str.length()==2*n)
        {
            res.add(str);
            return;
        }

        //max open brackets add into string 
        if(i==n)
        {
            //only possibility ')' add close brackets into string
            validParen(res,n,i,str+=')');
        }
        //if open brackets less or equal to close brackets
        else if(i<=str.length()-i)
        {
           //only possibility '(' add open brackets
             validParen(res,n,i+1,str+='(');
        }
        else
        {
            //if open brackets greater than close brackets and not reached max no 
            //two possibilities either can add '(' or ')' into string simultaneously
            String temp = str;
            validParen(res,n,i+1,str+='(');
            str = temp;
             validParen(res,n,i,str+=')');
        }
    }
    
    public static void main(String ar[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of digit of valid parenthesis formed");
        int n = sc.nextInt();
       
        sc.close();
        List<String> list = new ArrayList<>();
        
        //generate all valid parenthesis always start from open brackets 
        validParen(list,n,1,"(");

        System.out.println("All possible valid Parenthesis is");
        System.out.println(list);
    }
   

}