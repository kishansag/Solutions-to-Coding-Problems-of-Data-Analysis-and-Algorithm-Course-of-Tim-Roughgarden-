// 
package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



class TwoSum{
    HashMap<Long,Long> h; 
    HashMap<Integer, Integer> t;
    TwoSum() {
        this.h = new HashMap<>();
        this.t = new HashMap<>();
    }
    public void createHashMap(String path) throws FileNotFoundException{
        try (Scanner file = new Scanner(new File(path))) {
            while (file.hasNextLong()) {
                Long value = file.nextLong();
                this.h.put(value, value);                 
            }
        }
    }
    
    public Integer findT(){
        for(Map.Entry x : this.h.entrySet()){
            for(int temp= -10000;temp<10001;temp++){
                Long y = temp - (Long)x.getKey();
                if(this.h.containsKey(y)){
                    System.out.println(temp);
                    this.t.put(temp, temp);
                }
            }
        }
        return this.t.size();
    }
    
    
/*    public void printHashMap(){
        for (Map.Entry k : list.entrySet()) {
            HashMap<Integer, Integer> h = (HashMap)k.getValue();
            for (Map.Entry k2 : h.entrySet()) {
                System.out.print((Integer)k2.getKey()+","+(Integer)k2.getValue() + " ");
            }
            System.out.println();
        }
    }
    
*/
    public static void main(String args[]) throws FileNotFoundException{
      TwoSum twoSum = new TwoSum();
      
      twoSum.createHashMap("C:\\Users\\Kishan Sagathiya\\Downloads\\1. Study\\DSA Stanford Practice\\algo1-programming_prob-2sum.txt");
      //System.out.print(twoSum.h.toString()); 
      Integer Ans = twoSum.findT();
      System.out.println("\n"+Ans);
    } 
}
