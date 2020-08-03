package misc;
import java.util.*;

/*
* Multiplication Algorithm (a,b):
* 1. Initialize result to 0
* 2. While b is positive repeat steps 3 to 5
* 3. if b is odd number then add a to result
* 4. b=b/2 --halve the second number
* 5. a=a*2* --double the first number
* 6. Return res
**/
public class MuliplicationWithoutOp {
    public static long multiply(long a,long b){
        long res = 0;
        while(b>0){
            if(b%2!=0)
                res+=a;
            b=b/2;
            a=a*2;
        }
        return res;
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 2 numbers to multiply\n");
        long a = in.nextLong();
        long b = in.nextLong();
        System.out.println(multiply(a,b));
    }
}
