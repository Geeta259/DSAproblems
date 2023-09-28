/*
Sort Characters By Frequency
Given a string s, sort it in decreasing order based on the frequency of the characters. T
he frequency of a character is the number of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them.

 Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 */
import java.util.*;
class FrequencySort
{
  
    public static String frequencySort(String s) {

        //first create a map to store frequency of each charcter in a string
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();

        for(int i=0;i<s.length();i++)
        map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);

        //create a priority queue which compare two character by their frequency
        //which is stored in a map and add highest frequency character in first place

        PriorityQueue<Character> pq = new PriorityQueue<>((x,y)->map.get(y)-map.get(x));

        //traverse map get their key (character) and store priority queue which add character according to their frequency value

        for(char c : map.keySet())
        pq.offer(c);

        //create a new string 
        StringBuilder ans = new StringBuilder();

        //traverse through priorityqueue
        while(!pq.isEmpty())
        {
            //poll from priorityqueue first character remove
            char ch = pq.poll();

            //get their frequency from map and append into resulatant string as many times .
            for(int i=1;i<=map.get(ch);i++)
            ans.append(ch);
        }

        //return resultant string
        return ans.toString();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String  str = sc.nextLine();
      
        sc.close();

        String ans = frequencySort(str);
        System.out.println("Sort character by frequency actual string becomes " + ans);
    }
}