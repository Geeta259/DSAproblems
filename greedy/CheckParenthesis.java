/*
Valid Parenthesis String

*/

import java.util.*;
class CheckParenthesis
{
    public static boolean checkValidString(String s) {
        //open stack needed  to  store open bracket index
     Stack<Integer> open = new  Stack<>();
     //close stack  needed to  store  close bracket  index
     Stack<Integer> astrk = new  Stack<>();


     for(int i=0;i<s.length();i++)
     {
        //if  it is  open bracket  push into  open stack
        if(s.charAt(i)=='(')
        open.push(i);

        else if(s.charAt(i)==')')
        {
            //if it  is  close  bracket 
            if(!open.isEmpty()) //check any open  bracket is present or not  if  yes pop  out from  stack
            open.pop();

            //if no check any  astrk present  till  index i  or  not   to convert into  open  
            else if(!astrk.isEmpty()) 
            astrk.pop(); //astrk pop to support close bracket if yes,pop out

            else return false; //neither open nor  astrk till  index i to support close bracket return  false
        }
        else //if  astrk  push index 
        astrk.push(i);

     }

        //check open stack  empty or not  if not  
      while(!open.isEmpty() && !astrk.isEmpty())  //check astrk stack
      {
         if(astrk.peek() > open.peek()) //after open bracket  astrk needed not  before to  convert  into  close  
         { open.pop(); astrk.pop(); } //if astrk present after  open index  can convert into  close pop  out  both  
         else
         break;
      }        

        //if open sttack empty parenthesis balanced 
      if(open.isEmpty())return true;
      return false; //otherwise return false
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string which contain only '(',')','*' ");
        String  s = sc.next();

        boolean ans = checkValidString(s);
       System.out.println("Can convert into  valid  parenthesis string ? " + ans);

    }

}