package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



class Median{
    PriorityQueue<Integer> hLow;
    PriorityQueue<Integer> hHigh;
    
    Median(){
    hHigh = new PriorityQueue();
    hLow = new PriorityQueue(11, new comparator());
    }
    
    private class comparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2){
            if(o1.compareTo(o2)>0)
                return -1;
            else 
        
                return 1;            
        }
    }
    public Integer createPriorityQueues(String path) throws FileNotFoundException{
        Integer sum = 0;
        try (Scanner file = new Scanner(new File(path))) {
            while (file.hasNextInt()) {
                Integer value = file.nextInt();
                this.hLow.add(value);
                sum += this.findMedian();
            }
        }
        sum = sum%10000;
        System.out.println(sum);
        return sum;
    }
    
    public Integer findMedian(){
        while((this.hLow.size()-this.hHigh.size())>1)
            this.hHigh.add(this.hLow.poll());
        if((this.hLow.peek()!= null) && (this.hHigh.peek()!= null)){
            while(this.hLow.peek()>this.hHigh.peek()){
                this.hHigh.add(this.hLow.poll());
                this.hLow.add(this.hHigh.poll());
            }
        }
     
        return this.hLow.peek();
    }
 
    public static void main(String args[]) throws FileNotFoundException{
      Median m = new Median();
      m.createPriorityQueues("C:\\Users\\Kishan Sagathiya\\Downloads\\1. Study\\DSA Stanford Practice\\Median.txt");
//      System.out.println(m.hLow.toString());
  //    System.out.println(m.hHigh.toString());
//      System.out.println(m.findSum());
    } 
}
