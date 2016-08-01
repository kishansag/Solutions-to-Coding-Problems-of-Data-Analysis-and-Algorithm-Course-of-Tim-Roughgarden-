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
        
        Scanner scan = new Scanner(new File("C:\\Users\\Kishan Sagathiya\\Downloads\\1. Study\\DSA Stanford Practice\\knapsack1.txt"));
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
        HashMap<String, Integer> solutions = new HashMap<>();
        //int solution[][] = new int[numberOfItems][knapsackSize+1];
        
        System.out.println(optimalSolution(items,numberOfItems, knapsackSize, solutions ));

    }
    
    public static  int optimalSolution(List<Knapsack> items, int n, int maxW, HashMap<String, Integer> solutions){
        int ans = 0;
        
        if(n==0 || maxW==0){
            return 0;
        }
        
        int indexofLastElement = n-1;
        
        //System.out.println(items.size()+" " + indexofLastElement);
        if(items.get(indexofLastElement).weight > maxW){
            String key = (new Knapsack(indexofLastElement-1,maxW )).toString();
            if(!solutions.containsKey(key))
               solutions.put(key,optimalSolution(items, n-1, maxW, solutions));
            
            return solutions.get(key);       
        }
        
        String optimalAKey =(new Knapsack(indexofLastElement-1,maxW )).toString();
        String optimalBKey = (new Knapsack(indexofLastElement-1,maxW - items.get(indexofLastElement).weight )).toString();
        if(!solutions.containsKey(optimalAKey))
            solutions.put(optimalAKey,optimalSolution(items, n-1, maxW, solutions));
        int optimalA = solutions.get(optimalAKey);        
        if(!solutions.containsKey(optimalBKey))
            solutions.put(optimalBKey,optimalSolution(items, n-1, maxW - items.get(indexofLastElement).weight, solutions));
        int optimalB = solutions.get(optimalBKey) + items.get(indexofLastElement).value;
        
        
        if (optimalA > optimalB)
            ans =  optimalA;
        else 
            ans = optimalB;
        
        
        
        System.out.println(n+ " " +ans);
        return ans;
    }
 
}
