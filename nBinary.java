import java.util.Scanner;

/**
 *
 * @author kishan
 */
public class Main {
    static int  MOD = 1000000007;
    static long fibonaci(long n)
    {
        long Fib[][] = new long[][]{{1,1},{1,0}};
        if (n == 0)
            return 0;
        power(Fib, n-1);

           return Fib[0][0];
    }
      
    static void multiply(long Fib[][], long M[][])
    {
        long a =  (Fib[0][0]*M[0][0] + Fib[0][1]*M[1][0])%MOD;
        long b =  (Fib[0][0]*M[0][1] + Fib[0][1]*M[1][1])%MOD;
        long c =  (Fib[1][0]*M[0][0] + Fib[1][1]*M[1][0])%MOD;
        long d =  (Fib[1][0]*M[0][1] + Fib[1][1]*M[1][1])%MOD;

        Fib[0][0] = a;
        Fib[0][1] = b;
        Fib[1][0] = c;
        Fib[1][1] = d;
    }
 

    static void power(long Fib[][], long n)
    {
        if( n == 0 || n == 1)
          return;
        long M[][] = new long[][]{{1,1},{1,0}};

        power(Fib, n/2);
        multiply(Fib, Fib);

        if (n%2 != 0)
           multiply(Fib, M);
    }    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        
        for(int i =0;i<t;i++){
            System.out.println(fibonaci(scan.nextLong()+2));
        }
        
    }
    
}


