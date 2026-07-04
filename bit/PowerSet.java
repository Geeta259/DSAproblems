import java.util.*;

class PowerSet
{
    public static List<String> AllPossibleStrings(String s)
    {
        //total subsequences of n length string is 2^n-1
        
        double total = Math.pow(2,s.length())-1;
        
        String str="";
        
        //to store all possible subsequences
        List<String> list = new ArrayList<>();
        
        //outer loop from 0 to total
        for(int i=0;i<=total;i++)
        {
            str="";
            //get binary value of ith number of length n
           for(int j=0;j<s.length();j++)
            {
               //check bit is set of j index or not
                //if jth bit is set add character of jth index into result string
                if((i & (1<<j)) !=0)
                str+=s.charAt(j);
            }
            
            if(!str.equals(""))
            list.add(str);
            
        }
        
        //return list of lexographical order by sort it
        Collections.sort(list);
        return list;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();

        sc.close();
        List<String> list = new ArrayList<String>();
        list = AllPossibleStrings(str);

        System.out.println("All the possible subsequences of the String in lexicographically-sorted order is");
        System.out.println(list);

    }
}