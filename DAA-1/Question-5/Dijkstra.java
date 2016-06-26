
package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



 
class Graph{
    int noOfVertices;
    HashMap<Integer, HashMap<Integer, Integer>> list; 
    
//    private class Vertex{
//        Integer label;
//        Integer weight;
//        
//        Vertex(Integer label, Integer weight){
//            this.label = label;
//            this.weight = weight;
//        }
//    }
    Graph(){
        list = new HashMap<>();
    }
    
    public void createGraph(String path) throws FileNotFoundException{
        try (Scanner file = new Scanner(new File(path))) {
            while (file.hasNextLine()) {
                String[] fragments = file.nextLine().split("\\s+");
                Integer key = Integer.parseInt(fragments[0]);
                HashMap<Integer, Integer> h = new HashMap<>();
                for(int i=1;i<fragments.length;i++){
                    String[] further = fragments[i].split(",");
//                    System.out.println(further[0]+" "+further[1]+ " ");
                    h.put(Integer.parseInt(further[0]), Integer.parseInt(further[1]));
                    noOfVertices++;
                }
//                System.out.println(key);
                list.put(key, h);                 
            }
        }
    }
    
    public void printGraph(){
        for (Map.Entry k : list.entrySet()) {
            HashMap<Integer, Integer> h = (HashMap)k.getValue();
            for (Map.Entry k2 : h.entrySet()) {
                System.out.print((Integer)k2.getKey()+","+(Integer)k2.getValue() + " ");
            }
            System.out.println();
        }
    }
    
    public HashMap dijkstra(Integer k){
        HashMap<Integer, Integer> S = new HashMap<>();
        HashMap<Integer, Integer> V = new HashMap<>();

        for(int i=1;i<201;i++){
            V.put(i,1000000);
        }
//        System.out.println(S.size());
//        System.out.println(V.size());
        
        S.put(k, 0);
        V.remove(k);
//        System.out.println(S.size());
//        System.out.println(V.size());

        ReturnForMinDist returnForMinDist;
        while(!V.isEmpty()){
            returnForMinDist = minDistance(S,V);
            S = returnForMinDist.A;
            V = returnForMinDist.B;
        }
        
        return S;
    }
    
    private class ReturnForMinDist{
        HashMap<Integer, Integer> A;
        HashMap<Integer, Integer> B;
        
        ReturnForMinDist( HashMap<Integer, Integer> A, HashMap<Integer, Integer> B){
            this.A =A;
            this.B =B;
        }
    }
    
    public ReturnForMinDist minDistance(HashMap<Integer, Integer> A, HashMap<Integer, Integer> B){
        Integer minValue = 1000000;
        Integer minKey=1;
        for (Map.Entry k : A.entrySet()) {
            HashMap<Integer, Integer> h = list.get((Integer)k.getKey());
            
            for (Map.Entry k2 : B.entrySet()) {
                if(h.containsKey((Integer)k2.getKey())){
                    Integer x = (Integer)k.getValue()+h.get((Integer)k2.getKey());
                    if((Integer)k2.getValue()>x)
                        k2.setValue(x);
                    if((Integer)k2.getValue()<minValue){
                        minValue = (Integer)k2.getValue();
                        minKey = (Integer)k2.getKey();
                    }
                }                
            }
        }
    //    System.out.println(minKey +" "+minValue);
        A.put(minKey, minValue);
        B.remove(minKey);                       
        return new ReturnForMinDist(A, B);
    }
    
    public static void printHashMap(HashMap<Integer, Integer> A){
        for (Map.Entry k : A.entrySet()) {
            System.out.println((Integer)k.getKey()+" "+(Integer)k.getValue());
        }
    }
    
    public static void printAns(HashMap<Integer, Integer> A){
        //7,37,59,82,99,115,133,165,188,197
        System.out.print(A.get(7)+",");
        System.out.print(A.get(37)+",");
        System.out.print(A.get(59)+",");
        System.out.print(A.get(82)+",");
        System.out.print(A.get(99)+",");
        System.out.print(A.get(115)+",");
        System.out.print(A.get(133)+",");
        System.out.print(A.get(165)+",");
        System.out.print(A.get(188)+",");
        System.out.print(A.get(197));
    }
    public static void main(String args[]) throws FileNotFoundException{
        Graph g =  new Graph();
        
        g.createGraph("C:\\Users\\Kishan Sagathiya\\Downloads\\1. Study\\DSA Stanford Practice\\dijkstraData.txt");
    //    g.printGraph();

        HashMap<Integer, Integer> Ans = g.dijkstra(1);
        Graph.printAns(Ans);
    }
}
