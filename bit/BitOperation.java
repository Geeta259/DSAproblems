import java.util.*;
class BitOperation
{
    public static void main(String args[])
    {
        int num,i;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number for bit manipulation");
        num = sc.nextInt();
        System.out.println("Enter a bit position which you want to manipulate");
        i = sc.nextInt();
        sc.close();

        //get ith bit by using and operation

        int getbit = (num & (1<<i-1))!=0?1:0;
        System.out.println(i +"th bit of given number is "+ getbit);

        //set ith bit if 0 make it 1 by bitwise or  operation
        num = (num | (1<<i-1));
        System.out.println("after set "+ i +"rd bit given number is "+ num);

         //clear ith bit if 1 make it 0
         num  = (num & ~(1<<i-1));
         System.out.println("after clear "+ i +"rd bit given number is "+ num);

         //to check even or odd only LSB check if it set odd if not  set even
         String  check = (num & 1)==0?"even":"odd";
        System.out.println("Given number is " + check);

        //check power of 2 or not
         String  pow = (num & num-1)==0?"yes":"no";
        System.out.println("Can show given number is power of 2 " + pow);
    }
}