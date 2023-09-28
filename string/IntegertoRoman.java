/*
Integer to Roman
 */
import java.util.*;
class IntegertoRoman
{
    public static String intToRoman(int num) {

        ///make a integer array and string array which store roman number and corresponding values
        int val[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String arr[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        //defined stringbuilder to  make a resultant string
        StringBuilder str = new StringBuilder();

        //traverse through value
        for(int i=0;i<val.length;i++)
        {
            //add roman string till givenn number not less than this value
            while(num>=val[i])
            {
                str.append(arr[i]);
                num-=val[i];
            }

            //check for next roman number
        }
        
        return str.toString();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number for convert into string");
        int n = sc.nextInt();
      
        sc.close();

        String str = intToRoman(n);
        System.out.println("Integer value of given roman number is " + str);
    }
}