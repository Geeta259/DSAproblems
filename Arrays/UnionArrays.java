import java.util.*;

class UnionArrays
{

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> arr = new ArrayList<>();
        int i=0,j=0;
        for(;i<n && j<m;)
        {
            while(i<n-1 && arr1[i]==arr1[i+1])  //get unique element index of first array
            i++;
            
            while(j<m-1 && arr2[j]==arr2[j+1])  //get unique element index of second array
            j++;
            
            
            //use two pointer approach to add element in a sorted order
            if(arr1[i]<arr2[j]) 
            {
               
                 arr.add(arr1[i]);
                  i++;
            }
            else if(arr1[i]>arr2[j])
            {
                
                arr.add(arr2[j]);
                
                j++;
            }
            else
            {
               
                arr.add(arr1[i]);
                
                i++;
                j++;
            }
        }
        
        while(i<n)  //if first array element left add unique element into list
        {
             while(i<n-1 && arr1[i]==arr1[i+1])
            i++;
            
           arr.add(arr1[i]);
           
           i++;
        }
        
        while(j<m) //if second array element left add unique element into list
        {
              while(j<m-1 && arr2[j]==arr2[j+1])
                j++;
                
             arr.add(arr2[j]);
             
             j++;
        }
        return arr; //return arraylist
    }


    public static void main(String ar[])
    {
        System.out.println("Enter size of first array");
        Scanner sc =new Scanner(System.in);
        int n1 = sc.nextInt();

       System.out.println("Enter sorted elements in a first array");
        int arr1[] = new int[n1];
        for(int i=0;i<n1;i++)
        arr1[i] = sc.nextInt();


        System.out.println("Enter size of second array");
        int n2 = sc.nextInt();

       System.out.println("Enter sorted elements in a second array");
        int arr2[] = new int[n2];
        for(int i=0;i<n2;i++)
        arr2[i] = sc.nextInt();

       
        sc.close();

        ArrayList<Integer> res = new ArrayList<>();
        res = findUnion(arr1,arr2,n1,n2);

        System.out.println("Union of two array is");
        for(int i=0;i<res.size();i++)
        System.out.print(res.get(i)+" ");
    }
}