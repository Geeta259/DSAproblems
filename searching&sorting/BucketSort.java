import java.util.*;
class BucketSort
{
    public static void insertionSort(ArrayList<Double> bucket)
    {
        int n = bucket.size();
        for(int i=1;i<n;i++)
        {
            double key = bucket.get(i);
            int j=i-1;
            while(j>=0 && bucket.get(j) > key)
            {
                //insert j value at current index
                bucket.set(j+1,bucket.get(j));
                j--;
            }
            bucket.set(j+1,key);
        }
    }

    public static void bucketSort(int n,double arr[])
    {
        //create an arraylist of arraylist 2d arraylist
        ArrayList<ArrayList<Double>> buckets = new ArrayList<>();

        //intialize 2d arraylist
        for(int i=0;i<n;i++)
        buckets.add(i,new ArrayList<>());

        //place elements into list according to index values
        for(int i=0;i<n;i++)
        {
            int idx = (int)arr[i]*n;
            buckets.get(idx).add(arr[i]);
        }

        //sort individual bucket 
        for(int i=0;i<n;i++)
        {
            insertionSort(buckets.get(i));
        }

        //concatenation sorted bucket back into original array
        int idx=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<buckets.get(i).size();j++)
            {
                arr[idx++] = buckets.get(i).get(j);
            }

        }
    }
    public static void main(String ar[])
    {
        System.out.println("Enter size of array");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

       System.out.println("Enter elements in an array");
        double arr[] = new double[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.nextDouble();

        sc.close();

        bucketSort(n,arr);

        System.out.println("After sorting elements in an array is");
        for(int i=0;i<n;i++)
        System.out.print(arr[i]+" ");
    }
}