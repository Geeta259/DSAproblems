/*
Next Greater Element in circular array 
Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
*/
import java.util.*;

class NextGreaterElementInCircularArray

{
    public static int[] nextGreaterElements(int[] nums) {
        int n =nums.length;
        //create resultant array which contain next greater element
        int res[] = new int[n];

        //create a stack which hold greater element than current element
        Stack<Integer> st = new Stack<>();

        //traverse from 2*n-1 to 0 right to left
        //because it is circular array start from 2*n-1 index to 0

        for(int i=2*n-1;i>=0;i--)
        {
            //take modulus not go  out of bounds from n size array
            int curr = nums[i%n];

            //pop out all the element from the peek which is not greater than current element
            while(!st.isEmpty() && st.peek()<=curr)
            st.pop();

            //check if stack is empty means no next greater element found 
            //else put peek element in res array
            if(st.isEmpty())
            res[i%n] = -1;
            else
            res[i%n] = st.peek();

            //push current element into stack
            st.push(curr);
        } 

        //return resultant array
        return res;  
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
        arr = nextGreaterElements(arr);
        for(int i=0;i<n;i++)
        System.out.print(arr[i] + " ");
    }
}