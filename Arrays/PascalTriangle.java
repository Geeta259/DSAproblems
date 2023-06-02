
/*
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * //to get particular row element from pascal traingle is
 * considering rows 1 ,2 to n 
 * to get first column value always 1
 * start columns from 1 to row-1 
 * and find current elements  use previous element * (row-col ) then divide by column index to get current element
 * this pattern give all elements of particular row it is optimal approach
 */

import java.util.*;

class PascalTriangle
{
    public static List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
          List<Integer> li ,pre= null;

       for(int i=0;i<numRows;i++)
        {
             li=new ArrayList<Integer>();
              for(int j=0;j<=i;j++)
            {
                if(j==0 || j==i) // first column or last column 
                li.add(1);

                else
                 li.add(pre.get(j-1) + pre.get(j));
            }

            pre=li;
            list.add(li);
        }

        return list;
    }

    public static List<Integer> getRow(int row) {

        List<Integer> list = new ArrayList<Integer>();
        long elem=1;
        list.add(1);

        for(int col=1;col<row;col++)
        {
            elem = elem * (row-col);
            elem = elem/col;

            list.add((int)elem);
        }

        return list;
        
    }

    public static void main(String ar[])
    {
        System.out.println("Enter no of rows of a pascal traingle");
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

   
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list = generate(n);

        System.out.println(list);

        System.out.println("Enter row no which you want from a pascal traingle");
        int row = sc.nextInt();

        
        
        sc.close();


        List<Integer> rowelem = new ArrayList<Integer>();
        rowelem = getRow(row);

        System.out.println("Elements of "+ row + " row is " );
        System.out.println(rowelem);
      
        
    }
}