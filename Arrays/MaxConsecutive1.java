import java.util.*;

class MaxConsecutive1
{

    public static int maxConsecutiveOnes(int N) {
        
        // Your code here
        int count=0,max=-1;
        while(N>0)  
        {
            if(N%2==1)  //check remainder is 1 or 0 in a sequence if 1 count increment
            count++;
            else
            {
                if(count>max)   //if 0 check no of consecutive 1's is greater than max consecutive if it is update count by max
                max=count;
                
                count=0;  //set count 0 for next consecutive 1's
            }
            
            N=N/2;  //update N value by divide 2 
        }
        
        if(count>max) //at last consective 1's also check it is greater than max consecutive if it is update by max value
        max=count;
        
        return max; //return max consecutive value
    }
    

    public static void main(String ar[])
    {
        System.out.println("Enter a any number");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
       
        sc.close();

        int res = maxConsecutiveOnes(n);
        System.out.println("longest consecutive set bits of length is  "+res);
        
    }
}