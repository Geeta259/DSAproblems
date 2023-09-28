/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Roman to Integer

Approach

start from end of the roman string
if current index value small next index value integer value subtract 
otherwise add into  integer value
 */
import java.util.*;
class RomanToInteger
{
    public static int romanToInt(String s) {
        

        ///map defined to store key value pair
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        
        //map store key and their value
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        //start from ending
        int n  = s.length();

        //current result value store value of last roman symbol
        int result=map.get(s.charAt(n-1));
        
        for(int i=s.length()-2;i>=0;i--)
        {
             //check condition if current symbol value less than next symbol value 
             //value of integer decrement current symbol value from result
            if(map.get(s.charAt(i))<map.get(s.charAt(i+1)))
            result-=map.get(s.charAt(i));

            //result add current symbol value 
            else
            result+=map.get(s.charAt(i));
            
           // System.out.println(result);
            
        }

        return result;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a roman string for convert into integer");
        String  str = sc.nextLine();
      
        sc.close();

        int num = romanToInt(str);
        System.out.println("Integer value of given roman number is " + num);
    }
}