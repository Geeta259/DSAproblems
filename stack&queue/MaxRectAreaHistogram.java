/*
Maximum Rectangular Area in a Histogram

Find the largest rectangular area possible in a given histogram where the largest rectangle
 can be made of a number of contiguous bars. For simplicity, assume that all bars have the
  same width and the width is 1 unit,
 there will be N bars height of each bar will be given by the array arr.
*/
import java.util.*;

class MaxRectAreaHistogram
{
    public static int RectangleArea(int[] heights) {
        
        //create a stack
        Stack<Integer> st = new Stack<>();

        int n = heights.length;

        int ans = Integer.MIN_VALUE;

        //traverse through arary upto n
        for(int i=0;i<=n;i++)
        {
            //pop  out element from stack until stack is not empty
            //ans index reach upto n or current value is smaller than peek value 
            while(!st.isEmpty() && (i==n || heights[i] <= heights[st.peek()]))
            {
                //get height of pop out index
                int height = heights[st.pop()];

                int width;
                //after pop out peek element stack empty means it can expand upto i index 
                if(st.isEmpty())
                width = i;
                //if stack not empty 
                //right boundary i-1 - left smallest which now donated by current peek index in stack
                else
                width = i-st.peek()-1;

                //get amx value of area
                ans = Math.max(ans,height*width);
            }

            //push current index into stack
            st.push(i);
        }

        //return ans
        return ans;
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a  no of histogram");
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        System.out.println("Enter height of each histogram");
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        sc.close();
        int area = RectangleArea(arr);
        System.out.println("Largest area of histogram is " + area);
      
    }
}