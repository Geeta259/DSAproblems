/*
Median in a row-wise sorted Matrix
Given a row wise sorted matrix of size R*C where R and C are always odd, find the median of the matrix.
Input:
R = 3, C = 3
M = [[1, 3, 5], 
     [2, 6, 9], 
     [3, 6, 9]]
Output: 5
Explanation: Sorting matrix elements gives 
us {1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 

Constraints:
1 <= R, C <= 400
1 <= matrix[i][j] <= 2000

Approach:

1) As we know that middle elements is between 1 to 2000 (included) based on constraints
2) search space is low =1 to high =2000 find middle element
3) count no of elements which is less than or equal to middle (row wise count no of element 

for each row count again use binary search to count no of element less than or equal to middle because row is sorted

if total count of element in an array is less than or equal to (n*m/2 index)(middle element index) go to right side 
because we want to increment count because middle element lie (n*m/2 index) so count greater than this

if total count greater than (n*m/2 index) have to minimize count to find middle element go to left side

at last low pointer indicate the middle element of the array.
)


*/
import java.util.*;

class FindMedianRowWiseSorted
{
        public static int findCount(int arr[],int k)
        {
            int low=0,high=arr.length-1;
            //check how many elements in a row is less than or equal to k
            
            while(low<=high)
            {
                int mid = (low+high)/2;
                if(arr[mid]<=k)
                //go to right side
                low= mid+1;
                else
                high = mid-1;
            }
            
            //at last low pointer point which index is  no of elements which is less than k
            
            return low;
        }
        public static int median(int matrix[][], int R, int C) {
            // code here     
            
            //defined search space middle element is 1 to 2000
            int low=1,high=2000;
            while(low<=high)
            {
                int mid = (low+high)/2;
                int count=0;
                
                for(int i=0;i<R;i++)
                {
                    //check how many elements less than or equal to mid in array
                    //row wise search 
                    count+=findCount(matrix[i],mid);
                    
                }
                
                if(count<=(R*C)/2)
                //go to right side
                low=mid+1;
                
                else
                //go to left side
                high=mid-1;
                
            }
            
            return low;
        }
    

    public static void main(String ar[])
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter size of row of matrix");
        int row = sc.nextInt();

        System.out.println("Enter size of column of matrix");
        int col = sc.nextInt();
        
        int matrix[][]= new int[row][col];
       System.out.println("Enter elements in a matrix range lies from  1 to 2000");
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            matrix[i][j] = sc.nextInt();
        }
       
        sc.close();

        int mid = median(matrix,row,col); 
        System.out.println("Middle element in a matrix is if it will arrange in non decreasing order is \n" + mid);

    }
}