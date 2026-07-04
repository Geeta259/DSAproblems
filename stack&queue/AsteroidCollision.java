/*
N = 3
asteroids[ ] = {3, 5, -3}
Output: {3, 5}
Explanation: The asteroid 5 and -3 collide resulting in 5. The 5 and 3 never collide.
For each asteroid, the absolute value represents its size, and the sign represents its direction 
(positive meaning right, negative meaning left). Each asteroid moves at the same speed.
Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. 
If both are of same size, both will explode. Two asteroids moving in the same direction will never meet.
*/
import java.util.*;

class AsteroidCollision
{
  
    public static int[] asteroidCollision(int N, int[] asteroids) {
        
        //create a stack to check smaller one than current element
        Stack<Integer> st = new Stack<>();
        
        //traverse through asteroids
        for(int i=0;i<N;i++)
        {
            //if stack is empty or current element is positive
            //no explode will done simply push into stack
            if(st.isEmpty() || asteroids[i] > 0)
            st.push(asteroids[i]);
            else
            {
                //current elemnt is negative 
                //loop until satck is not empty
                while(!st.isEmpty())
                {
                    //get top element of stack
                    int top = st.peek();
                      
                    //get absolute value of current element
                    int curr = Math.abs(asteroids[i]);
                  
                    //if peek element is negative and current element also negative no explode
                    //push into stack break it
                    if(top < 0)
                    {
                        st.push(asteroids[i]);
                        break;
                    }
                    //if current absolute value equal to top +ve element both will explode
                    else if(top == curr)
                    {
                        //pop out top element and break
                        st.pop();
                        break;
                    }
                    
                    else if(curr < top)
                    {
                        //current element will explode
                        break;
                    }
                    
                    else
                    {
                        //curr element graeter than top element
                        //peek element will explode
                        st.pop();
                        
                        //check if stack is empty or not
                        //if not empty move to next iteration
                        if(st.isEmpty())
                        {
                            //add current element into stack
                            st.push(asteroids[i]);
                            break;
                        }
                    }
                }
            }
            
        }
        
        //get stack size
        int size = st.size();
        //create resultant array
        int[] arr = new int[size];
        
        //fill element from right to left
        for(int i=size-1;i>=0;i--)
        arr[i] = st.pop();
        
        //return array
        return arr;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size");
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        System.out.println("Enter asteroids size");
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();

        sc.close();
        int[] res = asteroidCollision(n,arr);
        System.out.println("State of asteroids after collision");
        for(int i=0;i<res.length;i++)
        System.out.print(res[i]+" ");
    }
}