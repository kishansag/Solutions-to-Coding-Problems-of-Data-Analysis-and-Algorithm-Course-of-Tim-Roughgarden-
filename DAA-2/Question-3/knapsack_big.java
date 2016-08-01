package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



class Knapsack{
    public int value;
    public int weight;
    
    public Knapsack(int v, int w){
        this.value = v;
        this.weight = w;
    }
    
    @Override
    public String toString(){
        return value+" "+weight;
    }
    public static void main(String args[]) throws FileNotFoundException{
        
        Scanner scan = new Scanner(new File("C:\\Users\\Kishan Sagathiya\\Downloads\\1. Study\\DSA Stanford Practice\\knapsack_big.txt"));
        int knapsackSize = scan.nextInt();
        int numberOfItems = scan.nextInt();
        System.out.println("knapsackSize "+knapsackSize+"\nnumberOfItems "+numberOfItems);

        List<Knapsack> items = new ArrayList<>(); 
        
        while(scan.hasNext()){
            int v = scan.nextInt();
            int w = scan.nextInt();
            Knapsack temp = new Knapsack(v, w);
  //          System.out.println(temp);
            items.add(temp);    
        }
        for(int i=0;i<items.size();i++){
        //    System.out.println(i+" "+items.get(i));
        }
        
        //System.out.println(items.get(0).value);
        //HashMap<String, Integer> solutions = new HashMap<>();
        //int solution[][] = new int[numberOfItems][knapsackSize+1];
        
        //System.out.println(optimalSolution(items,numberOfItems, knapsackSize, solutions ));
        
        optimalSolution2(items, numberOfItems-1, knapsackSize);
    }
    
    public static int optimalSolution2(List<Knapsack> items, int lastIndex, int maxW ){
        int current[] = new int[maxW+1]; 
        int previous[] = new int[maxW+1];
        
        for(int i = 0;i<lastIndex+1;i++){
            System.out.println(i+"\n");
            for(int currMaxW = 1;currMaxW<maxW+1;currMaxW++){
                if(items.get(i).weight>currMaxW){
                    current[currMaxW] =  previous[currMaxW];
                }
                else{
                    int temp = previous[currMaxW-items.get(i).weight] + items.get(i).value;
                    if(previous[currMaxW]>temp)
                        current[currMaxW] =  previous[currMaxW];
                    else
                        current[currMaxW] =  temp;
                }
                
               // System.out.println(current[currMaxW]);
            }
            
            //System.out.println(Arrays.toString(current)+"\n");
            System.arraycopy(current, 0, previous, 0, maxW+1);
        }
        
        System.out.println("Answer: " + previous[maxW]);
        
        return previous[maxW];
    }
    
}
