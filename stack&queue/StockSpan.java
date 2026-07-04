/*
Stock span problem


*/
import java.util.*;

class StockSpan
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        //create a stack which contained left next greater index
        //decreasing monotonic stack  
        Stack<Integer> st = new Stack<>();
        
        int[] res = new int[n];
        
        //traverse through array
        for(int i=0;i<n;i++)
        {
            //pop out elements from stack if current price greater than or equal to peek price 
            //to calculate span
            while(!st.isEmpty() && price[i] >= price[st.peek()])
            st.pop();
            
            //if stack empty no left element found greater than current element
            if(st.isEmpty())
            res[i] = i-(-1);
            else
            res[i] = i-st.peek();
            
            //current index push into stack
            st.push(i);
        }
        
        return res;
    }

     public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a  size of stocks");
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        System.out.println("Enter price of each stock");
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        sc.close();
        int ans[] = calculateSpan(arr,n);
        
        for(int i=0;i<ans.length;i++)
        System.out.print(ans[i]+" ");
      
    }
}