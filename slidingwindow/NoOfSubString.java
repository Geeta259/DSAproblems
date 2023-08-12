/*
 *   Number of Substrings Containing All Three Characters
Given a string s consisting only of characters a, b and c.
Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 */
import java.util.*;
class NoOfSubString
{
    public static int numberOfSubstrings(String s) {
        
        //use two pointer to count all subarray having atleast one a,b,c
        int i=0,j=0,valid=0,total=0;

        int ca=0,cb=0,cc=0;
        //outer loop 
        while(i<=j && j<s.length())
        {
            //get current character
            char ch = s.charAt(j);

            //increment count of respective character
            if(ch =='a') ca++;
            else if(ch =='b')cb++;
            else cc++;

            //if it valid substring 
              while(ca>=1 && cb>=1 && cc>=1)
            {
                //current substring is valid substring increment valid pointer
                valid++;
                //remove element from head until subarray becomes invalid
                //also decremenet respective character count
                if(s.charAt(i) == 'a')ca--;
                else if(s.charAt(i) == 'b')cb--;
                else cc--;

                //increment starting index
                i++;
            }

            //increment j index
            j++;

            //add all current valid substring till j  into total
            total+=valid; 
        } 

        //return total valid substring
        return total;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string which contain only a , b & c");
        String str = sc.nextLine();
        sc.close();
        
        int res =  numberOfSubstrings(str);
        System.out.println("Total no of subarray having contain atleast one a,b & c is " + res);

    }
}