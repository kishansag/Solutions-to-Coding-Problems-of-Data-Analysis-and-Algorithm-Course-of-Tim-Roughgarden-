package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



class Job{
    public int weight;
    public int length;
    
    public Job(){
    }
    
    public int getDiff(){
        return (weight - length); 
    }
    
    public static void main(String args[]) throws FileNotFoundException{
        
        Scanner scan = new Scanner(new File("C:\\Users\\Kishan Sagathiya\\Downloads\\1. Study\\DSA Stanford Practice\\jobs.txt"));
        int numberOfJobs = scan.nextInt();
        Job[] job = new Job[10000];
        //int[] difference = null;
        for(int i=0;scan.hasNextLine();i++){
            job[i] = new Job();
            job[i].weight = scan.nextInt();
            job[i].length = scan.nextInt();
         //   difference[i] = job[i].weight - job[i].length;
        }
        
        /*for(Job j: job ){
            System.out.println(j.weight+" "+j.length);
        }*/
        
        sortAndPrintAns(job);
    }
    
    public static void sortAndPrintAns(Job[] job){
        int l = job.length;
        System.out.println("length: " +l);
        Job key;
        for(int i=1;i<l;i++){
            //System.out.println(i);
            key = job[i];
            int k;
            System.out.println("i " + i);
            for( k = i;k>0;k--){
                if(job[k-1].getDiff()<key.getDiff()){
                    job[k]=job[k-1];
                }
                else if (job[k-1].getDiff()>key.getDiff()){
                    break;
                }
                else if ((job[k-1].getDiff()==key.getDiff()) && (job[k-1].weight<key.weight)){
                        job[k]=job[k-1]; 
                }
                else if (job[k-1].getDiff()==key.getDiff()){
                        break; 
                }                
                
               // System.out.println(k+" diff: "+job[k-1].getDiff()+" "+"keydiff: "+key.getDiff());
             
            }
            

            
           // System.out.println("k: "+k);
            job[k] = key;  
           /* for(int a = 0;a<i+1;a++){
                System.out.println(a+". " +"length: " + job[a].length+", weight: "+ job[a].weight +", Diff: "+job[a].getDiff());
            }*/            
        }
        long sum = 0;
        int completionTime = 0;
        for(Job j:job){
            completionTime += j.length;
            sum += (completionTime*j.weight);
            //System.out.println(/*j.weight +" "+j.length + " "+*/ j.getDiff());
        }
        System.out.println(sum);
    }
}
