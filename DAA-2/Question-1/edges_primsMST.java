package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



class Edge{
    public int v1;
    public int v2;
    public int cost;
    
    @Override
    public String toString(){
        return v1+" "+v2+ " "+ cost + "\n"; 
    }
    
    
    public static void main(String args[]) throws FileNotFoundException{
        
        Scanner scan = new Scanner(new File("C:\\Users\\Kishan Sagathiya\\Downloads\\1. Study\\DSA Stanford Practice\\edges.txt"));
        int numberOfNodes = scan.nextInt();
        System.out.println("Number Of Nodes: "+numberOfNodes);
        int numberOfEdges = scan.nextInt();
        System.out.println("Number Of Edges: "+numberOfEdges);
        
        HashSet<Edge> edgeSet = new HashSet<>();
        for(;scan.hasNextLine();){
            String line = scan.nextLine();
            //System.out.println(line);
            Edge e = new Edge();
            e.v1 = scan.nextInt();
            e.v2 = scan.nextInt();
            e.cost = scan.nextInt();
            
            edgeSet.add(e); 
            //System.out.println(e.v1+" "+e.v2+" "+ e.cost);
        }
        
        HashSet<Edge> T = prim(edgeSet, numberOfNodes);
        
        System.out.println(T.toString());
        System.out.println(totalCost(T));

    }
    
    public static HashSet<Edge> prim(HashSet< Edge > edgeSet, int numberOfNodes){
        HashSet<Edge> T = new HashSet<>();
        HashSet<Integer> V =  new HashSet<>();
        
        
        Random rand = new Random();
        
        int randomNumber =0;
        while(randomNumber == 0)
            randomNumber = rand.nextInt(numberOfNodes+1);
        
        V.add(randomNumber);
        
        for(int vSize = V.size();vSize<numberOfNodes+1;vSize++){
            int minCost = Integer.MAX_VALUE;
            Edge minEdge = null;
            for(Integer u : V){
                for(Edge edge:edgeSet){
                    if(u.equals(edge.v1)){
                        if(!V.contains(edge.v2))
                            if(edge.cost<minCost){
                                minCost = edge.cost;
                                minEdge = edge;
                            }
                    }
                    
                    if(u.equals(edge.v2)){
                        if(!V.contains(edge.v1))
                            if(edge.cost<minCost){
                                minCost = edge.cost;
                                minEdge = edge;
                            } 
                    }
                            
                }
            }
            //System.out.println(minEdge.v1 +" "+ minEdge.v2);
            //System.out.println(V.size());
            if(minEdge != null){
                edgeSet.remove(minEdge);
                T.add(minEdge);
                V.add(minEdge.v1);
                V.add(minEdge.v2);
            }
        }
        
        return T;
    }
    
    public static long totalCost(HashSet<Edge> T){
        long sum = 0;
        
        for(Edge e : T){
            sum += e.cost;
        }
        
        return sum;
    }
    
    
    
}
