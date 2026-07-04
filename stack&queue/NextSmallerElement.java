/*
Next Smaller ElementInput: 
N = 4, arr[] = [1 3 2 4]
Output:
-1 2 -1 -1
*/
import java.util.*;

class NextSmallerElement
{
   public static int[] nextSmaller(int arr[],int n)
   {
        //stack to stored next smallest element
        Stack<Integer> st = new Stack<>();
        
        //traverse through array from right to left
        for(int i=n-1;i>=0;i--)
        {
            //pop  out elements which is not smaller than current element
            int curr = arr[i];
            while(!st.isEmpty() && st.peek() >= curr)
            st.pop();
            
            //check stack is empty or not
            //if not no smaller element  present right side
            //if stack not empty means smalles element present get peek value
            if(st.isEmpty())
            arr[i] = -1;
            else
            arr[i] = st.peek();
            
            //push current element into stack
            st.push(curr);
        }

        return arr;
   }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of array");
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        sc.close();
        arr = nextSmaller(arr,n);
        for(int i=0;i<n;i++)
        System.out.print(arr[i] + " ");
    }
}