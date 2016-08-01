package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


//Doesnt check for negative cycles
class FloydWarshall{

    public static void main(String args[]) throws FileNotFoundException{
        
        Scanner scan = new Scanner(new File("C:\\Users\\Kishan Sagathiya\\Downloads\\1. Study\\DSA Stanford Practice\\g2.txt"));
        int numberOfVertices = scan.nextInt();
        int numberOfEdges = scan.nextInt();
        int INF = 9999;
        long distanceMatrix[][] = new long[numberOfVertices+1][numberOfVertices+1];
        
        for(int i=0;i<numberOfVertices+1;i++){
            for(int j=0;j<numberOfVertices+1;j++){
                if(i!=j){
                    distanceMatrix[i][j] =INF;   
                }
            }
        }
        
        while(scan.hasNext()){
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            int w = scan.nextInt();
            
            distanceMatrix[v1][v2] = w;    
        }
        for(int k=1;k<numberOfVertices+1;k++){
            for(int i=1;i<numberOfVertices+1;i++){
                for(int j=1;j<numberOfVertices+1;j++){

                    if((distanceMatrix[i][k] != INF) && (distanceMatrix[k][j] != INF)){
                        if(distanceMatrix[i][j] > distanceMatrix[i][k]+distanceMatrix[k][j]){
                            distanceMatrix[i][j] = distanceMatrix[i][k]+distanceMatrix[k][j];
                            
                        }
                    }
                }
            }
        }
        
        boolean hasCycle = false;
        long min = INF;
        for(int i=1;i<numberOfVertices+1;i++){
            for(int j=1;j<numberOfVertices+1;j++){
                if(min > distanceMatrix[i][j])
                    min = distanceMatrix[i][j];
                
            }
           
            
        }
        
        System.out.println("Min: "+ min);
    }
}
