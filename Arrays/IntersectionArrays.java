import java.util.*;

class IntersectionArrays
{

    public static ArrayList<Integer> findIntersection(int a[], int b[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        
       
        for(int i=0,j=0; i<n && j<m;)
        {
            while(i<n-1 && a[i]==a[i+1]) //get unique elemnt index of first array in a order duplicate element not count
            i++;
            
            while(j<m-1 && b[j]==b[j+1]) ///get unique elemnt index of second array in a order duplicate element not count
            j++;
            
            //use two pointer approach to add common element
            if(a[i]==b[j])
            {
                arr.add(a[i]);
                i++;j++;
            }
            else if(a[i]<b[j])
            i++;
            else
            j++;
        }
        
      
        return arr; //return arraylist
    }


    public static void main(String ar[])
    {
        System.out.println("Enter size of first array");
        Scanner sc =new Scanner(System.in);
        int n1 = sc.nextInt();

       System.out.println("Enter elements in a first array");
        int arr1[] = new int[n1];
        for(int i=0;i<n1;i++)
        arr1[i] = sc.nextInt();


        System.out.println("Enter size of second array");
        int n2 = sc.nextInt();

       System.out.println("Enter elements in a second array");
        int arr2[] = new int[n2];
        for(int i=0;i<n2;i++)
        arr2[i] = sc.nextInt();

       
        sc.close();

        ArrayList<Integer> res = new ArrayList<>();
        res = findIntersection(arr1,arr2,n1,n2);

        System.out.println("Intersection of two array is");
        for(int i=0;i<res.size();i++)
        System.out.print(res.get(i)+" ");
    }
}