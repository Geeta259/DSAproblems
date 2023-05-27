/*
 * Find the Difference of Two Arrays
 * Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
Output: [[3],[]]
Explanation:
For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
Every integer in nums2 is present in nums1. Therefore, answer[1] = [].


Approach :
1) Declare two list one list for first array elements which is not present in second array
2) second list contain second array elements which is not present in first array
3)Sort both array 
4) compare both array elements one by one if they are equal increment both pointer by one
5) if they are not equal compare with previous elements same elements are not if not then only add into list because we want unique elements also in a list

*/

import java.util.*;

class DiffTwoArr
{

    public static void findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
         List<Integer> li1 = new ArrayList<Integer>();
         List<Integer> li2 = new ArrayList<Integer>();

        int i=0,j=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]==nums2[j])
            {
                i++;
                j++;
                continue;
            }
            else if(nums1[i]<nums2[j])
            {
                if(i==0 || nums1[i]!=nums1[i-1])
                li1.add(nums1[i]);

                i++;
            }else
            {
                if(j==0 || nums2[j]!=nums2[j-1])
                li2.add(nums2[j]);

                j++;
            }
        }

        while(i<nums1.length)
        {
             if(i==0 || nums1[i]!=nums1[i-1])
                li1.add(nums1[i]);

                i++;
        }

        while(j<nums2.length)
        {
            if(j==0 || nums2[j]!=nums2[j-1])
                li2.add(nums2[j]);

                j++;
        }

        list.add(li1);
        list.add(li2);

        //iterate over 2d list
        System.out.println("[");

        for(List<Integer> li : list)
        {
            System.out.print("[");

            for(Integer item : li)
            {
                System.out.print(" " + item +" ,");
            }

            System.out.println(" ]");

        }

        System.out.println(" ] ");

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
       
        findDifference(arr1,arr2);
        
    }
}