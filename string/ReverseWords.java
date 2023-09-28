/*
 *Reverse words in a given string
 Given a String S, reverse the string without reversing its individual words. Words are separated by dots.

 Input:
S = i.like.this.program.very.much
Output: much.very.program.this.like.i

 */
import java.util.*;
class ReverseWords{

   /*  public static String reverseWords(String S)
    {
        // code here 
        //split all words by . and store into char array
        String str[] = S.split("[.]");
        String temp="";
        int i=0,j=str.length-1;
        
        while(i<=j)
        {
            //after storing into character array reverse the array using two pointer
            temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            
   
            i++;
            j--;
        }
        
        //append reverse string into string by . 
        StringBuilder sb = new StringBuilder();
        for(int k=0;k<str.length;k++)
        {
            sb.append(str[k]);
            if(k!=str.length-1)
            sb.append('.');
        }
        
        //return modified string
        return sb.toString();
    }
        */

        //second way without take any extra space

    public static String reverseWords(String s)
      {
        String ans="",temp="";
        //trim extra white spaces
        s=s.replaceAll("\\s+"," ").trim();

       int i=0,j=s.length()-1;
       while(i<=j)
       {
            //traverse through string
            //if blank space encountered check answer stored anything previous or not
           if(s.charAt(i)==' ')
           {
               //if answer not stored anything first word temp store to a ans
               if(ans=="")
               ans=temp;
               else
               {
                   //already some words add into a ans temp concat to a ans new word just add previous to stored string in ans
                   ans=temp+" "+ans;
               }
               temp="";
           }else
           temp+=s.charAt(i);

           i++;
       }

        //if only one word in given string that is answer else concat previous to ans string
       if(ans=="")
       ans=temp;
       else
       ans=temp+" "+ans;

       return ans;
    }


    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s = new String();
        System.out.println("Enter a sentence separated by dot");
        s = sc.nextLine();

       // System.out.println(s);

        sc.close();

        String ans = reverseWords(s);
        System.out.println("String after reverse words is "+ ans);
    }
}