/*
Fractional KnapsackGiven weights and values of N items, we need to put these items in a
 knapsack of capacity W to get the maximum total value in the knapsack.
*/

import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class FractionalKnapsack
{
    //Function to get the maximum total value in the knapsack.
    static double getMaxValue(int W, Item arr[], int n) 
    {
        //descending sort on the based of fraction value/weight give value of 1 weight
	
        Arrays.sort(arr, new Comparator<Item>(){
            	//get first fraction value/ weight 
				//value of 1 unit weight
            public int compare(Item a,Item b)
            {
                
				//if first value small than second value swap by return 1 
				//because we want pair in decreasing order
                double r1 = (double)(a.value)/(double)(a.weight);
                double r2 = (double)(b.value)/(double)(b.weight);
                
                if(r1 < r2)return 1;  //swap value
                else if(r1>r2)return -1; //no swap
                else return 0; //return 0
            }
        });
        
	//traverse through items now it  sort in decreasing order 
        int currweight = 0;
        double val=0.0;
        

        for(int i=0;i<n;i++)
        {
            //System.out.println(arr[i].value);
            //check can we get current weight or not 
            if(currweight + arr[i].weight <= W)
            {
                currweight+=arr[i].weight;
                val+=arr[i].value;
            }
            else
            {
                //if curr pair weight exceed than max weight 
					//get only remianing weight value
                int remainingweight = W - currweight;
                	//get value of remweight
					//find 1 unit weight of current pair then multiply by remaining weight
				
                val+=(double)arr[i].value / (double)arr[i].weight * (double)remainingweight;
                break;
            }
        }
        
        return val;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of pair");
        int n =  sc.nextInt();

        Item arr[] = new Item[n];
        System.out.println("Enter pair value");
        for(int i=0;i<n;i++)
        {
          Item it = new Item(sc.nextInt(),sc.nextInt());
          arr[i] = it;
        }

        System.out.println("Enter capacity of knapsack");
        int maxweight = sc.nextInt();

        double maxval = getMaxValue(maxweight,arr,n);
        System.out.println("Maximum value is " + maxval);
    }

}