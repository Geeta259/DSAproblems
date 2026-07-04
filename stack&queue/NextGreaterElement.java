/*
Next Greater ElementInput: 
N = 4, arr[] = [1 3 2 4]
Output:
3 4 4 -1
*/
import java.util.*;

class NextGreaterElement

{
   //Function to find the next greater element for each element of the array.
   public static long[] nextLargerElement(long[] arr, int n)
   { 
       //create a stack which consist elements greater than current
       Stack<Long> st = new Stack<>();
       
       //traverse from end of the list
       for(int i=n-1;i>=0;i--)
       {
           //check top of stack is greater or not
           if(st.isEmpty())
           {
               //add current element into stack
               st.push(arr[i]);
               
               //nothing greater than current element found in right side
               arr[i] = -1;
           }
           
           //if it not empty check peek value greater or not 
           else if(st.peek() > arr[i])
           {
               //if peek value greater than current element
               long top = st.peek();    
               //push current element into stack
               st.push(arr[i]);
               
               //update current cell by next greater which is top
               arr[i] = top;
           }
           
           else
           {
               //if peek value smaller or equal than current element
               //pop out smallest element than current element
               while(!st.isEmpty() && st.peek() <= arr[i])
               st.pop();
               
               if(st.isEmpty())
               {
                   //not found next greater element than current element
                   //push current element 
                   st.push(arr[i]);
                   
                   //update current index by -1
                   arr[i] = -1;
               }
               else
               {
                   //found next greater element 
                   long top = st.peek();
                   //current element push into stack
                   st.push(arr[i]);
                   //update current index by next greater element
                   arr[i] = top;
               }
           }
           
       }
       
       return arr;
   } 

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of array");
        int n = sc.nextInt();
        
        long arr[] = new long[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        sc.close();
        arr = nextLargerElement(arr,n);
        for(int i=0;i<n;i++)
        System.out.print(arr[i] + " ");
    }
}