//Change the package name accordingly
package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Practice{
    long count = 0;
    int[] sortedArray ;
    public static void main(String args[]) throws FileNotFoundException{
        //Change the file path with the path where IntegerArray.txt is stored on your local machine
        int[] input1 = textToIntArray("C:\\Users\\Kishan Sagathiya\\Downloads\\1. Study\\DSA Stanford Practice\\IntegerArray.txt") ;

    
        Practice practice = sortAndCount(input1, 0, input1.length - 1);
        int length = practice.sortedArray.length;
        for(int i=0;i<length;i++){
           System.out.println(practice.sortedArray[i]);
        }
        
        System.out.println("\n"+practice.count+"\n");
        
    }
    private static Practice sortAndCount(int[] A, int start, int end){
        Practice p = new Practice();
        if(start == end){
            int[] a = {A[start]};
            p.sortedArray = a;
            return p;
        }
        int middle = (end + start)/2;
        Practice p1 = sortAndCount(A,start, middle);
        Practice p2 = sortAndCount(A, middle+1, end);
        Practice p3 = sortAndCountSplitInv(p1.sortedArray, p2.sortedArray);
        
        p.count = p1.count + p2.count +p3.count;
        p.sortedArray = p3.sortedArray;
            
        return p;
    }
    private static Practice sortAndCountSplitInv(int[] A, int[] B){
        int i = 0;
        int j = 0;
        int Alength = A.length;
        int Blength = B.length;
        int[] output= new int[Alength + Blength];
        Practice p = new Practice();
        for(int k = 0;k<output.length;k++){
            if(i<Alength && j< Blength){
                if(A[i]>B[j]){
                    output[k] = B[j];
                    p.count += (Alength - i);
                    j++;
                }
                else{
                    output[k] = A[i];
                    i++;
                } 
            }
            else if(i<Alength){
                output[k] = A[i];
                i++;
            }
            else if(j<Blength){
                output[k] = B[j];
                j++;                
            }
        }
        
        p.sortedArray = output;
        return p;
    }
    
    public static int[] textToIntArray(String inputFileName) throws FileNotFoundException{
        ArrayList<Integer> list= new ArrayList();
        try (Scanner file = new Scanner(new File(inputFileName))) {
            int i =0;
            while (file.hasNextInt()) {
                //System.out.println(file.nextLine());
                int token = file.nextInt();
                list.add(token);
                i++;
            }
        }

        int length = list.size();        
        Integer[] a = new Integer[length];
        list.toArray(a);
        

        int[] b = new int[length];
        
        for(int k = 0;k<length;k++){
            b[k] = a[k];
        }
        return b;
    }
    
}
