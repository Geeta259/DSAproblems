/*
String to Integer (atoi)
Input: s = "42"
Output: 42

Input: s = "4193 with words"
Output: 4193

 */
import java.util.*;
class StringToInteger
{
    public static int myAtoi(String s) {

        //create a double variable ans can be large than integer
        double ans=0;

        int n = s.length();

        //check sign of number
        char sign='+';

        int i=0;

        //if at beginning of string contain white spaces continue till get another character
        while(i<n && s.charAt(i)==' ')
        i++;

        //if first character found as '-' sign varible store - 
        if(i<n && s.charAt(i)=='-')
        {
            sign='-';
            i++;
        }
          //if first character found as '+' sign varible store +
        else if(i<n && s.charAt(i)=='+')
        {
            sign='+';
            i++;
        }
                 
            while(i<n)
            {      
              
                //if character at index i lies between 0 to 9 can convert into string
                if(s.charAt(i)>='0' && s.charAt(i)<='9')
                {
                    // character value  minus with '0' character get integer value  
                    int num = s.charAt(i)-'0';
                    
                //System.out.println(n);

                    //store into ans variable 
                    ans=ans*10+num;
                    //System.out.println(ans);
                    i++;
                }else
                {
                    //if found any other character which not lies btw 0 to 9 break from loop
                    break;
                }
                

            }

    
            //update ans by sign value
 
        if(sign=='-')
        ans*=-1;

        //check computed ans greater integer max bound ans store integer max value

        ans = ans>Integer.MAX_VALUE?Integer.MAX_VALUE:ans;

        //check computed ans less  integer min bound ans store integer min value
        ans = ans<Integer.MIN_VALUE?Integer.MIN_VALUE:ans;

        //return ans by convert into integer
        return (int)ans;
    }


    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to convert into integer value");
        String s = sc.nextLine();
      
        sc.close();

        int res = myAtoi(s);
        System.out.println("Integer value from string is  " + res);
    }
}