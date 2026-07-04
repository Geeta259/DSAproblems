import java.util.*;

class MaxPriQueue{

	//defined max priority queue using lambda expression
	public static PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
	// Function to perform push operation
	public static void push(int data) {

		// Write the code here.
		pq.add(data);
	}

	// Function to pop operation
	public static void pop() {

		// Write the code here.
		pq.poll();
	}

	public static int getMaxElement() {

		// Write the code here.
		if(pq.isEmpty())
		return -1;

		return pq.peek();
	}

	public static boolean isempty() {

		// Write the code here.
		if(pq.isEmpty())
		return true;
		else
		return false;
	}

    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice what you want to perform in stack");
      
        int opt=0;
        do
        {
              System.out.println("1 for push\n2 for pop\n3 for get maximum element \n4 for check empty or not");
             int ch = sc.nextInt();
            switch(ch)
             {
                    case 1:
                    {
                        System.out.println("Enter element which you want to  push in max priority queue");
                        int num = sc.nextInt();
                        push(num);
                        break;
                    }
                    case 2:
                    pop();
                    break;

                    case 3:
                    System.out.println("Maximum element is " + getMaxElement());
                    break;

                    case 4:
                    {
                        if(isempty())
                        System.out.println("Priority Queue is empty");
                        else 
                        System.out.println("Priority Queue is not empty");

                        break;
                    }
                    default:
                    System.out.println("Invalid choice");
                    break;
                }

                System.out.println("Want to continue? if no press -1 else press any");
                opt = sc.nextInt();

        }while(opt!=-1);
      
        sc.close();
    }
}
