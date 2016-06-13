//

//Change the package name accordingly
package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Practice{
    int indexOfPivot;
    int[] array;
    static int count = 0;
    public static void main(String args[]) throws FileNotFoundException{
        //Change the file path with the path where QuickSort.txt is stored on your local machine
        int[] input1 = textToIntArray("C:\\Users\\Kishan Sagathiya\\Downloads\\1. Study\\DSA Stanford Practice\\QuickSort.txt") ;
  //      int[] k = {3,5,15,8,9,2,11,7,0};
       
        int[] p = quickSort(input1, 0, input1.length -1); 
        for(int a : p){
            System.out.println(a);
       }
        
        System.out.println(count);
          
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
   
    public static Practice partition(int[] A, int left, int right){
        //Swap right and left to select last element as pivot
        System.out.println(left + " " + right);
//      Uncomment this to use median-of-three pivot rule         
/*        int median = median(A, left, right);
        
        int t = A[median];
        A[median] = A[left];
        A[left] = t;
*/        
//      Uncomment code snippet below to choose last element as pivot 
/*      int t = A[right];
        A[right] = A[left];
        A[left] = t;
*/

        //To choose pivot
        int pivot = A[left];
        int i = left +1;
        for(int j = left+1;j<right+1;j++){
           
            if(A[j]< pivot){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
            }
        }
        
        int temp = A[i-1];
        A[i-1] = A[left];
        A[left] = temp;
        
        Practice p = new Practice();
        p.array = A;
        p.indexOfPivot = i - 1;
        return p;
    }
    
    public static int[] quickSort(int[] A, int left , int right){
        if(left >= right)
            return A;
        Practice p = partition(A,left, right);
        count += (right -left);
        if(right - left < 2)
            return A;
    
        quickSort(A, left, p.indexOfPivot - 1);
        quickSort(A, p.indexOfPivot + 1, right);
        return A;
    }
    
    public static int median(int a[], int p, int r)
    {
        int m = (p+r)/2;
        if(a[p] < a[m])
        {
            if(a[p] >= a[r])
                return p;
            else if(a[m] < a[r])
                return m;
        }
        else
        {
            if(a[p] < a[r])
                return p;
            else if(a[m] >= a[r])
                return m;
        }
        return r;
    }
}
